import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @author Samuel Gröner
 * @author Chunquan Cheng
 * @teamName A
 * @version 1.1
 *
 * @implNote :
 *     @version 1.0-2020.11.16-01: working version for TC1 and TC2, apparently to slow for TC3
 *              1.1-2020.11.17-01: improved calc time @getInput, using BufferedReader instead of Scanner
 *              1.1-2020.11.17-02: improved calc time @kSmallestList, instead of using an array we are now using a heap
 *
 * */

public class Tickets {
    /**@param k
     * saves the variable k-smallest as a static int
     *
     * */
    static int k = -1;

    /**@main
     * starts the program
     *
     * */

    public static void main(String[] args) throws IOException {

        kSmallestList(getInput());
    }
    /**@getInput
     * declares @param K
     * saves the input after K in an array
     *
     * @return input from console
     * */
    public static int[] getInput() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(in.readLine());
        int[] input = new int[i];
        k = Integer.parseInt(in.readLine());

        for (int j = 0; j < i; j++) {

            input[j] = Integer.parseInt(in.readLine());
        }
        in.close();
        return input;
    }
    /**@kSamellestList
     * @param input is the return value of @getInput
     * makes a k sized List of the k-smallest Values from @param input
     * if it gets a 0 the value of the k smallest value will be printed
     *
     * */
    public static void kSmallestList(int[] input) throws IOException {

        PriorityQueue<Integer> kList = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num:input) {

            if (num == 0) {
                generateOutput(kList);
                continue;
            }
            if (kList.size() == 0) {
                kList.add(num);
                continue;
            }
            if (num >= kList.peek()&&kList.size()==k) {
                continue;
            }
            kList.add(num);

            if (kList.size() > k) {
                kList.remove(kList.peek());
            }
        }
    }
    /**@genrateOutput
     * @param kList a List with the k-smallest values
     * prints the current k-smallest value
     *
     * @// TODO: 17.11.2020 find out why BufferedWriter isnt working
     * */
    private static void generateOutput(PriorityQueue<Integer> kList) throws IOException {

        /* doesnt work, i dunno if i did something wrong here
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        if (kList.size() < k) {
            out.write(-1);
        }else{
            out.write(kList.peek());
        }
        out.close();
        * OUTPUT:￿
        * defentitly something wrong
        */
        if (kList.size() < k) {
            System.out.println(-1);
        }else{
            System.out.println(kList.peek());
        }
    }
}
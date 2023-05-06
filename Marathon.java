import java.io.*;
import java.util.*;


/**
 * @author Samuel Gröner
 * @author Chunquan Cheng
 * @teamName A
 * @version 1.0
 *
 * @implNote :
 *     @version 1.0-2020.11.27-01: working version, prob to slow
 *              1.0-2020.11.27-02: using BufferedReader for faster reading times
 *              1.0-2020.11.27-03: using an ArrayList for easy reordering of the starting List
 *
 * */

public class Marathon {

    /**@main
     * starts the program
     *
     * */
    public static void main(String[] args) throws IOException {

        overtakesMarathon(getInput());
    }
    /**@overtakesMarathon
     * @param input has the data from the input
     * calculates the minimum overtakes for a marathon with given start/finish order
     * self expanding loop, so it works with the sub-parts
     *
     * */
    private static void overtakesMarathon(List<Integer> input) {

        int startFor;
        int length = input.get(0);
        int end = 2*length+1;
        int sum = 0;
        int start = 1;
        int startTwoFor;

        while(true){
            for (startTwoFor = start+length; startTwoFor < end; startTwoFor++) {

                int num = input.get(startTwoFor);
                for (startFor = startTwoFor - length; startFor < start+length; startFor++) {
                    if (num == input.get(startFor)) {
                        sum += startFor-(startTwoFor-length);
                        input.remove(startFor);
                        input.add(startTwoFor-length,num);
                        break;
                    }
                }
            }
            System.out.println(sum);
            if (end >= input.size()) {
                break;
            }
            start = end+1;
            sum = 0;
            length = input.get(end);
            end += 2*length+1;
        }
    }

    /**@getInput
     * writes the input in an String then rebuilds it in an array
     * then rewrites the input in an ArrayList
     *
     * @return input from console
     * */
    public static List<Integer> getInput() throws IOException {

        String input = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(bufferedReader.readLine());
        for (int j = 0; j < i; j++) {
            input += bufferedReader.readLine() + " ";
            input += bufferedReader.readLine() + " ";
            input += bufferedReader.readLine() + " ";
        }
        bufferedReader.close();
        int[] sourceArray = Arrays.stream(input.split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        List<Integer> arrayList = new ArrayList<>();
        for (int num:sourceArray) {
            arrayList.add(num);
        }
        return arrayList;
    }
}

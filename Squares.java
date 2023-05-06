import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Squares {
  /*
4
1 2
2 2
3 1
2
2 2
3 4
2 6
2 2 2 3 3 3
d
*/
  public static void main(String[] args) {
    try {
      ArrayList<int[]> input = getInput();
      StringBuilder out = new StringBuilder();
      for (int[] in:input) {
        out.append(masterTheorem(sum(in, in[0]), in)).append("\n");
      }
      System.out.print(out.toString());
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  private static int masterTheorem(double sum, int[] in){
    if (sum == 1){
      return 0;
    }
    if (sum < 1){
      return in[0] == 2?1:0;
    }
    if (sum > 1){
      double c = sum(in,2);
      return c == 1?1:0;
    }
    return 0;
  }

  private static double sum(int[] numbers, int k){
    double sum = 0;
    for (int i = 2; i < numbers.length; i++) {
      sum += Math.pow(1/(double)numbers[i],k);
    }
    return sum;
  }

  private static ArrayList<int[]> getInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(input.readLine());
    ArrayList<int[]> inputSquares = new ArrayList<>();

    for(int i = 0; i < t; i++) {
      String[] line = input.readLine().split(" ");
      int k = Integer.parseInt(line[0]);
      int m = Integer.parseInt(line[1]);
      int[] in = new int[m+2];
      in[0] = k;
      in[1] = m;
      String[] line2 = input.readLine().split(" ");
      for (int j = 2; j < m+2; j++) {
        in[j] = Integer.parseInt(line2[j-2]);
      }
      inputSquares.add(in);
    }
    input.close();
    return inputSquares;
  }
}

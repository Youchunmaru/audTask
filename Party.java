import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Party {

  public static void main(String[] args){

    int[] array = {9,14,3,2,43,11,58,22,98,45,23,15,78,65,32};
    getMedian(array);
  }
  public static int getMedian(int[] array){
    int groups = 1;
    for (int j = 0; j < array.length; j++) {
      //insertion sort
      for (j = j+1; j < 5*groups; j++) {
        int save = array[j];
        int i = j-1;
        while ((i > -1) && (array[i] > save)) {
          array[i + 1] = array[i];
          i--;
        }
        array[i + 1] = save;
      }
      groups++;
      }
    for (int number:array
    ) {
      System.out.println(number + "\n");
    }
    return -1;
  }

  public static String[] getInput() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    for (int i = 0; i < Integer.parseInt(bufferedReader.readLine()); i++) {
      String line[] = bufferedReader.readLine().split(" ");
      input += line[0].concat(" " + line[1]) + ";";

      for (int j = 0; j < Integer.parseInt(line[1]); j++) {
        input += bufferedReader.readLine() + ";";
      }
      input += "\n";
    }
    return input.split("\n");
  }
}

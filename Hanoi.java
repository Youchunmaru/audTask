import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Samuel Gröner
 *
 * Übungsblatt 01
 * Aufgabe 1.6 b
 *
 * Implements a calcuator for the towers of hanoi.
 * It calculates the state ot the towers for a given number of shifts
 * and then returns the state into the console.
 * */
public class Hanoi {

  /**
   * 
   * {@link #towerCalculation(long[][])}
   * @throws IOException if an I/O error occurs
   * */
  public static void main(String[] args) {
    try {
      towerCalculation(getInput());
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  /**
   * Calculates the state of the towers for a given number of shifts.
   * 
   * @param input has the data of the testcases
   * */
  public static void towerCalculation(long[][] input){
    long[][] hanoiInput = input;

    for (long hanoi[]: hanoiInput) {

      long moves = (long) Math.pow(2,hanoi[0]);
      int[][] towers = new int[3][(int)hanoi[0]];

      int pos = 0;
      for (int diskNumber = 1; diskNumber <=hanoi[0] ; diskNumber++) {

        double towerNumber = (hanoi[1]+moves/2)/moves % 3;

        if (diskNumber%2 == 0) {
          towerNumber = (3-towerNumber)%3;
        }
        moves = moves/2;
        towers[(int)towerNumber][pos]=(int)hanoi[0]-diskNumber + 1;
        pos++;
      }
      System.out.print(towersToString(towers));
    }
  }

  /**
   * Converts the state data from towerCalculation() into a String.
   * For each tower one row, represented by "[towerNumber]: ",
   * behind the ": " each disk the tower contains split by "|"
   *
   * @param towers has the build of the tower saved as array
   * @return state of the towers as Sting
   * */
  private static String towersToString(int[][] towers) {
    String output = "";
    int i = 1;
    for (int tower[]: towers) {
      output =output + i + ": ";
      boolean second = false;
      for (int disknumber: tower) {

        if (disknumber == 0) {
          continue;
        }
        if (second) {
          output = output + "|";
        }
        output = output + disknumber;
        second = true;
      }
      output = output + "\n";
      i++;
    }
    return output;
  }

  /**
   * Reads the input.
   * The first row contains the number of test cases t.
   * The following t rows contains the number of disks([0]) and shifts([1]).
   * The input is saved in an array.
   *
   * @implNote the number of shifts can be quit big, which means we have to save it as Long
   * @return input from console as array
   * */
  public static long[][] getInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(input.readLine());
    long[][] hanoiInput = new long[t][2];

    for(int i = 0; i < t; i++) {

      String[] line = input.readLine().split(" ");
      hanoiInput[i][0] = Long.parseLong(line[0]);
      hanoiInput[i][1] = Long.parseLong(line[1]);
    }
    input.close();
    return hanoiInput;
  }
}
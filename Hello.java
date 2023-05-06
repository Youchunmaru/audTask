import java.io.*;

/**
 * @author Samuel Gröner
 *
 * Übungsblatt 0
 * Aufgabe 0.2
 * */
public class Hello {
/**
 * Reads input from the console. The first input determines the number of the following inputs(names).
 * Then outputs a String welcoming each name from the input.
 *
 * @throws IOException If an I/O error occurs
 * */
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int i = Integer.parseInt(bufferedReader.readLine());
    String name = "";
    for (int j = 0; j < i; j++) {
      name += "Hallo " + bufferedReader.readLine() + "!\n";
    }
    bufferedReader.close();

    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    bufferedWriter.write(name);
    bufferedWriter.close();
  }
}

import java.io.*;
import java.util.ArrayList;

public class Kuhhandel {

  public static void main(String[] args) throws IOException {

    ArrayList<ArrayList<String[]>> casesList = getInput();
    String output = "";

    for (int i = 0; i < casesList.size(); i++) {
      ArrayList<ArrayList<String[]>> sellersBuyers = getSellersBuyers(casesList.get(i));
      ArrayList<String[]> sellers = sellersBuyers.get(0);
      ArrayList<String[]> buyers = sellersBuyers.get(1);
      String[] out = new String[casesList.get(i).size()];

      int size = sellers.size();
      for (int j = 0; j < size; j++) {
        String[] seller = sellers.get(j);
        String[] buyer = null;
        boolean sold = false;
        String preoutput = "";
        int current = 0;
        int max = 0;
        int index = -1;
        int pos = 0;
        int x = j;
        for (int k = 0; k < buyers.size();k++) {
          buyer = buyers.get(k);
          /*if ((Integer.parseInt(seller[0]) < Integer.parseInt(buyer[0]))) {
            break;
          }*/
          if (Integer.parseInt(seller[2]) <= -(Integer.parseInt(buyer[2]))) {
            if (Integer.parseInt(seller[0]) < Integer.parseInt(buyer[0]) && !sold) {
              preoutput += seller[1] + "," + buyer[1] + "," + seller[2] + "\n";
              sold = true;
              index++;
              for (int l = 0; l < sellers.size(); l++) {
                String[] seller2 = sellers.get(l);
                if (Integer.parseInt(seller2[0]) < Integer.parseInt(buyer[0])){
                  if (Integer.parseInt(seller[2]) >= Integer.parseInt(seller2[2])){
                    preoutput += seller2[1] + "," + buyer[1] + "," + seller2[2] + "\n";
                    index++;
                    x = l;
                  }
                }
              }
              pos =Integer.parseInt(buyer[0]);
              break;
            }
            current = -Integer.parseInt(buyer[2]);
            if (current>max) {
              sold = true;
              preoutput += seller[1] + "," + buyer[1] + "," + seller[2] + "\n";
              max = current;
              pos = Math.max(Integer.parseInt(seller[0]), Integer.parseInt(buyer[0]));
              index++;
            }
          }
        }
        if(sold) {
          String[] holder = preoutput.split("\n");
          out[pos] = holder[index];
          buyers.remove(buyer);
          sellers.remove(x);
          j--;
          size--;
        }
      }
      for (String o:out) {
        if (o != null) {
          output += o + "\n";
        }
      }
    }
    System.out.print(output);
  }
  static ArrayList<ArrayList<String[]>> getSellersBuyers(ArrayList<String[]> bets) {
    ArrayList<String[]> sellers = new ArrayList<>();
    ArrayList<String[]> buyers = new ArrayList<>();
    int size = bets.size();
    for (String[] bet : bets) {
      if (Integer.parseInt(bet[2]) < 0) {
        buyers.add(bet);
      }
      else {
        sellers.add(bet);
      }
    }
    ArrayList<ArrayList<String[]>> sellersBuyers = new ArrayList<>();
    sellersBuyers.add(sellers);
    sellersBuyers.add(buyers);
    return sellersBuyers;
  }

  static ArrayList<ArrayList<String[]>> getInput() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(input.readLine());
    ArrayList<ArrayList<String[]>> casesList = new ArrayList<>();
    for (int i = 0; i < cases; i++) {
      int bets = Integer.parseInt(input.readLine());
      ArrayList<String[]> betList = new ArrayList<>();
      for (int j = 0; j < bets; j++) {
        String appended = j + " " + input.readLine();
        String[] bet = appended.split(" ");
        betList.add(bet);
      }
      casesList.add(betList);
    }
    return casesList;
  }
}
/*
1
9
Anton 1900
Josef 1500
Sieglinde -1400
Erwin 1800
Florian -1600
Christina -2000
Peter -1600
Hans 1300
Xaver 1500
 */

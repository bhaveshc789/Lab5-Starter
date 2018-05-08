package lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static HashMap<String, Integer> result = new HashMap<String, Integer>();

  public static void main(String[] args) {
    try {
      File f = new File("src/lab5/Test.java");
      BufferedReader b = new BufferedReader(new FileReader(f));
      String readLine = "";
      while ((readLine = b.readLine()) != null) {
        System.out.println(readLine);
        parser(readLine);
      }
      System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void parser(String s) {
    StringTokenizer str = new StringTokenizer(s);
    while(str.hasMoreTokens()) {
      String word = str.nextToken();
      if(result.containsKey(word)) {
        int temp = result.get(word) + 1;
        result.put(word, temp);
      } else {
        result.put(word, 1);
      }
    }
  }
}
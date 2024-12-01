import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
  public static void main(String[] args) {
    String filePath = "input.csv";
    try {
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String line;
      ArrayList<Integer> array1 = new ArrayList<>();
      ArrayList<Integer> array2 = new ArrayList<>();

      while ((line = br.readLine()) != null) {
        String[] values = line.trim().split("\\s+");
        array1.add(Integer.parseInt(values[0]));
        array2.add(Integer.parseInt(values[1]));
      }
      br.close();
      
      // This was part 1

      Collections.sort(array1);
      Collections.sort(array2);

      int difference = 0;

      for (int i = 0; i < array1.size(); i++) {
        int tempDifference = array1.get(i) - array2.get(i);
        if (tempDifference < 0) tempDifference *= -1;
        difference += tempDifference;
      }

      // Now part 2

      HashMap<Integer, Integer> hm = new HashMap<>();

      for (int number : array2) {
        if (hm.containsKey(number)) {
          int currentValue = hm.get(number);
          hm.replace(number, ++currentValue);
        } else {
          hm.put(number, 1);
        }
      }

      int similarityScore = 0;
      for (int i : array1) {
        if (hm.containsKey(i)) {
          similarityScore += i * hm.get(i);
        }
      }

      System.out.println(similarityScore);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


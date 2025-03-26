import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class map_count {
  public static void main(String[] args) {
    String[] fruits = {"apple", "banana", "apple", "orange"} ; 
    ArrayList<String> list = new ArrayList<>(Arrays.asList(fruits)) ; //passing array in the constructor of the ArrayList
    
    HashMap<String , Integer> map = new HashMap<>() ; 

    for (String word : list) {
      map.put(word, map.getOrDefault(word, 0)+1) ; 
    }

    Object [][] arrr = new Object[map.size()][2] ; // using an object array to store different datatypes

    int idx = 0 ; 
    for (String key : map.keySet()) {
      arrr[idx][0] = key ; 
      arrr[idx][1] = map.get(key) ; 
      idx++ ; 
    }

    for (Object[] objects : arrr) { // printing
      System.out.print(objects[0]+" : "+objects[1]+"  ");
    }
  }
}

import java.util.Arrays;
import java.util.HashSet;

public class symmetry {
  public static void main(String[] args) {
    HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3)) ;
    HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5)) ;

    HashSet<Integer> ans = new HashSet<>() ; 

    for (Integer num : set1) {
      if (!ans.contains(num) && !set2.contains(num)) {
        ans.add(num) ; 
      }
    }

    for (Integer num : set2) {
      if (!ans.contains(num) && !set1.contains(num)) {
        ans.add(num) ; 
      }
    }

    System.out.println(ans);
  }
}

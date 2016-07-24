import java.util.*;

public class PalindromePermutation {
  
  private static boolean isPermutationOfPalindrome(String input) {
    input = input.trim();
    if (input==null || input.length()==0)
      return true;
    String canonicalForm = getCanonical(input);
    char[] content = canonicalForm.toCharArray();
    Arrays.sort(content);
    boolean oddFound = false;
    int counter = 1;
    char prev = content[0];
    for (int i=1; i<content.length; i++) {
      if (content[i] == prev) {
        counter++;
        continue;
      }
      if (counter%2==1) {
        if (oddFound)
          return false;
        oddFound = true;
      } 
      prev = content[i];
      counter = 1;
    }
    if (counter%2==1) {
      if (oddFound)
        return false;
    }
    return true;
  }
  
  private static String getCanonical(String input) {
    input = input.toLowerCase();
    List<Character> letters = new LinkedList<>();
    for (int i=0; i<input.length(); i++) {
      if (input.charAt(i) != ' ')
        letters.add(input.charAt(i));
    }
    char[] content = new char[letters.size()];
    int i = 0;
    for (char c : letters) {
      content[i] = c;
      i++;
    }
    Arrays.sort(content);
    return new String(content);
  }
}

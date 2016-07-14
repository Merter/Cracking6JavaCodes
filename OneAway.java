import java.util.*;


public class OneAway {

  private static boolean checkOneAway(String from, String to) {
    int fromLength = from.length();
    int toLength = to.length();
    if (Math.abs(fromLength-toLength) > 1)
      return false;
  
    String fromCanonical = from.toLowerCase();
    String toCanonical = to.toLowerCase();
    Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
    for (Character c : fromCanonical.toCharArray()) {
      Integer count = charCounts.get(c);
      if (count == null)
        charCounts.put(c, 1);
      else
        charCounts.put(c, count+1);
    }
    
    boolean addedOrReplaced = false;
    for (Character c : toCanonical.toCharArray()) {
      Integer count = charCounts.get(c);
      if (count == null) {
        if (addedOrReplaced)
          return false;
        addedOrReplaced = true;
      } else {
        if (count == 1)
          charCounts.remove(c);
        else
          charCounts.put(c, count-1);
      }
    }
    int diff = 0;
    for (Map.Entry<Character, Integer> entry : charCounts.entrySet())
    	diff += entry.getValue();
    if (diff > 1)
    	return false;
    return true;
  }
  
  public static void main(String[] args) {
    if (!checkOneAway("pale", "pale"))
      System.out.println("Error @1");
    if (!checkOneAway("pale", "pal"))
      System.out.println("Error @2");
    if (!checkOneAway("pale", "pales"))
      System.out.println("Error @3");
    if (!checkOneAway("pale", "bale"))
      System.out.println("Error @4");
    if (checkOneAway("pale", "pallee"))
      System.out.println("Error @5");
    if (checkOneAway("cc", "b"))
      System.out.println("Error @6");
  }

}

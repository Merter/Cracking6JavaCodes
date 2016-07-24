
public class IntersectingLinkedLists <T> {

  private class Node {
    T item;
    Node next;
  }
  
  public Node isIntersecting(Node head1, Node head2) {
    for (Node node1=head1; node1!=null; node1=node1.next) {
      for (Node node2=head2; node2!=null; node2=node2.next) {
        if (node1 == node2)
          return node1;
      }   
    }
    return null;
  }
  
  public Node isIntersectingWithSet(Node head1, Node head2) {
    Set<Node> set = new HashSet<>();
    for (Node node1=head1; node1!=null; node1=node1.next)
      set.add(node1);
    for (Node node2=head2; node2!=null; node2=node2.next)
      if (set.contains(node2))
        return node2;
    return null;
  }

}

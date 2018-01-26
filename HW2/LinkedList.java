//LinkedList.java
//inserts,sorts,and searches in a linked list  
class LinkedList {
  public Node head;

  public void LinkedList() {
    head = null;
  }
  // insert a chesspiece into the linked list
  public void insert(ChessPiece newC) {
    Node latest = new Node(newC);
    latest.next = head;
    head = latest;
  }
  // searches through linked list and returns the chesspiece at a specified
  // col and row
  public ChessPiece find(int col, int row) {
    Node curr = head;
    while (curr != null) {
      if ((curr.c).getCol() == col && (curr.c).getRow() == row) {
        return curr.c;
      }
      curr = curr.next;
    }
    return null;
  }
  //checks to see if there is only one piece with the same col and row
  public boolean valid(int col, int row) {
    Node curr = head;
    while (curr != null) {
      if ((curr.c).getCol() == col && (curr.c).getRow() == row) {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }
  //goes through linked list checking to see pieces are attacking
  public boolean traverse(ChessPiece testPiece) {
    Node curr = head;
    while (curr != null) {
      //only check if the colors are opposite
      if((curr.c).getColor() != testPiece.getColor()) {
        if (testPiece.isAttacking(curr.c)) {
          return true;
        }
      }
      curr = curr.next;
    }
    return false;
  }
}

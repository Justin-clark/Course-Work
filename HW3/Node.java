//Node.java
//creates nodes out of chesspieces

class Node {
  ChessPiece c;
  Node next;

  public Node(ChessPiece newC){
    c = newC;
    next = null;
  }
}

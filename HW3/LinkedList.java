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
  //goes through linked list to update a ChessPiece
  public void update(ChessPiece test, int endCol, int endRow) {
    Node curr = head;
    while (curr != null) {

      if (curr.c == test)  {
        (curr.c).setCol(endCol);
        (curr.c).setRow(endRow);
      }
      curr = curr.next;
    }
  }
  //goes through linked list to delete the ChessPiece
  public void delete(ChessPiece to_delete) {
    Node curr = head;

    if(head.c == to_delete) {
      head = head.next;
      return;
    }
    while (curr.next != null) {
      if ((curr.next).c == to_delete) {
        curr.next = curr.next.next;
        return;
      }
      curr = curr.next;
    }
  }

  public ChessPiece findKing(String colorChecker) {
    Node curr = head;
    while(curr != null) {
      if (curr.c instanceof King && (curr.c).getColor() == colorChecker) {
        ChessPiece king = new King(colorChecker,curr.c.getCol(),curr.c.getRow());
        return king;
      }
      curr = curr.next;
    }
    return null;
  }

  public boolean attackingKing(int kingCol, int kingRow, String colorChecker,LinkedList list) {
    Node curr = head;
    while(curr != null) {
      if (curr.c.getColor() != colorChecker && curr.c.canMove(kingCol,kingRow,list)) {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }
}

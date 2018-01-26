//ChessPiece.java
//ChessPiece superclass that has all pieces as subclasses

class ChessPiece {
  public int col;
  public int row;
  public String color;

  public int getCol() {
    return col;
  }
  public int getRow() {
    return row;
  }
  public void setCol(int newCol) {
    col = newCol;
  }
  public void setRow(int newRow) {
    row = newRow;
  }
  public String getColor() {
    return color;
  }
  public boolean isAttacking(ChessPiece c) {
    return true;
  }
  public boolean canMove(int endCol, int endRow, LinkedList list) {
    return true;
  }
}

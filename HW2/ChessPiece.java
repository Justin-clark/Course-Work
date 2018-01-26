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
  public String getColor() {
    return color;
  }
  public boolean isAttacking(ChessPiece c) {
    return true;
  }
}

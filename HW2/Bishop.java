// Bishop.java
// class for bishops

class Bishop extends ChessPiece{
  // constructor
  public Bishop(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  // checks to see if a Bishop is attacking a Chesspiece
  public boolean isAttacking(ChessPiece c) {
    //checks for diagonals
    if((Math.abs(col - c.col)) == (Math.abs(row - c.row))) {
      return true;
    }
    return false;
  }
}

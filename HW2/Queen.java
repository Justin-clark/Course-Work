// Queen.java
// class for queens

class Queen extends ChessPiece{
  // constructor
  public Queen(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  // checks to see if a Queen is attacking a Chesspiece
  public boolean isAttacking(ChessPiece c) {
    // checks for columns and rows
    if((col == c.col) || (row == c.row)) {
      return true;
    }
    // checks for diagonals
    if((Math.abs(col - c.col)) == (Math.abs(row - c.row))) {
      return true;
    }
    return false;
  }



}

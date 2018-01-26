// King.java
// class for kings

class King extends ChessPiece {
  // constructor
  public King(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  // checks to see if a King is attacking a Chesspiece
  public boolean isAttacking(ChessPiece c) {
    // checks for row one spot away
    if((Math.abs(col - c.col)) == 1 && (Math.abs(row - c.row)) == 0) {
      return true;
    }
    // checks for col one spot away
    if((Math.abs(col - c.col)) == 0 && (Math.abs(row - c.row)) == 1) {
      return true;
    }
    // checks for diagonals one spot away
    if((Math.abs(col - c.col)) == 1 && (Math.abs(row - c.row)) == 1) {
      return true;
    }

    return false;
  }

}

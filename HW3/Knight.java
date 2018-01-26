// Knight.java
// class for knights

class Knight extends ChessPiece {
  // constructor
  public Knight(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  // checks to see if a Knight is attacking a Chesspiece
  public boolean isAttacking(ChessPiece c) {
    // checks for far left and right col/row
    if((Math.abs(col - c.col)) == 2 && (Math.abs(row - c.row)) == 1) {
      return true;
    }
    // checks for close left and right col/row
    if((Math.abs(col - c.col)) == 1 && (Math.abs(row - c.row)) == 2) {
      return true;
    }
    return false;
  }
  //can knight move to desired location
  public boolean canMove(int endCol, int endRow, LinkedList list) {
    // checks for far left and right col/row
    if((Math.abs(col - endCol)) == 2 && (Math.abs(row - endRow)) == 1) {
      return true;
    }
    // checks for close left and right col/row
    if((Math.abs(col - endCol)) == 1 && (Math.abs(row - endRow)) == 2) {
      return true;
    }
    return false;
  }
}

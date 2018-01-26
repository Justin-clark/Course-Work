// Rook.java
// class for rooks

class Rook extends ChessPiece {
  // constructor
  public Rook(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  // checks to see if a Rook is attacking a Chesspiece
  public boolean isAttacking(ChessPiece c) {
    // checks for columns and rows
    if((col == c.col) || (row == c.row)) {
      return true;
    }
    return false;
  }
}

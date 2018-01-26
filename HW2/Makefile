
# Justin Clark
# judclark
# Makefile
# Uses macros to create ChessBoard.jar or to clean ChessBoard.class files

JAVASRC    = ChessBoard.java Bishop.java ChessPiece.java King.java Knight.java LinkedList.java Node.java Queen.java Rook.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = ChessBoard
CLASSES    = ChessBoard.class Bishop.class ChessPiece.class King.class Knight.class LinkedList.class Node.class Queen.class Rook.class
JARFILE    = ChessBoard.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest *.class $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)

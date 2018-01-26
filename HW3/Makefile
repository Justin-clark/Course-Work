
# Justin Clark
# judclark
# Makefile
# Uses macros to create ChessMoves.jar or to clean ChessMoves.class files

JAVASRC    = ChessMoves.java Bishop.java ChessPiece.java King.java Knight.java LinkedList.java Node.java Queen.java Rook.java Pawn.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = ChessMoves
CLASSES    = ChessMoves.class Bishop.class ChessPiece.class King.class Knight.class LinkedList.class Node.class Queen.class Rook.class Pawn.class
JARFILE    = ChessMoves.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest *.class $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)

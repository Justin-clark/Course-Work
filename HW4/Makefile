# Justin Clark
# judclark
# Makefile
# Uses macros to create NQueens.jar or to clean NQueens.class files

JAVASRC    = NQueens.java Queens.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = NQueens
CLASSES    = NQueens.class Queens.class
JARFILE    = NQueens.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest *.class $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)

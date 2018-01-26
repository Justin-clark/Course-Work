# Makefile for charType.c with macros

FLAGS   = -std=c99 -Wall
SOURCES = charType.c
OBJECTS = charType.o
EXEBIN  = charType

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

check:
	valgrind --leak-check=full $(EXEBIN) $(SOURCES) outfile

clean :
	rm -f $(EXEBIN) $(OBJECTS)

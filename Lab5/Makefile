# Makefile for queueClient.c with macros

FLAGS   = -std=c99 -Wall
SOURCES = queue.c queueClient.c
OBJECTS = queue.o queueClient.o
EXEBIN  = queueClient

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

check:
	valgrind --leak-check=full $(EXEBIN) $(SOURCES) outfile

clean :
	rm -f $(EXEBIN) $(OBJECTS)

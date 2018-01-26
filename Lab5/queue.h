//-----------------------------------------------------------------------------
// queue.h
// Header file for the queue ADT
//-----------------------------------------------------------------------------

#ifndef _NODE_LINKEDLIST_
#define _NODE_LINKEDLIST_

#include<stdio.h>

// LinkedList
// Exported reference type
typedef struct LinkedListObj* LinkedList;

// Node
// Exported reference type
typedef struct NodeObj* Node;

//make a new node
Node newNode(int x);

//free up allocated space in node
void freeNode(Node* number);

//construct a new linked list
LinkedList newLinkedList();

//free up allocated space in linked list
void freeLinkedList(LinkedList* list);

// print linked list
// prints a text representation of list to the file pointed to by out
void printLinkedList(FILE* out, LinkedList list);

// insert()
// insert number into linked list
void insert(FILE* out, int number, LinkedList list);

// delete()
// delete number from linked list
void delete(FILE* out, LinkedList list);

#endif

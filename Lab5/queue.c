//queue.c

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include <assert.h>
#include "queue.h"

//initialize node object and variables
typedef struct NodeObj {
  struct NodeObj* next;
  int val;
} NodeObj;

//constructor for node
Node newNode(int x){
  Node number = malloc(sizeof(NodeObj));
  assert(number != NULL);
  number->next = NULL;
  number->val = x;
  return number;
}

//free node
void freeNode(Node* number) {
  if (number != NULL && *number != NULL) {
    // free all heap memory associated with *number
      free(*number);
      *number = NULL;
  }
}

//initialize linked list object and variables
typedef struct LinkedListObj {
  Node head;
  Node tail;
} LinkedListObj;

//constructor for linked list
LinkedList newLinkedList() {
  LinkedList list = malloc(sizeof(LinkedListObj));
  assert(list != NULL);
  list -> head = NULL;
  list -> tail = NULL;
  return list;
}

// freeLinkedList()
// destructor for the LinkedList type
void freeLinkedList(LinkedList* list) {
  if (list != NULL && *list != NULL) {
      free(*list);
      *list = NULL;
  }
}

// printLinkedList()
// prints a text representation of list to the file pointed to by out
void printLinkedList(FILE* out, LinkedList list) {
  Node curr = list->head;
  while (curr != NULL) {
    fprintf(out,"%d ", curr->val);
    curr = curr->next;
  }
  fprintf(out, "\n");
  if (list->head == NULL) {
    fprintf(out, "");
  }
}

// insert()
// insert number into linked list
void insert(FILE* out, int number, LinkedList list) {
  Node latest = newNode(number);
  if (list->tail == NULL || list->head == NULL) {
    list->head = latest;
    list->tail = latest;
  } else {
    list->tail->next = latest;
    list->tail = latest;
  }
  fprintf(out, "enqueued %d \n", number);
}

// delete()
// delete number from linked list
void delete(FILE* out,LinkedList list) {
  Node temp = list->head;
  if (list->head == NULL) {
    fprintf(out, "empty\n");
  } else {
    list->head = list->head->next;
    fprintf(out, "%d\n", temp->val);
    freeNode(&temp);
  }
}

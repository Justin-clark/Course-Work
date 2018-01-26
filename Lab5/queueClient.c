//queueClient.c
//judclark
//Justin Clark
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
#include "queue.h"

int main(int argc, char* argv[]){

   /* check number of arguments on the command line */
   if( argc<3 ){
      printf("Usage: %s More Arguments\n", argv[0]);
      exit(EXIT_FAILURE);
   }
    //define the files
   FILE *in;
   FILE *out;

   //open the second command line and read it
   in = fopen(argv[1], "r");
   //open the third command line and write into it
   out = fopen(argv[2], "w");

   //create the linkedlist
   LinkedList list = newLinkedList();
   //variable that holds which method to run
   char c;
   //if enqueue, varaible holds the integer
   int x;
   //take in the file until the end
   while(feof(in)==0) {
     //read the first char and store in c, read the first digit and store in x
     fscanf(in,"%c %d",&c,&x);
       if(c == 'e') {
         //enqueue if e
         insert(out,x,list);
       } else if (c == 'd') {
         //dequeue if d
         delete(out,list);
       } else if (c == 'p') {
         //print if p
         printLinkedList(out,list);
       }
   }

   //free space
   freeLinkedList(&list);
   //close files
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
 }

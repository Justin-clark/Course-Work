//charType.c
//judclark
//Justin Clark
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//sort the line into seperate arrays
void extract_chars(char* s, char* a, char* d, char* p, char* w) {
  int counter = 0;
  while (s[counter]!='\0'){
    if(isalpha((int)s[counter])) {
      *a = s[counter];
      a++;
    }
    if(isdigit((int)s[counter])) {
      *d = s[counter];
      d++;
    }
    if(ispunct((int)s[counter])) {
      *p = s[counter];
      p++;
    }
    if(isspace((int)s[counter])) {
      *w = s[counter];
      w++;
    }
    counter++;
  }
}

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

   int line_number = 1;

   //allocate memory for each line
   char* line = calloc(256,sizeof(char));
   //open each newline until you reach the end of the file
   while(fgets(line,256,in)!=NULL){
     //allocate memory for each individual array
     char* letters = calloc(256,sizeof(char));
     char* numbers = calloc(256,sizeof(char));
     char* punctuation  = calloc(256,sizeof(char));
     char* whitespace = calloc(256,sizeof(char));

     extract_chars(line,letters,numbers,punctuation,whitespace);
     //print line and line number
     fprintf(out,"line %d contains: \n",line_number);
     //print alphabet output
     if(strlen(letters) == 1) {
       fprintf(out,"%d alphabetic character: ", strlen(letters));
     } else {
       fprintf(out,"%d alphabetic characters: ", strlen(letters));
     }
     for(int i=0;i < strlen(letters);i++) {
       fprintf(out,"%c",letters[i]);
     }
     fprintf(out,"\n");
     //print number output
     if(strlen(numbers) == 1) {
       fprintf(out,"%d numeric character: ", strlen(numbers));
     } else {
       fprintf(out,"%d numeric characters: ", strlen(numbers));
     }
     for(int i=0;i < strlen(numbers);i++) {
       fprintf(out,"%c",numbers[i]);
     }
     fprintf(out,"\n");
     //print punctuation output
     if(strlen(punctuation) == 1) {
       fprintf(out,"%d punctuation character: ", strlen(punctuation));
     } else {
       fprintf(out,"%d punctuation characters: ", strlen(punctuation));
     }
     for(int i=0;i < strlen(punctuation);i++) {
       fprintf(out,"%c",punctuation[i]);
     }
     fprintf(out,"\n");
     //print whitespace output
     if(strlen(whitespace) == 1) {
       fprintf(out,"%d whitespace character: ", strlen(whitespace));
     } else {
       fprintf(out,"%d whitespace characters: ", strlen(whitespace));
     }
     for(int i=0;i < strlen(whitespace);i++) {
       fprintf(out,"%c",whitespace[i]);
     }
     fprintf(out,"\n");
     //free up allocated space so the information in the arrays are emptied
     free(letters);
     letters = NULL;
     free(numbers);
     numbers = NULL;
     free(punctuation);
     punctuation = NULL;
     free(whitespace);
     whitespace = NULL;

     line_number++;
   }

   free(line);
   line = NULL;
   //close the files
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

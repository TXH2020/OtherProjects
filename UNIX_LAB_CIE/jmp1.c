#include <stdio.h>
#include <setjmp.h>
#include <stdlib.h>
jmp_buf jumpbuff;
void f2(int i,int j,int c){
printf("Before longjump register value=%d volatile value=%d\n %d",i,j,c);
longjmp(jumpbuff,1);
}
void f1(int i, int j,int c){
f2(i,j,c);
}

void main(){
int c=3;
register int regval=1;
volatile int volval=1;
if(setjmp(jumpbuff)!=0){
printf("After longjump register value=%d volatile value=%d\n %d",regval,volval,c);
exit(0);}
regval=2;
volval=2;
c=4;
f1(regval,volval,c);
}

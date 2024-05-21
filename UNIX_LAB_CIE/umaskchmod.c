#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>
#include <stdlib.h>
void main(){
umask(0007);
if(creat("bar12697",0777)<0)
printf("error");
system("ls -li bar12697");
if(chmod("bar12697",0774)<0)
printf("error");
printf("\n");
system("ls -li bar12697");
}

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
char buf[] = "a write to stdout\n";
int main(void)
{
pid_t pid;
int fd=open("temp.foo",O_RDONLY);
if ((pid = fork()) < 0) 
  {
        printf("fork error");
   } 
   else if (pid == 0) 
   { 
   
   printf("Current file offset child:%d",lseek(fd,0,SEEK_CUR));
   } 
   else 
   {
   if(lseek(fd,2,SEEK_SET)<0)
printf("lseek error");
      printf("Current file offset parent:%d",lseek(fd,0,SEEK_CUR));  
    }
    
    exit(0);
}

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
void main(int argc,char * args[]){
pid_t pid;
int fd=open("testbed.txt",O_RDONLY);
if((pid=fork())<0)
printf("Fork error\n");
else if(pid==0){
printf("hi from child. Process id:%ld\n",getpid());
lseek(fd,5,SEEK_SET);
printf("Current file offset:%d\n",lseek(fd,0,SEEK_END));
}
else{
printf("hi from parent. Process id:%ld\n",getpid());
lseek(fd,5,SEEK_SET);
printf("Current file offset:%d\n",lseek(fd,0,SEEK_END));}
}

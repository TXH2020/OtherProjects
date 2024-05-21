#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>
int main(int argc,char* args[]){
pid_t pid;
printf("Hi\n");
if((pid=fork())<0)
printf("Fork error\n");
else if(pid==0){
printf("hi from child. Process id:%ld\n",getpid());
if(access(args[1],R_OK)<0)
printf("Access error\n");
else
printf("Read OK\n");
}
else{
int status;
printf("hi from parent. Process id:%ld\n",getpid());
wait(&status);
printf("Status of child is %d",status);}
return 0;
}

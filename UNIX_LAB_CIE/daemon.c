#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/stat.h>
void main(){
umask(0);
pid_t pid;
if((pid=fork())==-1)
printf("Fork error");
else if(pid>0)
exit(0);
else{
setsid();
chdir("/");
system("ps -axj");}
}

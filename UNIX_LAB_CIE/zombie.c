#include<stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include<stdlib.h>
#include <sys/wait.h>
int main(void) {
pid_t pid;
if ((pid == fork())< 0)
printf("forkerror");
else if (pid == 0){ 
if((pid == fork())< 0)
printf("forkerror");
else if(pid>0){
exit(0);}
sleep(2);
system("ps");
printf("\nsecond child, parent pid = %ld\n", (long)getppid());
exit(0);}
printf("%ld\n",pid);
if (waitpid(pid, NULL, 0) != pid)
printf("wait error");
system("ps");
return 0;
}

#include <unistd.h>
#include <sys/wait.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
int system(const char *cmd)
{
    int stat;
    pid_t pid;
    char * par[]={"sh", "-c", cmd,NULL};
    if ((pid = fork()) == 0) {
        execv("/bin/sh", par);
        _exit(127);
    }
    if (pid == -1) {
        stat = -1; /* errno comes from fork() */
    } else {
        while (waitpid(pid, &stat, 0) == -1) {
            if (errno != EINTR){
                stat = -1;
                break;
            }
        }
    }
    return(stat);
}
void main(){
char command[50];
printf("Enter command");
gets(command);
system(command);
}

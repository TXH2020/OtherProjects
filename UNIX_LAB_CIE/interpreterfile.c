#include<unistd.h>
#include<stdio.h>
#include <stdlib.h>
int main()
{
pid_t pid;
if((pid=fork())<0)
printf("error");
else if(pid==0){
setenv("childenv","I am child",1);
if(execl("textinterpreter","test","myarg1","myarg2", "myarg4", (char *)0)<0)
	printf("error1");}	
else{
setenv("parentenv","I am parent",1);
if(execl("textinterpreter","test3","myarg11","myarg22", "myarg44", (char *)0)<0)
	printf("error2");
	}
}


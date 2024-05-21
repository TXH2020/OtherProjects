#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>

static int pfd1[2],pfd2[2];
static void charatatime(char *);
void WAIT_PARENT();
void TELL_CHILD(pid_t);
void TELL_WAIT();
int main(void)
{
pid_t pid;
TELL_WAIT();
if ((pid = fork()) < 0) {
printf("fork error");
exit(1);
} else if (pid == 0) {
WAIT_PARENT();
charatatime("output from child\n");
} else {
charatatime("output from parent\n");
TELL_CHILD(pid);
}
exit(0);
}
static void charatatime(char *str)
{
char *ptr;
int c;
setbuf(stdout, NULL);
/* set unbuffered */
for (ptr = str; (c = *ptr++) != 0; )
putc(c, stdout);
}
void WAIT_PARENT()
{
char c;
if (read(pfd1[0], &c, 1) != 1)
{
 printf("read error");
 exit(1);
}
if (c != 'p')
{
 printf("WAIT_PARENT: incorrect data");
 exit(1);
}
}
void TELL_CHILD(pid_t pid)
{
if (write(pfd1[1], "p", 1) != 1)
{
 printf("write error");
 exit(1);
}
}
void TELL_WAIT(void)
{
if (pipe(pfd1) < 0 || pipe(pfd2) < 0)
{printf("pipe error");
exit(1);}
}

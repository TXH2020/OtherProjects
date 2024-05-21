#include <stdio.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h> 
#include<utime.h>
int main(int argc, char *argv[])
{
int i, fd; 
struct stat statbuf; struct utimbuf timebuf; 
for (i = 1; i <argc-1; i++) { 
if (stat(argv[i], &statbuf) < 0) { /* fetch currenttimes */ printf("%s: stat error", argv[i]);
continue;
}
timebuf.actime = statbuf.st_atime;
timebuf.modtime = statbuf.st_mtime;
if (utime(argv[i+1], &timebuf) < 0)
{ /* reset times */ printf("%s: utimeerror", argv[i]); continue;
} 
}
system("ls -li");
exit(0);
}

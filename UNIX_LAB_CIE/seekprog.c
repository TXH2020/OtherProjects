#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
void main(){
int n;
int fd1=open("unixprogramming.c",O_RDONLY);
char buff[4096];
if(read(fd1,buff,20)<0)
	printf("read error");
printf("Output1:%s\n",buff);
if(lseek(fd1,10,SEEK_SET)<0)
	printf("lseek error");
if(read(fd1,buff,20)<0)
	printf("read error");
printf("Output2:%s\n",buff);
if(lseek(fd1,10,SEEK_CUR)<0)
	printf("lseek error");
if(read(fd1,buff,20)<0)
	printf("read error");
printf("Output3:%s\n",buff);
printf("File Size:%d",lseek(fd1,0,SEEK_END));
}

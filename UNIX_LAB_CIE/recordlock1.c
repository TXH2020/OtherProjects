#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
void main(int argc,char* argv[]){
int fd;
if((fd=open(argv[1],O_RDWR))<0)
printf("open error\n");
struct flock fvar;
fvar.l_type=F_WRLCK;
        fvar.l_whence=SEEK_END;
        fvar.l_start=SEEK_END-100;
        fvar.l_len=100;
if(fcntl(fd,F_SETLKW,&fvar)<0){
printf("lock set error\n");
printf("write lock held by %ld\n",fvar.l_pid);}
else
printf("write lock held by %ld\n",fvar.l_pid);
if(lseek(fd,-50,SEEK_END)<0)
printf("lseek error\n");
char buf[200];
if(read(fd,buf,50)<0){
printf("read error\n");
if(fcntl(fd,F_GETLK,&fvar)<0)
printf("lock get error\n");}
else
printf("1%s",buf);
fvar.l_type = F_UNLCK;
 fvar.l_whence = SEEK_SET;
 fvar.l_start = 0;
 fvar.l_len = 0;
if(fcntl(fd,F_SETLK,&fvar)<0)
printf("lock set(unlock) error\n");
else{
printf("write lock held by %ld\n",fvar.l_pid);}}


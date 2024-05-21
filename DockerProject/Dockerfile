FROM ubuntu:bionic
WORKDIR /opt
RUN apt-get update
RUN apt-get install net-tools 
RUN apt-get install -y wget
RUN wget https://sourceforge.net/projects/xampp/files/XAMPP%20Linux/7.1.32/xampp-linux-x64-7.1.32-0-installer.run/download
RUN ls
RUN chmod +x download
RUN ./download
RUN rm download
WORKDIR lampp/htdocs
RUN mkdir FarmEasy
COPY FarmEasy /opt/lampp/htdocs/FarmEasy
WORKDIR /opt
RUN rm lampp/etc/extra/httpd-xampp.conf
COPY httpd-xampp.conf /opt/lampp/etc/extra
EXPOSE 80
COPY test.sh /usr/local/bin/
RUN chmod u+x /usr/local/bin/test.sh
ENTRYPOINT ["test.sh"]


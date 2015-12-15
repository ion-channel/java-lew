FROM jetty:8.1-jre8
MAINTAINER Kelly Plummer <kellyplummer@mac.com>


RUN apt-get -y install unzip

# Install lew
ADD https://github.com/ion-channel/lew/releases/download/lew-0.3/data-0.3.zip /data.zip
RUN unzip /data.zip -d /
RUN chown -R 1000:1000 /data

ADD https://github.com/ion-channel/lew/releases/download/lew-0.4/lew-0.4.war /usr/local/jetty/webapps/root.war
RUN chown 1000:1000 /usr/local/jetty/webapps/root.war

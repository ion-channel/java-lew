FROM jetty:8.1-jre8
MAINTAINER Kelly Plummer <kellyplummer@mac.com>


RUN apt-get -y install unzip

# Install lew
ADD https://s3.amazonaws.com/s3-ion-test/files/java-lew/data-0.3.zip /data.zip
RUN unzip /data.zip -d /
RUN chown -R 1000:1000 /data

ADD https://s3.amazonaws.com/s3-ion-test/files/java-lew/lew-0.5-SNAPSHOT.war /usr/local/jetty/webapps/root.war
RUN chown 1000:1000 /usr/local/jetty/webapps/root.war

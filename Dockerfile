FROM jetty:8.1-jre8
MAINTAINER Kelly Plummer <kellyplummer@mac.com>


RUN apt-get -y install unzip

# Install lew data
ADD https://s3.amazonaws.com/s3-ion-test/files/java-lew/data-0.3.zip /data.zip
RUN unzip /data.zip -d /
RUN chown -R 1000:1000 /data

# remove old stuff
RUN rm -rf /usr/local/jetty/webapps/test.war
RUN rm -rf /usr/local/jetty/webapps/spdy.war
RUN rm -rf /usr/local/jetty/contexts/test.xml /usr/local/jetty/contexts/javadoc.xml

RUN mkdir -p app/tmp
# Install lew
ADD https://s3.amazonaws.com/s3-ion-test/files/java-lew/lew-0.5-SNAPSHOT.war /usr/local/jetty/webapps/root.war

RUN unzip /usr/local/jetty/webapps/root.war -d /usr/local/jetty/webapps/root
RUN rm /usr/local/jetty/webapps/root.war
RUN chown 1000:1000 -R /usr/local/jetty/webapps/root

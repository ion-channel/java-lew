Lew
=========

Simple JSON Service for resolving GeoNames from unstructured input text using the CLAVIN project.

![Compliance Status](https://api.ionchannel.io/v1/analysis/getProject?account_id=cf47e4d1-1926-4990-8ef8-f326be59d6fc&apikey=9a684743a58b4110c14d5279d3f868ba&project_id=9dd5f8fe-4a08-4799-8cfe-4e5813fd845e&format=badge) [![Build Status](https://travis-ci.org/ion-channel/java-lew.svg?branch=master)](https://travis-ci.org/ion-channel/java-lew)


Version
-

0.1

Usage
-

with GET

```sh
curl http://localhost:8080/v1/geo\?query\=New%20York
```

with POST

```sh
curl -X POST -d "New York" http://localhost:8080/v1/geo --header "Content-Type:text/plain"
```

Setup
-
You will need to follow the instructions provided by the CLAVIN project to create the index data.

* https://github.com/Berico-Technologies/CLAVIN
* https://github.com/Berico-Technologies/CLAVIN-NERD

Lew will look for the IndexDirectory and all.3class.distsim.crf.ser.gz in /data by default. After that
you can start the service with

```sh
mvn jetty:run
```


Docker
-

Lew is now built as a docker image, which can be run easily with the following
command

```sh
sudo docker run -d -p 80:8080 ionchannel/lew
```
after it starts you can test with curl

```sh
curl http://localhost/v1/geo?query=New+York
```

License
-
(c) Copyright Selection Pressure LLC - 2015

GPLv2

Lew
=========

Simple JSON Service for resolving GeoNames from unstructured input text.


Version
-

0.1

Usage
-

with GET

```sh
curl http://localhost:8080/geonames\?query\=New%20York
```

with POST

```sh
curl -X POST -d "New York" http://localhost:8080/geonames --header "Content-Type:text/plain"
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


License
-
(c) Copyright AirGap LLC - 2014
GPLv2

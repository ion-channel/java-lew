GeoName Service
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

License
-

GPLv2
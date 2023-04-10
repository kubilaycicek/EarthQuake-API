# EarthQuake-API

This is a earthquake api. I used AFAD's official web site for real data. AFAD's Web Site is https://deprem.afad.gov.tr/last-earthquakes.html

You can use the API and get live earthquake's data in Turkey. The list get data of 100 record. And I added Postman Collection for you. 

### Used Technologies

* Spring Framework 2.7.9
* Spring Cache 2.4.0
* Java 11
* Jsoup 1.15.4
* Lombok
* Docker

### How to run ?

```console
docker build -t afad-service . 
```

```console
 docker run -it --rm -p 8080:8080 afad-service
```
 

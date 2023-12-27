# Projekat: Aplikacija za upravljanje inventarom  

Ovaj projekat je full-stack CRUD (Create, Read, Update, Delete) aplikacija za upravljanje stavkama. Projekat se sastoji od Spring Boot backend-a i React frontend-a.

![Screenshot aplikacije](https://github.com/zivojinl5/aplikacija-upravljanje-inventarom/raw/89bab1493c53a23e3036b5cdd85983b323eccc85/slika.png)  


## Podešavanje baze podataka  

U fajlu backend/src/main/resources/application.properties, unesite vaše podatke na odgovarajuća mesta.

```
spring.datasource.url=jdbc:mysql://localhost:3306/${db.database}?useSSL=false
spring.datasource.username=${db.username}
spring.datasource.password=${db.password}
```

# Pokretanje Aplikacije

## Pokretanje i podesavanje Backend-a:  
Otvorite terminal iz foldera backend i unesite sledeću komandu:    
```
mvn clean install
```

zatim   

```
mvn spring-boot:run
```
da bi pokrenuli Spring Boot server.   

## Pokretanje Frontend-a:    
Zatim otvorite drugi terminal iz foldera frontend i unesite sledeću komandu:        

```
npm start
```
  
Otvorite vaš pretraživač i idite na http://localhost:3000 da biste pristupili aplikaciji.






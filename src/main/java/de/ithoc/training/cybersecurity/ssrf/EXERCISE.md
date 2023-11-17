# Exercise: Server-side Request Forgery (SSRF)

## Ziel
Schreibe eine kleine Beispielanwendung, in der die **SSRF**-Schwachstelle „versehentlich“ implementiert ist.  

## Aufgaben
1. Lege dir ein Spring MVC (mit Spring Boot und Thymeleaf) an.
2. Implementiere einen internen Service, der eine URL entgegennimmt und Kundendaten zurückgibt. 
Alternativ verwende das bereitgestellte Beispielprojekt 
```cyber-security-java /src/main/java/**/cybersecurity/ssrf/*```.
3. Schreibe eine Spring MVC die aus einem Template eine URL entgegennimmt und diese an den internen 
Service weiterleitet.

## Hinweis
Du kennst die interne URL auf die Customer-API. Gib diese nun in das Eingabefeld ein und führe den 
URL-Check durch. Du hast so Einsicht auf geschützte Daten. 

# Exercise: Server-side Request Forgery (SSRF)

## Ziel
Schreibe eine kleine Beispielanwendung, in der die **SSRF**-Schwachstelle „versehentlich“ implementiert ist.  

## Aufgaben
1. Lege dir ein Spring MVC (mit Spring Boot und Thymeleaf) an.
2. Analysiere den internen Service ```InternalServer```, der eine URL entgegennimmt und Kundendaten zurückgibt. 
3. Behebe die Schwachstelle mithilfe von ```URLValidator``` aus der Apache Commons Validator-Bibliothek oder einem 
anderen Verfahren deiner Wahl.

## Hinweis
Du kennst die interne URL auf die Customer-API. Gib diese nun in das Eingabefeld ein und führe den 
URL-Check durch. Du hast so Einsicht auf geschützte Daten. 

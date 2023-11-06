# Exercise: Reflected Cross-Site Scripting (RXSS)

## Ziel
Schreibe eine kleine Beispielanwendung, in der die RXSS-Schwachstelle “versehentlich” Implementiert ist.  

## Aufgaben
Lege dir ein Spring MVC (mit Spring Boot und Thymeleaf) an.
Schreibe einen Controller mit einem Home-Template (Mapping: “/”) und einem Search-Template (“/search).
Die Home-Seite enthält ein Formular mit einem Eingabefeld und einem Button. Die Aktion verweist auf die 
Search-Ressource als POST-Methode.
Die Search-Methode reicht die Eingabe direkt weiter ans Search-Template. Dort wird sie mittels ```th:utext``` 
(unaufgelöst) ausgegeben wird.  

## Hinweis
Gibst du nun schädlichen JavaScript-Code in das Eingabefeld ein, wird dieser Code auf der Search-Seite 
im Browser ausgeführt.

Beispiel: ```<script>alert('Buh!')</script>```

Teste weitere Scripte, wie z.B.:
- ```console.log('Buh!')``` (Leute erschrecken)
- ```window.location.href = 'https://api.example.com/my-service``` (externe API oder Webseite aufrufen)
- ```document.cookie``` (Cookie auslesen)
- ...
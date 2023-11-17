# Exercise: Cross-site Forgery (CSRF)

## Ziel
Ergänze die Beispielanwendung so, dass die **CSRF**-Schwachstelle vermieden wird. Verwende dazu ein Token,
das vom Server ausgestellt wird und der Client bei Anfragen mitgibt.

## Aufgaben
1. Analysiere die Anwendung und verstehe den Code.
2. Füge dem Server eine Methode hinzu, die ein CSRF-Token ausstellt.
3. Speichere jedes ausgelieferte Token mit Bezug zur UserId z.B. in einer Map.
4. Frage die Methode vom Client aus an und speichere das Token in deiner Client-Session.
5. Übergib das Token bei der Änderung der E-Mailadresse an den Server. Dazu passe die Server-Methode an.
6. Prüfe, ob das Token bei der Änderung der E-Mailadresse mit dem Token in der Session übereinstimmt.
7. Falls ja, ändere die E-Mailadresse. Falls nein, gib eine Fehlermeldung aus.

## Bonus
1. Implementiere eine Logout-Funktion und lösche das Token aus der Session, wenn sich Nutzer abmelden.
2. Invalidiere das Token nach einer bestimmten Zeit. Konfiguriere die Dauer in der ```application.properties```.

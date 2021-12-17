# Alpha-Solution
Forudsætninger

For at dette program kan gøre hod dig skal du have dette

Adgang til en webbrowser
Adgang til et udviklingsværktøj som er i stand til at køre java, html og css kode. Vi har selv brug IntelliJ IDEA fra JetBrains
Mulighed for at lave en database som du kan hoste på localhost og som kan bruge MYSQL funktioner
Ændre application.properties filen så den matcher dit brugernavn, pass og url til den database du gerne vil køre.


Kørselsvejledning

1. fork vores projekt fra github
2. Opret din egen database med Projekt, Assignment og Employee. Du vil kunne finde tabel værdierne i Model
  i. åben din MYSQL Applikation
 ii. Opret en ny connaction og opret et ny schema eller brug en ældre en uden en schema
iii. indsæt attributerne fra de 3 model i dine tabels og du er good to gå
3. Ændre application.properties til det brugernavn og password du valgte da du lavet din database. Ændre url til @localHost3306
4. Deploy det til Heroku via din konto - se guide her https://devcenter.heroku.com/articles/github-integration
5. Det er en god ide at bruge manual deployment så du arbejder med databasen


# GachaAPI

### INSTRUKCJA POSTAWIENIA TEGO LOKALNIE:

1. zainstaluj [xampp](https://www.apachefriends.org/) (Rozwiązanie tymczasowe dopóki są problemy z mssql)
2. w panelu kontrolnym xampp wystartuj Apache i MySQL 
3. Wejdź na http://localhost/phpmyadmin/
4. Stwórz nową bazę: Po lewej stronie na szczycie listy klikniej "Nowa" i nazwij ją "gacha"
5. Wystartuj Api z IntelliJ 
6. Gotowe :)

### WAŻNE KOŃCÓWKI:

##### POST /signup

przymuje jsona w formacie:  
{  
  "nick":"SuperKozackiNick",  
  "password":"GigaTajneHasło",  
  "birthDate":"1984-01-01"  
}  
  
##### POST /token

Przyjmuje puste Body i autoryzacje typu Basic (Sposób działania opisany na dole)  
Zwraca Token JWT potrzebny do KAŻDEGO z poniższych zapytań.  
Token jest ważny przez 15 minut, potem trzeba uderzyć tu ponownie po nowy.

##### GET /players

- Wyświetla wszystkich użytkowników
- Wymaga uprawnień administratora

##### GET /playerInfo

- Wyświetla informacje o zalogowanym użytkowniku  
- Wymaga tokenu (instrukcja znajduje się na końcu readme)
- Wielkie litery mają znaczenie

##### GET /chests, /chests/all, /chests/open/{id}

- Pozwala wyświetlać i otwierać skrzynki
- Zaleca się lokalne dodanie skrzynki z price = 0 bo gracze nie mogą jeszcze zarabiać :)
- /chests wyświetla tylko aktualnie dostępne skrzynki

###### Inne końcówki można znależć w plikach znajdujących się w folderze /Controller/api/   
### DOMYŚLNE KONTA:

- login: user hasło: user  
- login: admin hasło: admin  
  
aktualnie nie da się tworzyć adminów bez ręcznego wchodzenia w bazę (i raczej tak zostanie)

### MENU DO DODAWANIA DO BAZY

- ZNAJUDUJE SIĘ POD localhost:8080/dev/menu  
- Wymaga zalogowania się na konto admina (login: admin, hasło: admin)  
- Wszystkie niezbędne strony są już dodane, błędy zgłaszać do Huberta.  

### INSTRUKCJA AUTORYZACJI ZAPYTAŃ TYPU BASIC AUTH:

1. łączysz user i password w formacie "user:password"  
2. hashujesz to za pomocą Base64 (powinno być wbudowane we wszystko co może się łączyć z internetem)  
3. Do wysyłanego pakietu dodajesz nagłówek Authorization z wartością "Basic hash"    
PRZYKŁAD  
Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==

### INSTRUKCJA AUTORYZACJI ZAPYTAŃ TYPU BEARER TOKEN (JWT):

1. za pomocą basic auth uderzasz w końcówkę /token, która zwróci Ci token  
2. Przy każdym następnym zapytaniu dodajesz nagłówek Authorization z wartością "Bearer Token"  
PRZYKŁAD  
Authorization : Bearer cn389ncoiwuencr


# GachaAPI

Siema  
Działa na porcie 8080

###### DOSTĘPNE KOŃCÓWKI:

1. POST /signup  
przymuje jsona w formacie:  
{  
  "nick":"SuperKozackiNick",  
  "password":"GigaTajneHasło"  
}  
W przyszłości będzie jeszcze przyjmować datę urodzenia.  
  
2. POST /login
Przyjmuje puste Body i autoryzacje typu Basic (Sposób działania opisany na dole)  
Zwraca Token JWT potrzebny do KAŻDEGO z poniższych zapytań.  
Token jest ważny przez 15 minut, potem trzeba uderzyć tu ponownie po nowy.  
  
2. GET /players  
wyświetla wszystkich użytkowników, TYLKO Z ROLĄ ADMIN  
  
3. GET /roles  
wyświetla dostępne role użytkowników, TYLKO ZALOGOWANI UŻYTKOWNICY

###### DOMYŚLNE KONTA:

- login: user hasło: user  
- login: admin hasło: admin  
  
aktualnie nie da się tworzyć adminów bez ręcznego wchodzenia w bazę

###### MENU DO DODAWANIA DO BAZY

- ZNAJUDUJE SIĘ POD localhost:8080/dev/menu  
- Z czasem będą pojawiać się tu odnośniki do formularzy pozwalających wypełniać bazę  
- Dostępne tylko dla localhosta (teoretycznie każdy admin może wejść ale wymaga to ręcznego przesyłania autoryzacji w przeglądarce)

###### INSTRUKCJA AUTORYZACJI ZAPYTAŃ TYPU BASIC AUTH:

1. łączysz user i password w formacie "user:password"  
2. hashujesz to za pomocą Base64 (powinno być wbudowane we wszystko co może się łączyć z internetem)  
3. Do wysyłanego pakietu dodajesz nagłówek Authorization z wartością "Basic hash"    
PRZYKŁAD  
Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==

###### INSTRUKCJA AUTORYZACJI ZAPYTAŃ TYPU BEARER TOKEN (JWT):

1. za pomocą basic auth uderzasz w końcówkę /login, która zwróci Ci token  
2. Przy każdym następnym zapytaniu dodajesz nagłówek Authorization z wartością "Bearer Token"  
PRZYKŁAD  
Authorization : Bearer cn389ncoiwuencr


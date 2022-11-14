# GachaAPI

Siema  
Działa na porcie 8080  
  
DOSTĘPNE KOŃCÓWKI:  
1. POST /signup  
przymuje jsona w formacie:  
{  
  "nick":"SuperKozackiNick",  
  "hashedPassword":"GigaTajneHasło"  
}  
Nie przejmujcie się nazwą pola "hashedPassword" należy dać zwykłe, poprawię nazwę w najbliższym czasie :).  
W przyszłości będzie jeszcze przyjmować datę urodzenia.  
  
2. GET /players  
wyświetla wszystkich użytkowników, dostępne tylko dla adminów  
  
3. GET /roles  
wyświetla dostępne role użytkowników, dostępne dla zalogowanych.  
  
DOMYŚLNE KONTA:   
login: user hasło: user  
login: admin hasło: admin  
  
aktualnie nie da się tworzyć adminów bez ręcznego wchodzenia w bazę
  

INSTRUKCJA AUTORYZACJI ZAPYTAŃ:  
1. łączysz user i password w formacie "user:password"  
2. hashujesz to za pomocą Base64 (powinno być wbudowane we wszystko co może się łączyć z internetem)  
3. Do wysyłanego pakietu dodajesz nagłówek Authorization z wartością "Basic <hash>"  
PRZYKŁAD  
Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==

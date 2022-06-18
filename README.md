# IsolaEvent 👨‍💻👩‍💻
BREVE DESCRIZIONE DEL PROGETTO 

L'applicazione e' un progetto spring realizzato durante il corso "JAVA Masterclass" di treedom.
L'app simula un sistema di prenotazioni eventi nello specifico adattato per Isola Catania. 
Il team si e' occupato dello sviluppo della parte backend dell'applicazione, progettando prima lo schema entita' - relazione, per poi sviluppare i metodi con annessi endpoint per l'inserimento dei dati all'interno del database.


![IsolaEvent](https://user-images.githubusercontent.com/83754920/173840589-796795c7-a4cf-48c7-943b-e19f4db8bdf7.jpg)


LE ENTITA': campi

Utente: id, nome, cognome, e-mail, data di nascita, portafoglio(saldo)
Evento: id, titolo, descrizione, data, orario, organizzatore, lista di partecipanti, prezzo, stanza
Stanza: id, nome, capacità (posti disponibili)
Recensione: id_recensione, titolo, descrizione, intero da 1 a 5 (valutazione)
Prenota: id_prenotazione, id_evento, id_Utente 
Preferito: id_preferito, id_evento, id_utente

*Prenota e Preferito sono derivanti dalla relazione molti a molti.


Le principali funzioni che possono essere svolte sono:

-	Creare Utente
-	Creare un Evento
-	Creare una Stanza
-	Modificare o cancellare una stanza
-	Ottenere tutte le stanze disponibili
-	Creare una prenotazione a un evento
-	Lasciare una recensione per l’organizzatore
-	Creare una lista di eventi preferiti (eventi a cui un utente è interessato)
-	Ottenere la lista degli eventi che un utente ha pubblicato
-	Ottenere la lista degli eventi a cui un utente ha partecipato o le prenotazioni future
-	Ottenere tutte gli eventi disponibili


DETTAGLIO DELLE OPERAZIONI

-	Utente
  o	Creazione
  o	Update (set Utente e get Utente)
  o	Cancellazione
  o	Ottenere tutti gli eventi creati da un utente
  
-	Evento
  o	Creazione
  o	Ottenere un evento con un certo id
  o	Ottenere tutti gli eventi disponibili
  
-	Prenotazione
  o	Crea prenotazione per un evento (passaggio di utente ed evento come parametri)
  o	Ottenere tutte le prenotazioni passate dato un utente
  o	Ottenere tutte le prenotazioni future dato un utente

-	Stanza
  o	Creare una stanza
  o	Update di una stanza (posti disponibili o nome)
  o	Cancellare una stanza (se cancellata una stanza, gli eventi associati si cancellano allo stesso modo, cascade)

-	Recensione
  o	Creazione di una recensione a partire da una prenotazione (controllare se l’evento sia già finito)
  
  
  Le seguenti operazioni sono state "testate" attraverso l'utilizzo di POSTMAN.





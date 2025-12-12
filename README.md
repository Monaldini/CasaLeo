# CasaLeo
è un progetto basato su architettura a microservizi, progettato per supportare la gestione completa di un’attività di ristorazione, sia dal punto di vista manageriale che dal punto di vista del cliente finale.

L’architettura è suddivisa in più microservizi indipendenti, organizzati all’interno di un monorepo, ciascuno con responsabilità ben definite.

Microservizi di infrastruttura

Auth Service
Gestisce l’autenticazione e la sicurezza dell’applicazione:

login e registrazione utenti

refresh token

gestione dei ruoli (MANAGER, CLIENT, STAFF)

emissione e gestione dei JWT

API Gateway
Rappresenta l’unico punto di accesso ai servizi backend:

routing verso i microservizi di dominio

validazione dei token JWT

gestione CORS

controllo degli accessi in base ai ruoli

Eureka Server (Service Discovery)
Gestisce la registrazione e la discovery dei microservizi, permettendo una comunicazione dinamica e scalabile tra i servizi.

Microservizi di dominio

Inventory Service
Gestione dell’inventario e delle scorte.

Menu Service
Gestione dei menu, delle categorie e dei prezzi.

Table Management Service
Gestione dei tavoli, dello stato dei tavoli e del layout del locale.

Booking Service
Gestione delle prenotazioni dei clienti.

Order Service
Gestione degli ordini, dello stato delle comande e del calcolo del totale.

Payment Service
Gestione dei pagamenti e delle transazioni associate agli ordini.

Frontend

Il progetto prevede tre applicazioni frontend separate:

Manager UI
Interfaccia dedicata ai manager per la gestione di inventario, menu, tavoli, ordini e prenotazioni.

Client UI
Interfaccia dedicata ai clienti per la consultazione del menu, l’invio degli ordini e il pagamento.

Public / Advertising UI
Interfaccia pubblicitaria e informativa, pensata per la visualizzazione su browser o display dedicati e per la gestione semplificata delle prenotazioni.

# pet-proposal

PetProposal, projekat iz predmeta Sistemi bazirani na znanju.

Projekat se sastoji od Spring aplikacije na back-endu, koja koristi Drools rule engine, Angular aplikacije na front-endu, 
koja je trenutno u fazi razvoja. I baze podataka, trenutno se koristi H2 baza, u finalnoj verziji ce biti MySql.

Pokretanje projekta: za kontrolnu tacku 1 dovoljno je update-ovati Maven dependencies Spring aplikacije i pokrenuti je.
Aplikacija automatski podize H2 bazu i skriptu koja dodaje admina i nekoliko zivotinja.

Za testiranje dodavanja novih zivotinja i pokretanja pravila koristi se Postman.

POST http://localhost:8080/api/animals sluzi za dodavanje novih zivotinja.

POST http://localhost:8080/api/animals/propose-animal sluzi za pokretanje pravila.

Pri pokretanju pravila neophodno je proslediti AnimalDto objekat (ovo ce biti izmenjeno u buducnosti, da koristi UserInfoDto), 
ona se pokrecu za svaku zivotinju iz baze podataka i uporedjuju osobine te zivotinje sa prosledjenim osobinama koje je korisnik uneo.

Trenutna pravila su: 
1) WHEN animal.spaceNeeded <= userSpace THEN result += 1
2) WHEN animal.timeNeeded <= userTime THEN result += 1
3) WHEN animal.potentialNoise <= bearableNoise THEN result += 1
4) WHEN animal.moneyNeeded <=  moneyForSpendingOnAnimal THEN result += 1
5) WHEN animal.pettable == animalThatLikesPetting THEN result += 1
6) WHEN animal.absenceFromHome.ordinal <= absentFromHome THEN result += 1
7) WHEN animal.activities == outdoorActivities THEN result += 1
8) WHEN animal.learningTricks == teachingTricks THEN result += 1
9) WHEN animal.hairAlergy == true && alergicToHair == true += 1
10) WHEN animal.featherAlergy == true && alergicToFeather == true THEN result += 1

Result svake zivotinje se uporedjuje i sortira.

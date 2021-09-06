INSERT INTO adresa (id, ulica, broj) VALUES (1,'Bulevar Cara Lazara', 5);
INSERT INTO adresa (id, ulica, broj) VALUES (2, 'Dalmatinska', 7);

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN',1);
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK',2);
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK',2);

INSERT INTO tip (id, naziv) VALUES (1, '2D');
INSERT INTO tip (id, naziv) VALUES (2, '3D');

INSERT INTO sala (id, naziv) VALUES (1, 'Sala-1');
INSERT INTO sala (id, naziv) VALUES (2, 'Sala-2');
INSERT INTO sala (id, naziv) VALUES (3, 'Sala-3');
INSERT INTO sala (id, naziv) VALUES (4, 'Sala-4');

INSERT INTO tip_sala (tip_id, sala_id) VALUES (1, 1);
INSERT INTO tip_sala (tip_id, sala_id) VALUES (1, 2);
INSERT INTO tip_sala (tip_id, sala_id) VALUES (2, 3);
INSERT INTO tip_sala (tip_id, sala_id) VALUES (1, 3);
INSERT INTO tip_sala (tip_id, sala_id) VALUES (2, 4);

INSERT INTO sediste (id, redni_broj, sala_id) VALUES (1, 1, 1);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (2, 2, 1);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (3, 3, 1);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (4, 4, 1);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (5, 5, 1);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (6, 1, 2);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (7, 2, 2);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (8, 3, 2);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (9, 4, 2);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (10, 5, 2);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (11, 1, 3);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (12, 2, 3);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (13, 3, 3);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (14, 4, 3);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (15, 5, 3);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (16, 1, 4);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (17, 2, 4);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (18, 3, 4);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (19, 4, 4);
INSERT INTO sediste (id, redni_broj, sala_id) VALUES (20, 5, 4);


              
INSERT INTO film (id, naziv, trajanje, reziser, zemlja_porekla, godina_proizvodnje, opis) VALUES (1, 'Avengers: Endgame', 182, 'Dzo Ruso', 'SAD', 2019, 'Avengers: Endgame je američki film o superherojima iz 2019');
INSERT INTO film (id, naziv, trajanje, reziser, zemlja_porekla, godina_proizvodnje, opis) VALUES (2, 'Life', 110, 'Danijel Espinoza', 'SAD', 2017, 'Life je američki film horora iz naučne fantastike iz 2017. godine');
INSERT INTO film (id, naziv, trajanje, reziser, zemlja_porekla, godina_proizvodnje, opis) VALUES (3, 'It: Chapter 2', 170, 'Andres Muskijeti', 'SAD', 2019, 'Je američki fantastični natprirodni horor iz 2019. godine');
INSERT INTO film (id, naziv, trajanje, reziser, zemlja_porekla, godina_proizvodnje, opis) VALUES (4, 'Pirates of the Caribbean: Dead Men Tell No Tales', 153, 'Espen Sandberg', 'SAD', 2017, 'Pirates of the Caribbean: Dead Men Tell No Tales je američki fantastični film iz 2017. godine');

INSERT INTO projekcija (id, datum_vreme, film_id, sala_id, tip_id, cena_karte, administrator_id) VALUES (1, '2021-06-21 20:00', 1, 1, 1, 380.00, 1);
INSERT INTO projekcija (id, datum_vreme, film_id, sala_id, tip_id, cena_karte, administrator_id) VALUES (2, '2021-07-22 21:00', 2, 2, 1, 580.00, 1);
INSERT INTO projekcija (id, datum_vreme, film_id, sala_id, tip_id, cena_karte, administrator_id) VALUES (3, '2021-06-22 20:00', 1, 3, 2, 780.00, 1);
INSERT INTO projekcija (id, datum_vreme, film_id, sala_id, tip_id, cena_karte, administrator_id) VALUES (4, '2021-08-10 18:00', 3, 4, 2, 350.00, 1);
INSERT INTO projekcija (id, datum_vreme, film_id, sala_id, tip_id, cena_karte, administrator_id) VALUES (5, '2021-08-12 19:00', 4, 3, 1, 680.00, 1);

INSERT INTO karta (id, datum_vreme, projekcija_id, sediste_id, korisnik_id) VALUES (1, '2020-06-21 10:00', 1, 2, 2);
INSERT INTO karta (id, datum_vreme, projekcija_id, sediste_id, korisnik_id) VALUES (2, '2020-06-21 14:00', 2, 8, 2);
INSERT INTO karta (id, datum_vreme, projekcija_id, sediste_id, korisnik_id) VALUES (3, '2020-08-11 10:00', 5, 14, 3);

INSERT INTO zanr (id, naziv) VALUES (1, 'naucna fantastika');
INSERT INTO zanr (id, naziv) VALUES (2, 'akcija');
INSERT INTO zanr (id, naziv) VALUES (3, 'komedija');
INSERT INTO zanr (id, naziv) VALUES (4, 'horor');
INSERT INTO zanr (id, naziv) VALUES (5, 'avantura');

INSERT INTO film_zanr (film_id, zanr_id) VALUES (1, 1);
INSERT INTO film_zanr (film_id, zanr_id) VALUES (1, 2);
INSERT INTO film_zanr (film_id, zanr_id) VALUES (1, 5);

INSERT INTO film_zanr (film_id, zanr_id) VALUES (2, 1);
INSERT INTO film_zanr (film_id, zanr_id) VALUES (2, 4);

INSERT INTO film_zanr (film_id, zanr_id) VALUES (3, 4);

INSERT INTO film_zanr (film_id, zanr_id) VALUES (4, 2);
INSERT INTO film_zanr (film_id, zanr_id) VALUES (4, 3);
INSERT INTO film_zanr (film_id, zanr_id) VALUES (4, 5);
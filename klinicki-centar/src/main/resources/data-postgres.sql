

insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Bate Brkica 5', 1000, 'Srbija', 'Novi Sad', 'KlinikaABC', 7 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Miloša Crnjanskog 2', 1500, 'Srbija', 'Sremska Mitrovica', 'Zdravlje', 8 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Atinska 9', 1300, 'Srbija', 'Kragujevac', 'Klinika Mara', 6 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Atinska 9', 1300, 'Srbija', 'Kragujevac', 'Aria', 6 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Atinska 9', 1300, 'Srbija', 'Kragujevac', 'Zimer', 9 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Atinska 9', 1300, 'Srbija', 'Kragujevac', 'Cestion', 7 );


insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,klinika_id,login ) values ('Branka Radicevica 5', 'Srbija', 'miki@gmail.com',  'Novi Sad', 'Miki', '586623556', 'miki', 'Miki', '067528856', 'miki','TRUE','ADMIN_KLINIKE',1,true);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,klinika_id,login ) values ('Marsala Junaka 10', 'Srbija', 'cobi@gmail.com',  'Novi Sad', 'Cobi', '8898432342', 'cobi', 'Cobi', '064553772', 'cobi','TRUE','ADMIN_KLINIKE',2,true);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,klinika_id,login ) values ('Anica Dobrica 1', 'Srbija', 'anali@gmail.com',  'Novi Sad', 'Anali', '8485608888', 'anali', 'Anali', '064955858', 'anali','TRUE','ADMIN_KLINIKE',3,true);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,klinika_id,login ) values ('Anica Dobra 1', 'Srbija', 'ana@gmail.com',  'Novi Sad', 'Ana', '8585608888', 'ana', 'Ana', '064999858', 'ana','TRUE','ADMIN_KLINIKE',3,true);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Branka Radicevica 55', 'Srbija', 'miki5@gmail.com',  'Novi Sad', 'Mikii', '5662355766', 'mikii', 'Miki', '0675288564', 'mikii',FALSE,'PACIJENT',false);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Marsala Junaka 105', 'Srbija', 'cobi5@gmail.com',  'Novi Sad', 'Cobii', '88843235426', 'cobii', 'Cobi', '0645537724', 'cobii',FALSE,'PACIJENT',false);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Anica Dobra 15', 'Srbija', 'ana5@gmail.com',  'Novi Sad', 'Ananfi', '858568488586', 'anai', 'Ana', '0649998584', 'anai',FALSE,'PACIJENT',false);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Marsala Junaka 1055', 'Srbija', 'cobii5@gmail.com',  'Novi Sad', 'Cobii', '788843235426', 'addmin', 'Cobi', '0645537724', 'addmin',FALSE,'ADMIN',false);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Anica Dobra 155', 'Srbija', 'anai5@gmail.com',  'Novi Sad', 'Ananfi', '8587568488586', 'aadmin', 'Ana', '0649998584', 'aadmin',FALSE,'ADMIN',true);
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Sestra 155', 'Srbija', 'sestra@gmail.com',  'Novi Sad', 'Sestra', '777458488586', 'sestra', 'Sestra', '0649998587', 'sestra',FALSE,'SESTRA',true);


INSERT INTO administratorkc (user_id, first_login, predefinisani) VALUES ('6', true, true);
/*ovo je admin klinike*/
/*insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Anica Dobra 15', 'Srbija', 'andsfa5@gmail.com',  'Novi Sad', 'Ananfi', '8585658488586', 'ak', 'Ana', '0649998584', 'ak',FALSE,'PACIJENT');*/

/*insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Bate Brkic 4','alergije', 'anamneza', 'bolesti', '25.04.1999.', '-1', 'B', 'muski', '70kg', '175cm', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '227885846', 'markomarkovic', 'Markovic', '063528496', 'marko22',TRUE,'PACIJENT');
insert into korisnik3( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Kralja Petra 2','', '', '', '', '', '', '', '', '', 'Srbija','sanja22@gmail.com', 'Novi Sad', 'Sanja', '2525586', 'sanjasanjic', 'Sanjic', '063222496', 'sanja22',TRUE,'PACIJENT');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Todora Jovanovica 5','', '', '', '', '', '', '', '', '', 'Srbija', 'petar22@gmail.com',  'Novi Sad', 'Petar', '1245846', 'petarpetrovic', 'Petrovic', '067528856', 'petar22','TRUE','PACIJENT');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Todora Jovanovica 5','', '', '', '', '', '', '', '', '', 'Srbija', 'adminn22@gmail.com',  'Novi Sad', 'Petar', '1235446', 'adminkc', 'Petrovic', '067528856', 'adminn','TRUE','ADMIN');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Jovana Subotica 10','', '', '', '', '', '', '', '', '', 'Srbija', 'lekar11@gmail.com',  'Novi Sad', 'Jovan', '88826432', 'leka1111', 'Jovic', '064553772', 'jova','TRUE','LEKAR');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Bate Brkic 4','', '', '', '', '', '', '', '', '', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '2158456', 'asdasd', 'Markovic', '063528496', 'test',TRUE,'PACIJENT');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Bate Brkic 4','', '', '', '', '', '', '', '', '', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '21584546', 'ak', 'Markovic', '063528496', 'ak',TRUE,'PACIJENT');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Bulevar Oslobodjenja 3','', '', '', '', '', '', '', '', '', 'Srbija', 'zoran2@gmail.com',  'Novi Sad', 'Zoran', '8232712', 'zoki2', 'Simic', '061662893', 'zoki','TRUE','LEKAR');
*/
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ( 'Bate Brkic 4','alergije', 'anamneza', 'bolesti', '25.04.1999.', '-1', 'B', 'muski', '70kg', '175cm', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '22758546', 'markomarkovic', 'Markovic', '063528496', 'marko22',TRUE,'PACIJENT',true);
insert into korisnik3( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ,login) values ( 'Kralja Petra 2','', '', '', '', '', '', '', '', '', 'Srbija','sanja22@gmail.com', 'Novi Sad', 'Sanja', '25255586', 'sanjasanjic', 'Sanjic', '063222596', 'sanja22',TRUE,'PACIJENT',false);
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Todora Jovanovica 5','', '', '', '', '', '', '', '', '', 'Srbija', 'petar22@gmail.com',  'Novi Sad', 'Petar', '124584758226', 'petarpetrovic', 'Petrovic', '067528856', 'petar22','TRUE','PACIJENT',true);
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Todora Jovanovica 5','', '', '', '', '', '', '', '', '', 'Srbija', 'adminn22@gmail.com',  'Novi Sad', 'Petar', '12354457526', 'adminkc', 'Petrovic', '067528856', 'adminn','TRUE','ADMIN',true);
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ('Jovana Subotica 10','', '', '', '', '', '', '', '', '', 'Srbija', 'lekar11@gmail.com',  'Novi Sad', 'Jovan', '88826455732', 'leka1111', 'Jovic', '064553772', 'jova','TRUE','LEKAR',true);
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role,login ) values ( 'Bate Brkic 4','', '', '', '', '', '', '', '', '', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '21584556', 'asdasd', 'Markovic', '063528496', 'test',TRUE,'PACIJENT',true);
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ,login) values ( 'Bate Brkic 4','', '', '', '', '', '', '', '', '', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '21584546', 'ak', 'Markovic', '0635284796', 'ak',TRUE,'PACIJENT',true);




insert into sala(id, naziv, br, datum, rezervisana) values (1, 'Novo srce', 3, '21.10.2019.', 'false');
insert into sala(id, naziv, br, datum, rezervisana) values (4, 'Deca', 2, '20.10.2019.', 'false');
insert into sala(id, naziv, br, datum, rezervisana) values (2, 'Za prijem', 4, '22.12.2019.', 'true');
insert into sala(id, naziv, br, datum, rezervisana) values (5, 'Deca', 10, '9.3.2020.', 'false');
insert into sala(id, naziv, br, datum, rezervisana) values (3, 'Deca', 5, '1.1.2020.', 'true');
insert into sala(id, naziv, br, datum, rezervisana) values (10, 'Novo srce', 9, '12.12.2019.', 'true');
insert into sala(id, naziv, br, datum, rezervisana) values (7, 'Novo srce', 11, '5.12.2019.', 'false');

insert into termini(lekar_id, termin,sala, cena, popust, lekarime, lekarprezime, tippregleda,zakazan,idkorisnika) values (3, '2019-12-04T05:42', '2B', 1000, 10 , 'Sara', 'Saric','dermatologija','false',3);
insert into termini(lekar_id, termin,sala, cena, popust,lekarime, lekarprezime, tippregleda,zakazan,idkorisnika) values (2, '2019-10-04T06:50', '1A', 2000, 15, 'Mara', 'Maric', 'url','false',3);
insert into termini(lekar_id, termin,sala, cena, popust,lekarime, lekarprezime,tippregleda,zakazan,idkorisnika) values (1, '2019-12-05T06:50', '2B', 1500, 20, 'Zoran', 'Zoric', 'ocno', 'false',3);
insert into termini(lekar_id, termin,sala, cena, popust,lekarime, lekarprezime,tippregleda,zakazan,idkorisnika) values (2, '2019-11-04T05:30', '3C', 1800, 0, 'Mara', 'Maric', 'url', 'false',3);


insert into pregled(cena, datum, lekar, sala,tip, trajanje, vreme, zakazan) values (500, '27.12.2019', 'Jovan Jovic', '203', 'dermatolog', '15min', '09:00', TRUE);
insert into pregled(cena, datum, lekar, sala,tip, trajanje, vreme, zakazan) values (700, '01.02.2020', 'Jovan Jovic', '204', 'ocno', '30min', '10:00', TRUE);
insert into pregled(cena, datum, lekar, sala,tip, trajanje, vreme, zakazan) values (400, '15.01.2020', 'Jovan Jovic', '203', 'stomatolog', '15min', '08:00', TRUE);

insert into operacija(cena, datum, lekar, sala, tip, trajanje, vreme) values (1500, '10.01.2020', 'Jovan Jovic', '2A', 'dermatolog', '1h', '09:00');
insert into operacija(cena, datum, lekar, sala, tip, trajanje, vreme) values (2000, '15.02.2020', 'Jovan Jovic', '2A', 'stomatolog', '1h', '09:00');
insert into operacija(cena, datum, lekar, sala, tip, trajanje, vreme) values (1300, '25.12.2019', 'Jovan Jovic', '2A', 'ocno','2h' ,'09:00');
insert into operacija(cena, datum, lekar, sala, tip, trajanje, vreme) values (2300, '25.12.2019', 'Jovan Jovic', '2A', 'url','2h' ,'09:00');

insert into lek (sifra,naziv,dodatno) values ('APIISEF','Aspirin','ASPIRIN protect inhibira slepljivanje i nagomilavanje krvnih pločica (trombocita) i na taj način sprečava
nastajanje krvnih ugrušaka (tromba) – inhibicija agregacije trombocita. 
');
insert into lek (sifra,naziv,dodatno) values ('BRFSASO','Brufen','Lek BRUFEN, 100 mg/ 5 mL, sirup pripada grupi antiinflamatornih lekova protiv bolova.');
insert into lek (sifra,naziv,dodatno) values ('RTYDASO','Probiotik', 'Prema definiciji Svetske zdravstvene organizacije to su živi mikroorganizmi (bakterije i kvasnice) koje pružaju zdravstvenu korist domaćinu ako se unose u adekvatnim količinama.');


insert into dijagnoza (sifra,naziv,dodatno) values ('DWERFHN','Glavobolja','Glavobolja (Cephalea, Cephalalgia, grčka reč) je bol ili bolna senzacija u predelu glave i delova vratakoja, u odnosu na svoj nastanak i trajanje, može biti akutna ili hronična.');
insert into dijagnoza (sifra,naziv,dodatno) values ('DWEHGBC','Hipertenzija','Hipertenzija (visok krvni pritisak) je stanje u kome je krvni pritisak iznad 120/80 mmHg. Gornjipritisak(sistolni pritisak) zapravo je pritisak krvina zidove krvnih sudova u trenutkukada se srce kontrahuje, ');
insert into dijagnoza (sifra,naziv,dodatno) values ('DWRHGNC','Anemija', 'Anemija ili malokrvnost je stanje koje se karakteriše smanjenim nivoom hemoglobina u krvi i/ili smanjenim brojem eritrocita. Eritrociti su crvena krvna zrnca koja se stvaraju u koštanoj srži, a nakon sazrevanja cirkulišu u krvi.');

insert into lekarIPregledi (imelek, prezimelek, tipspecijalizacije, uloga, ocena) values ('Zoran', 'Zoric', 'ocno', 'LEKAR',8 );
insert into lekarIPregledi (imelek, prezimelek, tipspecijalizacije, uloga, ocena) values ('Mara', 'Maric', 'url', 'LEKAR',9 );
insert into lekarIPregledi (imelek, prezimelek, tipspecijalizacije, uloga, ocena) values ('Sara', 'Saric', 'dermatologija', 'LEKAR',6 );



insert into student (index_number, first_name, last_name) values ('ra1-2014', 'Marko', 'Marković');
insert into student (index_number, first_name, last_name) values ('ra2-2014', 'Milan', 'Milanović');
insert into student (index_number, first_name, last_name) values ('ra3-2014', 'Ivana', 'Ivanović');
insert into student (index_number, first_name, last_name) values ('ra4-2014', 'Bojan', 'Bojanović');
insert into student (index_number, first_name, last_name) values ('ra5-2014', 'Pera', 'Perić');
insert into student (index_number, first_name, last_name) values ('ra6-2014', 'Zoran', 'Zoranović');
insert into student (index_number, first_name, last_name) values ('ra7-2014', 'Bojana', 'Bojanović');
insert into student (index_number, first_name, last_name) values ('ra8-2014', 'Milana', 'Milanović');
insert into student (index_number, first_name, last_name) values ('ra9-2014', 'Jovana', 'Jovanić');

insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Bate Brkic 4','alergije', 'anamneza', 'bolesti', '25.04.1999.', '-1', 'B', 'muski', '70kg', '175cm', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '225846', 'markomarkovic', 'Markovic', '063528496', 'marko22',TRUE,'PACIJENT');
insert into korisnik3( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Kralja Petra 2','', '', '', '', '', '', '', '', '', 'Srbija','sanja22@gmail.com', 'Novi Sad', 'Sanja', '225586', 'sanjasanjic', 'Sanjic', '063222496', 'sanja22',TRUE,'PACIJENT');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Todora Jovanovica 5','', '', '', '', '', '', '', '', '', 'Srbija', 'petar22@gmail.com',  'Novi Sad', 'Petar', '125846', 'petarpetrovic', 'Petrovic', '067528856', 'petar22','TRUE','PACIJENT');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Todora Jovanovica 5','', '', '', '', '', '', '', '', '', 'Srbija', 'adminn22@gmail.com',  'Novi Sad', 'Petar', '125446', 'adminkc', 'Petrovic', '067528856', 'adminn','TRUE','ADMIN');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Jovana Subotica 10','', '', '', '', '', '', '', '', '', 'Srbija', 'lekar11@gmail.com',  'Novi Sad', 'Jovan', '888432', 'leka1111', 'Jovic', '064553772', 'jova','TRUE','LEKAR');
insert into korisnik3 ( adresa,alergije,anamneza,bolesti,datum,dioptrija,kgrupa, pol, tezina,visina, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Bate Brkic 4','', '', '', '', '', '', '', '', '', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '215846', 'asdasd', 'Markovic', '063528496', 'test',TRUE,'PACIJENT');

insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Bate Brkica 5', 1000, 'Srbija', 'Novi Sad', 'KlinikaABC', 7 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Miloša Crnjanskog 2', 1500, 'Srbija', 'Sremska Mitrovica', 'Zdravlje', 8 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Atinska 9', 1300, 'Srbija', 'Kragujevac', 'Klinika Mara', 6 );

insert into pregled(cena, datum, lekar, sala,tip, trajanje, vreme) values (500, '27.12.2019', 'Jovan Jovic', '203', 'operacija ociju', '15min', '09:00');

insert into operacija(cena, datum, lekar, sala, tip, trajanje, vreme) values (1500, '10.01.2020', 'Jovan Jovic', '2A', 'operacija ociju', '1h', '09:00');



insert into course (name) values ('Matematika');
insert into course (name) values ('Osnove programiranja');
insert into course (name) values ('Objektno programiranje');

insert into teacher (first_name, last_name) values ('Strahinja', 'Simić');
insert into teacher (first_name, last_name) values ('Marina', 'Antić');
insert into teacher (first_name, last_name) values ('Siniša', 'Branković');

insert into teaching (course_id, teacher_id) values (1, 1);
insert into teaching (course_id, teacher_id) values (1, 2);
insert into teaching (course_id, teacher_id) values (2, 2);
insert into teaching (course_id, teacher_id) values (3, 3);

insert into exam (student_id, course_id, date, grade) values (1, 1, '2016-02-01', 9);
insert into exam (student_id, course_id, date, grade) values (1, 2, '2016-04-19', 8);
insert into exam (student_id, course_id, date, grade) values (2, 1, '2016-02-01', 10);
insert into exam (student_id, course_id, date, grade) values (2, 2, '2016-04-19', 10);
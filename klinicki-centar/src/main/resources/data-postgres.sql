insert into student (index_number, first_name, last_name) values ('ra1-2014', 'Marko', 'Marković');
insert into student (index_number, first_name, last_name) values ('ra2-2014', 'Milan', 'Milanović');
insert into student (index_number, first_name, last_name) values ('ra3-2014', 'Ivana', 'Ivanović');
insert into student (index_number, first_name, last_name) values ('ra4-2014', 'Bojan', 'Bojanović');
insert into student (index_number, first_name, last_name) values ('ra5-2014', 'Pera', 'Perić');
insert into student (index_number, first_name, last_name) values ('ra6-2014', 'Zoran', 'Zoranović');
insert into student (index_number, first_name, last_name) values ('ra7-2014', 'Bojana', 'Bojanović');
insert into student (index_number, first_name, last_name) values ('ra8-2014', 'Milana', 'Milanović');
insert into student (index_number, first_name, last_name) values ('ra9-2014', 'Jovana', 'Jovanić');

insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Bate Brkic 4', 'Srbija', 'marko22@gmail.com', 'Novi Sad', 'Marko', '225846', 'markomarkovic', 'Markovic', '063528496', 'marko22',TRUE,'PACIJENT');
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ( 'Kralja Petra 2', 'Srbija','sanja22@gmail.com', 'Novi Sad', 'Sanja', '225586', 'sanjasanjic', 'Sanjic', '063222496', 'sanja22',TRUE,'PACIJENT');
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Todora Jovanovica 5', 'Srbija', 'petar22@gmail.com',  'Novi Sad', 'Petar', '125846', 'petarpetrovic', 'Petrovic', '067528856', 'petar22','TRUE','PACIJENT');
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Todora Jovanovica 5', 'Srbija', 'adminn22@gmail.com',  'Novi Sad', 'Petar', '125446', 'adminkc', 'Petrovic', '067528856', 'adminn','TRUE','ADMIN');
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Jovana Subotica 10', 'Srbija', 'lekar11@gmail.com',  'Novi Sad', 'Jovan', '888432', 'leka1111', 'Jovic', '064553772', 'jova','TRUE','LEKAR');
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Admin Admin 1', 'Srbija', 'admin@gmail.com',  'Novi Sad', 'Admin', '888888', 'admin', 'Admin', '064999858', 'admin','TRUE','ADMIN');
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Branka Radicevica 5', 'Srbija', 'miki@gmail.com',  'Novi Sad', 'Miki', '56623556', 'miki', 'Miki', '067528856', 'miki','TRUE','ADMIN_KLINIKE');
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Marsala Junaka 10', 'Srbija', 'cobi@gmail.com',  'Novi Sad', 'Cobi', '888432342', 'cobi', 'Cobi', '064553772', 'cobi','TRUE','ADMIN_KLINIKE');
insert into korisnik3 ( adresa, drzava, email, grad, ime, jed_br_osig, password, prezime,telefon, username,active,role ) values ('Anica Dobra 1', 'Srbija', 'ana@gmail.com',  'Novi Sad', 'Ana', '858568888', 'ana', 'Ana', '064999858', 'ana','TRUE','ADMIN_KLINIKE');

INSERT INTO administrator (user_id, first_login, predefinisani) VALUES ('6', true, true);

insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Bate Brkica 5', 1000, 'Srbija', 'Novi Sad', 'KlinikaABC', 7 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Miloša Crnjanskog 2', 1500, 'Srbija', 'Sremska Mitrovica', 'Zdravlje', 8 );
insert into klinika(adresa, cena, drzava, grad,naziv,ocena) values ( 'Atinska 9', 1300, 'Srbija', 'Kragujevac', 'Klinika Mara', 6 );

insert into lek (sifra,naziv,dodatno) values ('APIISEF','Aspirin','ASPIRIN protect inhibira slepljivanje i nagomilavanje krvnih pločica (trombocita) i na taj način sprečava
nastajanje krvnih ugrušaka (tromba) – inhibicija agregacije trombocita. 
');
insert into lek (sifra,naziv,dodatno) values ('BRFSASO','Brufen','Lek BRUFEN, 100 mg/ 5 mL, sirup pripada grupi antiinflamatornih lekova protiv bolova.');
insert into lek (sifra,naziv,dodatno) values ('RTYDASO','Probiotik', 'Prema definiciji Svetske zdravstvene organizacije to su živi mikroorganizmi (bakterije i kvasnice) koje pružaju zdravstvenu korist domaćinu ako se unose u adekvatnim količinama.');

insert into dijagnoza (sifra,naziv,dodatno) values ('DWERFHN','Glavobolja','Glavobolja (Cephalea, Cephalalgia, grčka reč) je bol ili bolna senzacija u predelu glave i delova vratakoja, u odnosu na svoj nastanak i trajanje, može biti akutna ili hronična.');
insert into dijagnoza (sifra,naziv,dodatno) values ('DWEHGBC','Hipertenzija','Hipertenzija (visok krvni pritisak) je stanje u kome je krvni pritisak iznad 120/80 mmHg. Gornjipritisak(sistolni pritisak) zapravo je pritisak krvina zidove krvnih sudova u trenutkukada se srce kontrahuje, ');
insert into dijagnoza (sifra,naziv,dodatno) values ('DWRHGNC','Anemija', 'Anemija ili malokrvnost je stanje koje se karakteriše smanjenim nivoom hemoglobina u krvi i/ili smanjenim brojem eritrocita. Eritrociti su crvena krvna zrnca koja se stvaraju u koštanoj srži, a nakon sazrevanja cirkulišu u krvi.');



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
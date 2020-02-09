package rs.ac.uns.ftn.informatika.jpa;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Pregled;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.OdobravanjePregledaRepozitorijum;
import rs.ac.uns.ftn.informatika.jpa.repository.TerminSaIdRepository;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.InformacijeOpregleduService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.LekarZaPrikazIPregledeService;
import rs.ac.uns.ftn.informatika.jpa.service.OdobravanjePregledaService;
import rs.ac.uns.ftn.informatika.jpa.service.OperacijeService;
import rs.ac.uns.ftn.informatika.jpa.service.PregledService;
import rs.ac.uns.ftn.informatika.jpa.service.SalaService;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTest {

	@Autowired
	private LekarZaPrikazIPregledeService lipServis;

	@Mock
	private KorisnikService korisnikServis;

	@Autowired
	private KorisnikRepository repoKorisnik;

	@Autowired
	private OdobravanjePregledaService opServis;

	@Autowired
	OdobravanjePregledaRepozitorijum opRepo;

	@Autowired
	private EmailService emailService;

	@Autowired
	private TerminSaIdRepository tidRepo;

	@Autowired
	 private KorisnikService korisnikService;
	
	 @Autowired
	 private LekServiceImpl lekService;
	 
	 @Autowired
	 private SalaService salaService;
	 
	 @Autowired
	 private InformacijeOpregleduService infoService;

	 @Autowired
	 private TerminSaIdService terService;
	 
	 @Autowired
	 private OperacijeService oService;
	 
	 @Autowired
	 private PregledService pService;
	 
	 @Autowired
	 private KlinikaService klinikaS;
	
	 @MockBean
		private KorisnikRepository repo;
	 
	@Test
	public void testKlinikaPokaziSve() {
		List<Klinika>allClinics=klinikaS.pokaziSveKlinike();
		assertThat(allClinics).hasSize(7);
	}
	
	@Test
	public void testTermini() {
		assertThat(terService.pokaziSveTermine()).isNotNull();
	}
	
	@Test
	public void testKorinikAdmin() {
		
		Korisnik novi=new Korisnik();
		Korisnik pacijent=new Korisnik();
		novi.setAdresa("a");
		novi.setAlergije("b");
		novi.setAnamneza("c");
		novi.setBolesti("d");
		novi.setDatum("e");
		novi.setDioptrija("f");
		novi.setDrzava("g");
		novi.setEmail("g@d");
		novi.setGrad("aa");
		novi.setId(258L);
		novi.setIme("Tamara");
		novi.setIsActive(true);
		novi.setJedBrOsig("888");
		novi.setKgrupa("a");
		novi.setPassword("tamaratadic");
		novi.setPol("zensko");
		novi.setPrezime("tadic");
		novi.setTelefon("5456");
		novi.setTezina("60");
		novi.setUsername("tamara11");
		novi.setVisina("222");
		korisnikService.saveMogKorisnika(novi);
		
		pacijent=korisnikService.findOne(258L);
		System.out.println("username je : "+pacijent.getUsername());
		//assertEquals(pacijent.getId(),258L);
		assertThat(pacijent).isNotNull();
	
	}

	@Test
	public void testPregeld() {
		Pregled p=pService.findOneById(1L);
		
		
		assertEquals(p.getSala(), "203");
		
	}

	@Test
	public void testGetKorisnikUsernamePassword() {
		Korisnik k= korisnikService.findByUsernameAndPassword("marko22", "markomarkovic");
		
		assertThat(k).isNotNull();

	}
	

	@Test
	public void testKorisnikPregled() {
		Korisnik k= korisnikService.findByUsername("marko22");
		Pregled p=pService.findOneById(3L);
		p.setKorisnikId(12L);
		
		p.setCena(2000);
		
		pService.save(p);
		
		
		Pregled p2=pService.findOneById(3L);
		
		assertThat(p).isNotNull();
		assertEquals(p.getCena(),2000);

		
	}
	
	@Test
	public void testCreateTermsReturnCreatedTerm() {
		
	}

	
	
	
}
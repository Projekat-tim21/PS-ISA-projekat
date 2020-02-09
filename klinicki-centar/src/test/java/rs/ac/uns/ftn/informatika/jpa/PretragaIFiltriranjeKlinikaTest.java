package rs.ac.uns.ftn.informatika.jpa;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.LekarZaPrikazIPregledeDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.TerminDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ZaposleniUKlinikamaDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PretragaIFiltriranjeKlinikaTest {

	private MockMvc mockMvc;

	@Autowired MockHttpSession session;

	//@Autowired
	//private TestRestTemplate restTemplate;
	
	@Autowired
	private TerminSaIdService servis;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	//@Mock
    
	
	@PostConstruct
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test    //listaSvihKlinika
	public void listaSvihKlinikaTest() throws Exception {
		Klinika terminiDto= new Klinika();
		Klinika terminiDto2= new Klinika();
		List<Klinika> terminiDtolista = new ArrayList<>();
		terminiDto.setAdresa("djsfalkjf");
		terminiDto.setId(5L);
		terminiDto.setDrzava("DRZ");
		terminiDto.setGrad("GRAD");
		terminiDto.setNaziv("KLIN");
		terminiDto.setOcena(10);
		terminiDto.setTip("url");
		
		
		terminiDto2.setAdresa("djsfalkjf");
		terminiDto2.setId(6L);
		terminiDto2.setDrzava("DRZ");
		terminiDto2.setGrad("GRAD");
		terminiDto2.setNaziv("KLIN");
		terminiDto2.setOcena(10);
		terminiDto2.setTip("url");
		
		terminiDtolista.add(terminiDto);
		terminiDtolista.add(terminiDto2);
		
		System.out.println("id termini " +terminiDto.getId());
		
		session.getAttribute("id"); 
		mockMvc.perform(get("/listaSvihKlinika?id=12").flashAttr("klinike", terminiDtolista)
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("listaKlinika"))
				.andExpect(forwardedUrl("/WEB-INF/view/listaKlinika.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("listaKlinika"));
				
	}


	@Test  //terminiUKlinici
	public void terminiUKliniciTest() throws Exception {
		LekarZaPrikazIPregledeDTO lipidto=new LekarZaPrikazIPregledeDTO();
		lipidto.setId(1L);
		lipidto.setImelek("savka");
		lipidto.setOcena(10);
		lipidto.setPrezimelek("savic");
		lipidto.setTipspecijalizacije("ocno");
		lipidto.setUloga("LEKAR");
		
		LekarZaPrikazIPregledeDTO lipidto2=new LekarZaPrikazIPregledeDTO();
		lipidto2.setId(2L);
		lipidto2.setImelek("savka");
		lipidto2.setOcena(10);
		lipidto2.setPrezimelek("savic");
		lipidto2.setTipspecijalizacije("ocno");
		lipidto2.setUloga("LEKAR");
		
		List<LekarZaPrikazIPregledeDTO>listalipidto=new ArrayList<LekarZaPrikazIPregledeDTO>();
		listalipidto.add(lipidto2);
		listalipidto.add(lipidto);
		
		List<ZaposleniUKlinikamaDTO> zaposleni=new ArrayList<ZaposleniUKlinikamaDTO>();
		ZaposleniUKlinikamaDTO zdto=new ZaposleniUKlinikamaDTO();
		ZaposleniUKlinikamaDTO zdto2=new ZaposleniUKlinikamaDTO();
		
		zdto.setId(5L);
		zdto.setIdklinike(6L);
		zdto.setIdlekara(8L);
		
		zdto2.setId(12L);
		zdto2.setIdklinike(10L);
		zdto2.setIdlekara(11L);
		
		zaposleni.add(zdto2);
		zaposleni.add(zdto);
		session.setAttribute("idpac", 12L);
		session.setAttribute("idklinike", 111L);
		
		
		TerminDTO terminiDto= new TerminDTO();
		TerminDTO terminiDto2= new TerminDTO();
		List<TerminDTO> terminiDtolista = new ArrayList<>();
		terminiDto.setCena(20);
		terminiDto.setId(20L);
		terminiDto.setIdkorisnika(24L);
		terminiDto.setKorisnikId(20L);
		terminiDto.setLekarId(13L);
		terminiDto.setLekarime("Pera");
		terminiDto.setLekarprezime("Peric");
		terminiDto.setOdobrenpregled(false);
		terminiDto.setPacijentime("Natasa");
		terminiDto.setPacijentprezime("Natic");
		terminiDto.setPopust(20);
		terminiDto.setPoslatnaobradu(false);
		terminiDto.setPrikaz(true);
		terminiDto.setSala("2b");
		terminiDto.setTermin("2020-12-05T10:50");
		terminiDto.setTippregleda("ocno");
		terminiDto.setZakazan(false);
		
		terminiDto2.setCena(20);
		terminiDto2.setId(202L);
		terminiDto2.setIdkorisnika(24L);
		terminiDto2.setKorisnikId(20L);
		terminiDto2.setLekarId(13L);
		terminiDto2.setLekarime("Pera");
		terminiDto2.setLekarprezime("Peric");
		terminiDto2.setOdobrenpregled(false);
		terminiDto2.setPacijentime("Natasa");
		terminiDto2.setPacijentprezime("Natic");
		terminiDto2.setPopust(20);
		terminiDto2.setPoslatnaobradu(false);
		terminiDto2.setPrikaz(true);
		terminiDto2.setSala("2b");
		terminiDto2.setTermin("2020-12-05T10:50");
		terminiDto2.setTippregleda("ocno");
		terminiDto2.setZakazan(false);
		
		terminiDtolista.add(terminiDto);
		terminiDtolista.add(terminiDto2);
		
		
		
		mockMvc.perform(get("/terminiUKlinici?idklinike=111&id=12").flashAttr("zaposleni", zaposleni).flashAttr("lipi",listalipidto).flashAttr("termini", terminiDtolista)
				
			.session(session))
			.andExpect(status().isOk()).andExpect(view().name("listaKlinika"))
			.andExpect(forwardedUrl("/WEB-INF/view/listaKlinika.jsp"))
			.andExpect(MockMvcResultMatchers.view().name("listaKlinika"));
		
	}

	@Test  //lekariUKlinici?idklinike=${klinika.id}&id pacijenta
	public void lekariUKlinici() throws Exception {
		
		LekarZaPrikazIPregledeDTO lipidto=new LekarZaPrikazIPregledeDTO();
		lipidto.setId(1L);
		lipidto.setImelek("savka");
		lipidto.setOcena(10);
		lipidto.setPrezimelek("savic");
		lipidto.setTipspecijalizacije("ocno");
		lipidto.setUloga("LEKAR");
		
		LekarZaPrikazIPregledeDTO lipidto2=new LekarZaPrikazIPregledeDTO();
		lipidto2.setId(2L);
		lipidto2.setImelek("savka");
		lipidto2.setOcena(10);
		lipidto2.setPrezimelek("savic");
		lipidto2.setTipspecijalizacije("ocno");
		lipidto2.setUloga("LEKAR");
		
		List<LekarZaPrikazIPregledeDTO>listalipidto=new ArrayList<LekarZaPrikazIPregledeDTO>();
		listalipidto.add(lipidto2);
		listalipidto.add(lipidto);
		
		List<ZaposleniUKlinikamaDTO> zaposleni=new ArrayList<ZaposleniUKlinikamaDTO>();
		ZaposleniUKlinikamaDTO zdto=new ZaposleniUKlinikamaDTO();
		ZaposleniUKlinikamaDTO zdto2=new ZaposleniUKlinikamaDTO();
		
		zdto.setId(5L);
		zdto.setIdklinike(6L);
		zdto.setIdlekara(8L);
		
		zdto2.setId(12L);
		zdto2.setIdklinike(10L);
		zdto2.setIdlekara(11L);
		
		zaposleni.add(zdto2);
		zaposleni.add(zdto);
		
		session.setAttribute("id", 12L);
		mockMvc.perform(get("/lekariUKlinici?idklinike=1&idpac=12").flashAttr("zaposleni", zaposleni).flashAttr("lipi",listalipidto)
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("listaKlinika"))
				.andExpect(forwardedUrl("/WEB-INF/view/listaKlinika.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("listaKlinika"));
				
	}

	
	
	@Test  ///listaSvihTerminaPacijent
	public void listaSvihTerminaPacijentTest() throws Exception {
		
		TerminDTO terminiDto= new TerminDTO();
		TerminDTO terminiDto2= new TerminDTO();
		List<TerminDTO> terminiDtolista = new ArrayList<TerminDTO>();
		terminiDto.setCena(20);
		terminiDto.setId(20L);
		terminiDto.setIdkorisnika(24L);
		terminiDto.setKorisnikId(20L);
		terminiDto.setLekarId(13L);
		terminiDto.setLekarime("Pera");
		terminiDto.setLekarprezime("Peric");
		terminiDto.setOdobrenpregled(false);
		terminiDto.setPacijentime("Natasa");
		terminiDto.setPacijentprezime("Natic");
		terminiDto.setPopust(20);
		terminiDto.setPoslatnaobradu(false);
		terminiDto.setPrikaz(true);
		terminiDto.setSala("2b");
		terminiDto.setTermin("2020-12-05T10:50");
		terminiDto.setTippregleda("ocno");
		terminiDto.setZakazan(false);
		
		terminiDto2.setCena(20);
		terminiDto2.setId(202L);
		terminiDto2.setIdkorisnika(24L);
		terminiDto2.setKorisnikId(20L);
		terminiDto2.setLekarId(13L);
		terminiDto2.setLekarime("Pera");
		terminiDto2.setLekarprezime("Peric");
		terminiDto2.setOdobrenpregled(false);
		terminiDto2.setPacijentime("Natasa");
		terminiDto2.setPacijentprezime("Natic");
		terminiDto2.setPopust(20);
		terminiDto2.setPoslatnaobradu(false);
		terminiDto2.setPrikaz(true);
		terminiDto2.setSala("2b");
		terminiDto2.setTermin("2020-12-05T10:50");
		terminiDto2.setTippregleda("ocno");
		terminiDto2.setZakazan(false);
		
		terminiDtolista.add(terminiDto);
		terminiDtolista.add(terminiDto2);
		
		Korisnik korisnikDTO=new Korisnik();
		korisnikDTO.setAdresa("djfha");
		korisnikDTO.setAlergije("dsfa");
		korisnikDTO.setAnamneza("dsfasdd");
		korisnikDTO.setBolesti("eee");
		korisnikDTO.setDatum("iejfo");
		korisnikDTO.setDioptrija("ewfwf");
		korisnikDTO.setDrzava("eeeewfwe");
		korisnikDTO.setEmail("vdvfddv");
		korisnikDTO.setGrad("iii");
		korisnikDTO.setId(12L);
		korisnikDTO.setIme("vdere");
		korisnikDTO.setIsActive(true);
		korisnikDTO.setJedBrOsig("8");
		korisnikDTO.setKgrupa("B");
		korisnikDTO.setPassword("vdv");
		korisnikDTO.setPol("vnnvvnnv");
		korisnikDTO.setPrezime("vev");
		//korisnikDTO.setRole("PACIJENT");
		korisnikDTO.setTelefon("655");
		korisnikDTO.setTezina("5");
		korisnikDTO.setUsername("sdf");
		korisnikDTO.setVisina("15");
		/*
		Korisnik korisnikDTO2=new Korisnik();
		korisnikDTO2.setAdresa("djfha");
		korisnikDTO2.setAlergije("dsfa");
		korisnikDTO2.setAnamneza("dsfasdd");
		korisnikDTO2.setBolesti("eee");
		korisnikDTO2.setDatum("iejfo");
		korisnikDTO2.setDioptrija("ewfwf");
		korisnikDTO2.setDrzava("eeeewfwe");
		korisnikDTO2.setEmail("vdvfddv");
		korisnikDTO2.setGrad("iii");
		korisnikDTO2.setId(12L);
		korisnikDTO2.setIme("vdere");
		korisnikDTO2.setIsActive(true);
		korisnikDTO2.setJedBrOsig("8");
		korisnikDTO2.setKgrupa("B");
		korisnikDTO2.setPassword("vdv");
		korisnikDTO2.setPol("vnnvvnnv");
		korisnikDTO2.setPrezime("vev");
		//korisnikDTO.setRole("PACIJENT");
		korisnikDTO2.setTelefon("655");
		korisnikDTO2.setTezina("5");
		korisnikDTO2.setUsername("sdf");
		korisnikDTO2.setVisina("15");
		*/
		//List<Korisnik>korisniklista = new ArrayList<Korisnik>();
		//korisniklista.add(korisnikDTO2);
		//korisniklista.add(korisnikDTO);
		session.setAttribute("id", 12L);
		session.setAttribute("idklinike", 1L);
		mockMvc.perform(get("/listaSvihTerminaPacijent?id=3&idpac=12&idklinike=1").flashAttr("termini", terminiDtolista).flashAttr("korisnik",korisnikDTO)
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("listaLekara"))
				.andExpect(forwardedUrl("/WEB-INF/view/listaLekara.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("listaLekara"));
				
	}
	
	
	@Test  ///zakazivanjePregledaIzaListeLekara
	public void zakazivanjePregledaIzaListeLekaraTest() throws Exception {
		
		TerminiSaId terminiDto= new TerminiSaId();
		
		terminiDto.setCena(20);
		terminiDto.setId(1L);
		terminiDto.setIdkorisnika(20L);
		terminiDto.setKorisnikId(25L);
		terminiDto.setLekarId(14L);
		terminiDto.setLekarime("Pera");
		terminiDto.setLekarprezime("Peric");
		terminiDto.setOdobrenpregled(false);
		terminiDto.setPopust(20);
		terminiDto.setPoslatnaobradu(false);
		terminiDto.setPrikaz(true);
		terminiDto.setSala("2b");
		terminiDto.setTermin("2020-12-05T10:50");
		terminiDto.setTippregleda("ocno");
		terminiDto.setZakazan(false);
		
		LekarZaPrikazIPreglede lipi=new LekarZaPrikazIPreglede();
		lipi.setId(5L);
		lipi.setImelek("savka");
		lipi.setOcena(10);
		lipi.setPrezimelek("savic");
		lipi.setTipspecijalizacije("ocno");
		lipi.setUloga("LEKAR");
		
		//session.setAttribute("id", 12L);
		session.setAttribute("idpac", 12L);
		session.setAttribute("idtermina", 1L);
		//session.setAttribute("pacijentId", 12L);
		mockMvc.perform(get("/zakazivanjePregledaIzaListeLekara?id=1&idpac=12").flashAttr("termini", terminiDto).flashAttr("lipi",lipi)
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("zahtevZaPregledom"))
				.andExpect(forwardedUrl("/WEB-INF/view/zahtevZaPregledom.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("zahtevZaPregledom"));
				
	}
	
	
	//posaljiZahtevZaPregledom
	//posaljiZahtevZaPregledom?id=12&idtermina=1
	@Test  ///zakazivanjePregledaIzaListeLekara
	public void posaljiZahtevZaPregledomTest() throws Exception {
		
		TerminiSaId terminiDto= new TerminiSaId();
		
		terminiDto.setCena(20);
		terminiDto.setId(20L);
		terminiDto.setIdkorisnika(24L);
		terminiDto.setKorisnikId(20L);
		terminiDto.setLekarId(13L);
		terminiDto.setLekarime("Pera");
		terminiDto.setLekarprezime("Peric");
		terminiDto.setOdobrenpregled(false);
		terminiDto.setPopust(20);
		terminiDto.setPoslatnaobradu(false);
		terminiDto.setPrikaz(true);
		terminiDto.setSala("2b");
		terminiDto.setTermin("2020-12-05T10:50");
		terminiDto.setTippregleda("ocno");
		terminiDto.setZakazan(false);
		
		LekarZaPrikazIPreglede lipi=new LekarZaPrikazIPreglede();
		lipi.setId(1L);
		lipi.setImelek("savka");
		lipi.setOcena(10);
		lipi.setPrezimelek("savic");
		lipi.setTipspecijalizacije("ocno");
		lipi.setUloga("LEKAR");
		
		session.setAttribute("id", 1L);
		session.setAttribute("idpac", 1L);
		session.setAttribute("idtermina", 123L);
		session.setAttribute("pacijentId", 1L);
		mockMvc.perform(post("/posaljiZahtevZaPregledom?id=12&idtermina=1")
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("loginBezDobrodosli"))
				.andExpect(forwardedUrl("/WEB-INF/view/loginBezDobrodosli.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("loginBezDobrodosli"));
				
	}
	
	
	@Test  ///uspesnoZakazanPregled2
	public void uspesnoZakazanPregled2Test() throws Exception {
		
		TerminiSaId termin= new TerminiSaId();
		
		termin.setCena(20);
		termin.setId(20L);
		termin.setIdkorisnika(24L);
		termin.setKorisnikId(20L);
		termin.setLekarId(13L);
		termin.setLekarime("Pera");
		termin.setLekarprezime("Peric");
		termin.setOdobrenpregled(false);
		termin.setPopust(20);
		termin.setPoslatnaobradu(false);
		termin.setPrikaz(true);
		termin.setSala("2b");
		termin.setTermin("2020-12-05T10:50");
		termin.setTippregleda("ocno");
		termin.setZakazan(false);
		
		LekarZaPrikazIPreglede lipi=new LekarZaPrikazIPreglede();
		lipi.setId(1L);
		lipi.setImelek("savka");
		lipi.setOcena(10);
		lipi.setPrezimelek("savic");
		lipi.setTipspecijalizacije("ocno");
		lipi.setUloga("LEKAR");
		
	
		session.setAttribute("idpac", 1L);
		session.setAttribute("idtermina", 123L);
		session.setAttribute("termini", 3L);
		session.setAttribute("pacijentId",1L);
		mockMvc.perform(get("/uspesnoZakazanPregled2?id=1&idpac=12").flashAttr("lipi",lipi).flashAttr("termini", termin)
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("zahtevZaPregledom"))
				.andExpect(forwardedUrl("/WEB-INF/view/zahtevZaPregledom.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("zahtevZaPregledom"));
				
	}
}
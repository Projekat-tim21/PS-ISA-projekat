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

import rs.ac.uns.ftn.informatika.jpa.dto.TerminDTO;
import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.TerminiSaId;
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PreglediZakazivanjeTest {

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

	@Test    //zakaziPregledKojiJeDef
	public void zakazivanjePregledaKojiJeDefTest() throws Exception {
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
		
		System.out.println("id termini " +terminiDto.getId());
		
		session.getAttribute("id"); 
		mockMvc.perform(get("/zakaziPregledKojiJeDef").flashAttr("termini", terminiDtolista)
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("listaLekara"))
				.andExpect(forwardedUrl("/WEB-INF/view/listaLekara.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("listaLekara"));
				
	}


	@Test  //uspesnoZakazanPregled2
	public void uspesnoZakazanPregled2Test() throws Exception {
		LekarZaPrikazIPreglede lipidto=new LekarZaPrikazIPreglede();
		lipidto.setId(1L);
		lipidto.setImelek("savka");
		lipidto.setLekarveza(2L);
		lipidto.setOcena(10);
		lipidto.setPrezimelek("savic");
		lipidto.setTipspecijalizacije("ocno");
		lipidto.setUloga("LEKAR");
		
		TerminiSaId termin=new TerminiSaId();
		termin.setCena(20);
		termin.setId(202L);
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
		servis.saveMojTermin(termin);
		session.setAttribute("idtermina", 1L);
		session.setAttribute("idpac", 12L);
		mockMvc.perform(get("/uspesnoZakazanPregled2?id=1&idpac=12").flashAttr("termini", termin).flashAttr("lipidto", lipidto)
				
			.session(session))
			.andExpect(status().isOk()).andExpect(view().name("zahtevZaPregledom"))
			.andExpect(forwardedUrl("/WEB-INF/view/zahtevZaPregledom.jsp"))
			.andExpect(MockMvcResultMatchers.view().name("zahtevZaPregledom"));
		
	}

	@Test  //posaljiZahtevZaPregledom
	public void posaljiZahtevZaPregledomTest() throws Exception {
		session.setAttribute("id", 12L);
		mockMvc.perform(post("/posaljiZahtevZaPregledom?id=12&idtermina=1")
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("loginBezDobrodosli"))
				.andExpect(forwardedUrl("/WEB-INF/view/loginBezDobrodosli.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("loginBezDobrodosli"));
				
	}

}


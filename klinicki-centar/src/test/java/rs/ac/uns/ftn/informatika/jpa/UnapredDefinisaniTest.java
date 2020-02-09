package rs.ac.uns.ftn.informatika.jpa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import rs.ac.uns.ftn.informatika.jpa.dto.LekarZaPrikazIPregledeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.OdobravanjePregleda;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnapredDefinisaniTest {

	private MockMvc mockMvc;

	@Autowired MockHttpSession session;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@PostConstruct
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/*LekarZaPrikazIPregledeDTO lipidto=new LekarZaPrikazIPregledeDTO();
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
	*/
	@Test //AdminPraviPreglede
	public void adminPraviPreglede() throws Exception {
		
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
		
		mockMvc.perform(get("/AdminPraviPreglede").flashAttr("lipi", listalipidto)
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("adminZaPreglede"))
				.andExpect(forwardedUrl("/WEB-INF/view/adminZaPreglede.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("adminZaPreglede"));
	}

	@Test
	public void kreirajPregledZaLekara() throws Exception {
		session.setAttribute("id", 1L);
		session.setAttribute("imeLekaraTransfer", "savka");
		session.setAttribute("przLekaraTransfer", "savic");
		mockMvc.perform(get("/kreirajPregledZaLekara?id=1")
				.session(session))
				.andExpect(forwardedUrl("/WEB-INF/view/adminZaPreglede.jsp"))
				.andExpect(status().isOk()).andExpect(view().name("adminZaPreglede"))
				.andExpect(MockMvcResultMatchers.view().name("adminZaPreglede"));
				
	}

	@Test //sacuvajTermine2
	public void sacuvajTermine2() throws Exception {
		//session.setAttribute("lekarId", "1");
		
		mockMvc.perform(post("/sacuvajTermine2")
				.param("lekarId", "1")
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("adminZaPreglede"))
				.andExpect(forwardedUrl("/WEB-INF/view/adminZaPreglede.jsp"))
				.andExpect(view().name("adminZaPreglede"))
				.andExpect(MockMvcResultMatchers.view().name("adminZaPreglede"));
	}
	
	@Test //zahteviZaPregledom
	public void zahteviZaPregledom() throws Exception {
		OdobravanjePregleda od=new OdobravanjePregleda();
		OdobravanjePregleda od2=new OdobravanjePregleda();
		List<OdobravanjePregleda> od3=new ArrayList<OdobravanjePregleda>();
		od.setCenaop(2000);
		od.setId(1L);
		od.setIdpacijenta(12L);
		od.setIdtermina(3L);
		od.setImelekara("savka");
		od.setImepacijenta("nikola");
		od.setJedbrosigpac("11223355444");
		od.setLekaridop(4L);
		od.setOdobrenpregledop(false);
		od.setPopustop(20);
		od.setPrezimelekara("savic");
		od.setPrezimepacijenta("nikolic");
		od.setSalaop("12B");
		od.setTerminzahtev("2019-12-04T09:42");
		od.setTipspecijalizacije("url");
		
		od2.setCenaop(2000);
		od2.setId(11L);
		od2.setIdpacijenta(112L);
		od2.setIdtermina(31L);
		od2.setImelekara("savka");
		od2.setImepacijenta("nikola");
		od2.setJedbrosigpac("11223355444");
		od2.setLekaridop(41L);
		od2.setOdobrenpregledop(false);
		od2.setPopustop(20);
		od2.setPrezimelekara("savic");
		od2.setPrezimepacijenta("nikolic");
		od2.setSalaop("12B");
		od2.setTerminzahtev("2019-12-04T09:42");
		od2.setTipspecijalizacije("url");
		od3.add(od2);
		od3.add(od);
		
		mockMvc.perform(get("/AdminPraviPreglede").flashAttr("opi", od3)
				.session(session))
				.andExpect(status().isOk()).andExpect(view().name("adminZaPreglede"))
				.andExpect(forwardedUrl("/WEB-INF/view/adminZaPreglede.jsp"))
				.andExpect(MockMvcResultMatchers.view().name("adminZaPreglede"));
	}

}
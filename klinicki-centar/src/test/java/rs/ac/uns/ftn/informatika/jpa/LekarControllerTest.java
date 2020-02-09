package rs.ac.uns.ftn.informatika.jpa;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PregledDTO;
import rs.ac.uns.ftn.informatika.jpa.service.PregledService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = JpaExampleApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")



public class LekarControllerTest {
	
	 @Autowired
	    private TestRestTemplate restTemplate;
	 
	 @Autowired
	    private PregledService pService;
	 
	 private ObjectMapper jsonMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
	    private static final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
	            MediaType.APPLICATION_JSON.getSubtype(),
	            Charset.forName("utf8"));
	    private static int id = 1;
	    
	  @Autowired
	   MockMvc mockMvc;
	  
	  @Test
	    public void zakaziPL() throws URISyntaxException
	    {
	        final String baseUrl = "http://localhost:8081/"+"sacuvajNoviPregled"+"/"+24L+'/'+12L;
	        URI uri = new URI(baseUrl);
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true");
	        SimpleDateFormat vreme=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	        Date date1=new Date();
	        try {
	            date1 = vreme.parse("2020-05-05T15:42");
	        }
	        catch(Exception e) {}
	        PregledDTO pDTO = new PregledDTO();
	        pDTO.setIdlekarpregled("6");
	        pDTO.setKorisnikId(24L);
	        pDTO.setIdpacijenta(12L);
	        pDTO.setTerminpregled("2020-05-05T15:42");
	        pDTO.setObradjen(false);
	       
			LocalDate sada=java.time.LocalDate.now();
			Date date2=java.sql.Date.valueOf(sada);
			if(date1.compareTo(date2) < 0) {
				System.out.println("Date1 is before Date3");
				KorisnikDTO korisnikDTO=new KorisnikDTO();
				korisnikDTO.setId(12L);
				KorisnikDTO korisnikDTO1=new KorisnikDTO();
				korisnikDTO1.setId(24L);
			}
			
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri,pDTO,String.class);
	        Assert.assertEquals(302, result.getStatusCodeValue());
	    }
	  
	  @Test
	    void cuvajPregled() throws Exception {
	        SimpleDateFormat vreme=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	        Date date1=new Date();
	        try {
	            date1 = vreme.parse("2020-05-05T15:42");
	        }
	        catch(Exception e) {
	        }
	        PregledDTO pDTO = new PregledDTO();
	        pDTO.setIdlekarpregled("6");
	        pDTO.setKorisnikId(24L);
	        pDTO.setIdpacijenta(12L);
	        pDTO.setTerminpregled("2020-05-05T15:42");
	        pDTO.setObradjen(false);
	        System.out.println(pDTO.getTerminpregled());
	        LocalDate sada=java.time.LocalDate.now();
			Date date2=java.sql.Date.valueOf(sada);
			if(date1.compareTo(date2) < 0) {
				System.out.println("Date1 is before Date3");
				KorisnikDTO korisnikDTO=new KorisnikDTO();
				korisnikDTO.setId(12L);
				KorisnikDTO korisnikDTO1=new KorisnikDTO();
				korisnikDTO1.setId(24L);
			}
	        
	        mockMvc.perform(post("/sacuvajNoviPregled/"+24L+"/"+12L)
	                .contentType(contentType)
	                .content(jsonMapper.writeValueAsString(pDTO)
	                )).andExpect(status().isFound());

	    }

}

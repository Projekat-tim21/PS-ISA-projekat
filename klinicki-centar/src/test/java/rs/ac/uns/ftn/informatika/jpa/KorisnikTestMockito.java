package rs.ac.uns.ftn.informatika.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KorisnikTestMockito {

	@Autowired
	private KorisnikService servis;
	
	@Mock
    KorisnikDTO dao;
	
	private MockMvc mockMvc;
	
	@MockBean
	private KorisnikRepository repo;
	
	@Test
    public void saveKorisnikTest()
    {
		Korisnik k=new Korisnik( "pera","peric", "64645", "pera@hg", "nade matic 5", "Srbija", "Novi Sad", "15656646", "pera", "peric", "PACIJENT");
       // EmployeeVO emp = new EmployeeVO(1,"Lokesh","Gupta","user@email.com");
         servis.saveMogKorisnika(k);
      //  manager.addEmployee(emp);
         repo.save(k);
         k.getUsername();
    }
	  
	@Test
	public void getKorisniciTest() {
		when(repo.findAll()).thenReturn(Stream.of(new Korisnik((long) 20, "Bate Brkic 42","alergije2", "anamneza2", "bolesti2", "25.04.1999.", "2", "2b", "muski", "80kg", "190cm", "Srbija", "marko22@gmail.com")).collect(Collectors.toList()));
		assertEquals(1, servis.pokaziSveKorisnike().size());
	}
	
	@Test
    public void deleteApplication() throws Exception {      
      //  Mockito.when(servis.deleteMyUser(10001L)).thenReturn("SUCCESS");
        repo.deleteById(159L); //.deleteMyUser(10001L)).thenReturn("SUCCESS");
       // mockMvc.perform(MockMvcRequestBuilders.delete("/applications", 10001L))
         //       .andExpect(status().isOk());
    }
	
	 @Test
	    public void testFindAll() 
	    {
	        // given
	        Korisnik employee1 = new Korisnik(null, "dsf", "Lokesh", "Gupta", "howtodoinjava@gmail.com", "sdfs", "sdfssdf", "wef", "rfw", "dsf", null, null, null, null);
	        Korisnik employee2 = new Korisnik(null, "dsf", "Lokedfsh", "Gudsfpta", "howtodoi5njava@gmail.com", "sdfs", "sdfssdf", "wef5", "rfw", "dsf", null, null, null, null);
	        Korisnik employee3 = new Korisnik(null, "dsdsff", "Lokesh", "Gusdfpta", "howtodoinjava@gmail.com", "sdfs", "sdfssdf", "wef", "rf45w", "dsf", null, null, null, null);
	       // Employee employee2 = new Employee(2, "Alex", "Gussin", "example@gmail.com");
	        Korisnik employees = new Korisnik();
	        //employees.setEmployeeList(Arrays.asList(employee1, employee2));
	        List<Korisnik>k=new ArrayList<Korisnik>();
	        repo.save(employee1);
	        repo.save(employee2);
	        
	        employee1.getAdresa();
	       
	    }
	
	
	
	@Test
    public void EditUser()
    {
		Korisnik employee1 = new Korisnik(null, "dsf", "Lokesh", "Gupta", "howtodoinjava@gmail.com", "sdfs", "sdfssdf", "wef", "rfw", "dsf", null, null, null, null);
        Korisnik employee2 = new Korisnik(null, "dsf", "Lokedfsh", "Gudsfpta", "howtodoi5njava@gmail.com", "sdfs", "sdfssdf", "wef5", "rfw", "dsf", null, null, null, null);
        servis.editUser(55000L);
        
    }
}
	

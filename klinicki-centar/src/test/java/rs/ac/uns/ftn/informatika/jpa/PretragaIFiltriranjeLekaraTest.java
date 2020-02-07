package rs.ac.uns.ftn.informatika.jpa;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import rs.ac.uns.ftn.informatika.jpa.dto.KlinikaDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.repository.KlinikaRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PretragaIFiltriranjeLekaraTest {

	 @InjectMocks
	 KlinikaService servis;
	
	@Mock
    KlinikaDTO dto;
	
	@Mock
    KlinikaRepository klinikaRepo;
	
	
	
	  @Before
	    public void setUp() throws Exception {
	    }
/*
	  @Test
	  public void test2(){
	        given(dto.getNaziv()).willReturn("text");
	        given(klinikaRepo.findById((long) anyInt())).willReturn() .findOne(anyInt())).willReturn(entityMock);

	        //here is other testing stuff
	    }
	 
	 */
	 
	
	@Test
	  public void test() {
	    List<String> mockList = mock(List.class);
	    mockList.add("First");
	    when(mockList.get(0)).thenReturn("Mockito");
	    when(mockList.get(1)).thenReturn("JCG");
	    assertEquals("Mockito", mockList.get(0));
	    assertEquals("JCG", mockList.get(1));
	  }
	
	
	
	
	
}
	
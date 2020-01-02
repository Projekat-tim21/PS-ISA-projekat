package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.LekarZaPrikazIPreglede;
import rs.ac.uns.ftn.informatika.jpa.model.ZaposleniUKlinikama;
import rs.ac.uns.ftn.informatika.jpa.repository.LekarZaPrikazIPregledeRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.ZaposleniUKlinikamaRepository;

@Service
@Transactional
public class ZaposleniUKlinikamaService {



		private final ZaposleniUKlinikamaRepository zRepo;
		
		
		
		public ZaposleniUKlinikamaService(ZaposleniUKlinikamaRepository zRepo) {
			this.zRepo=zRepo;
		}


		public ZaposleniUKlinikama findOne(long idlekara) {
			return zRepo.findById(idlekara).orElseGet(null);
		}
		

		


/*
		public List<ZaposleniUKlinikama> pokaziSveZaposleneLekareUTojKlinici(long idKlinike) {
			List<ZaposleniUKlinikama> zaposleni=new ArrayList<ZaposleniUKlinikama>();
			for(ZaposleniUKlinikama zaposlen : zRepo.findByIdklinike(idKlinike)) {
				zaposleni.add(zaposlen);
			}
			
			List<LekarZaPrikazIPreglede> lipi=new ArrayList<LekarZaPrikazIPreglede>();
			for(LekarZaPrikazIPreglede lip : ) {
				zaposleni.add(zaposlen);
			}
			
			
			return zaposleni;
		}
		*/
		/*
		public List<ZaposleniUKlinikamaService> pokaziSveKorisnikeKojiSuLekari() {
			List<LekarZaPrikazIPreglede> lipi=new ArrayList<LekarZaPrikazIPreglede>();
			for(LekarZaPrikazIPreglede lip : lipRepo.findAll()) {
				lipi.add(lip);
			}
			return lipi;
		}*/
		/*
		public ZaposleniUKlinikamaService findOne(Long id) {
			return zRepo.findById(id).orElseGet(null);
		}*/
	
	
	
	
}

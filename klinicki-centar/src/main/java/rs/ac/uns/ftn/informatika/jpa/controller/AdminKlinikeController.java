package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.dto.InformacijeOpregleduDTO;
import rs.ac.uns.ftn.informatika.jpa.model.InformacijeOpregledu;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;
import rs.ac.uns.ftn.informatika.jpa.model.Operacija;
import rs.ac.uns.ftn.informatika.jpa.model.Sala;
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
import rs.ac.uns.ftn.informatika.jpa.service.TerminSaIdService;
import rs.ac.uns.ftn.informatika.jpa.service.SalaService;

@Controller
public class AdminKlinikeController {

	private Logger logger = LoggerFactory.getLogger(LekarZaPrikazIPregledeController.class);

	@Autowired
	private LekarZaPrikazIPregledeService lipServis;

	@Autowired
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
	 
	 
	 @GetMapping("/prikaziOperacijeBezSale")
		public String prikazOperacijaBezSale(HttpServletRequest request) {
		 	HttpSession session = request.getSession();
	    	Object id2 = session.getAttribute("id");
	    	System.out.println(id2);
	    	List<Operacija> prikaz=new ArrayList<Operacija>();
	    	List<Operacija> o=oService.pokaziSveBezSale();
	    	for(int i=0; i<o.size();i++) {
	    	Korisnik doktor=korisnikService.findOne(o.get(i).getKorisnikId());
	    	Korisnik admin=korisnikService.findOne((Long) id2);
	    	if(doktor.getKlinika().getId()==admin.getKlinika().getId()) {
	    		System.out.println("IF"+doktor.getKlinika().getId());
	    		System.out.println(admin.getKlinika().getId());
	    		prikaz.add(o.get(i));
	    	}else {
	    		System.out.println("ELSE"+doktor.getKlinika().getId());
	    		System.out.println(admin.getKlinika().getId());
	    		
	    	}
		 	
	    	}
	    	request.setAttribute("operacije", prikaz);
			request.setAttribute("mode", "ALL_OPERACIJE");
			return "listaOperacijaBezSale";
		}
	 
	 @GetMapping("/dodajSalu/{operacijaId}")
	    public ModelAndView novaSala(@PathVariable Long operacijaId,HttpServletRequest request) {
	    	request.setAttribute("operacija", oService.findOneById(operacijaId));
			Operacija oper=oService.findOneById(operacijaId);
			try {
				request.setAttribute("sale", salaService.pokaziZaDatum(oper.getTerminoperacija()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
	    	request.setAttribute("mode", "ALL_OPERACIJE");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("rezervisiSalu");
	        return modelAndView;
	    }
	 
	 @RequestMapping(value="/rezervisiSalu/{operacijaId}/{salaId}",method = { RequestMethod.GET, RequestMethod.POST }) // korisnik povezan sa valuom iz js
		public ModelAndView rezervisiSalu(@PathVariable Long operacijaId,@PathVariable Long salaId,
				HttpServletRequest request) throws ParseException {
		
		 	Operacija izBaze=oService.findOneById(operacijaId);
		 	Sala sala=salaService.findOneById(salaId);
			Operacija o= new Operacija();
			o.setId(izBaze.getId());
			o.setIdpacijenta(izBaze.getIdpacijenta());
			o.setIdlekaroperacija(izBaze.getIdlekaroperacija());
			o.setSala(sala.getNaziv());
			if(izBaze.getTerminoperacija().equals(sala.getDatum())) {
				try {
					Korisnik koris=korisnikService.findOne(izBaze.getIdlekaroperacija());
						emailService.sendNotificaitionOperacijaPacijent( koris,sala.getDatum());
					}catch( Exception e ){
						logger.info("Greska prilikom slanja emaila: " + e.getMessage());
					}
			}else {
			try {
				Korisnik koris=korisnikService.findOne(izBaze.getIdlekaroperacija());
					emailService.sendNotificaitionPromenaDatumaOperacije( koris,sala.getDatum());
				}catch( Exception e ){
					logger.info("Greska prilikom slanja emaila: " + e.getMessage());
				}
			}
			o.setTerminoperacija(sala.getDatum());
			o.setObradjen(true);
			sala.setRezervisana(true);
			salaService.save(sala);
			oService.save(o);
			request.setAttribute("message", "uspesno kreirana operacija");
			request.setAttribute("operacija", oService.findOneById(operacijaId));
			request.setAttribute("sala", salaService.findOneById(salaId));
			request.setAttribute("mode", "MODE_LEKARI");
			LinkedList<Korisnik> list = getList();
			ModelAndView map = new ModelAndView("dodeliLekareOperaciji");
		        map.addObject("lists", list);
		        return map;
		}
	 
	 private LinkedList<Korisnik> getList(){
		    LinkedList<Korisnik> list = new LinkedList<>();
		    
		    List<Korisnik> lekari= korisnikService.pokaziLekare();
		    
		    for(int i=0; i<lekari.size(); i++) {
		    	list.add(lekari.get(i));
		    }
		   

		    return list;
		}
	 
	 @RequestMapping(value="/obavezniLekari/{operacijaId}/{salaId}", method = { RequestMethod.GET, RequestMethod.POST } )
	    public ModelAndView noviPregled(@PathVariable Long operacijaId,@PathVariable Long salaId,HttpServletRequest request) {
		   
	        List<Korisnik> lekari = new ArrayList<Korisnik>();
	        Set<Korisnik> doktori = new HashSet<Korisnik>();
	        String[] lekar = request.getParameterValues("lekari");
	        for(int i=0;i<lekar.length;i++) {
	        	String[] parts = lekar[i].toString().split(" ");
	        	String idLekara=parts[0].toString();
	        	Long idLong=Long.parseLong(idLekara);
	        	Korisnik k=korisnikService.findOne(idLong);
	        	lekari.add(k);
	        	doktori.add(k);
	        	System.out.println(parts[0].toString());
	        }
	        System.out.println("OBAVEZNI LEKARI BROJ "+ lekari.size());
	        for(int i=0; i<lekari.size(); i++) {
	        	Operacija izBaze=oService.findOneById(operacijaId);
	        	Operacija nova=new Operacija();
	        	nova.setIdlekaroperacija(lekari.get(i).getId());
	        	nova.setIdpacijenta(izBaze.getIdpacijenta());
	        	nova.setLekarimeoperacija(izBaze.getLekarimeoperacija());
	        	nova.setLekarprezimeoperacija(izBaze.getLekarprezimeoperacija());
	        	nova.setObavljenaoperacija(izBaze.isObavljenaoperacija());
	        	nova.setObradjen(izBaze.getObradjen());
	        	nova.setOcenaoperacije(izBaze.getOcenaoperacije());
	        	nova.setSala(izBaze.getSala());
	        	nova.setTerminoperacija(izBaze.getTerminoperacija());
	        	nova.setTip(izBaze.getTip());
	        	nova.setTrajanje(izBaze.getTrajanje());
	        	oService.save(nova);
	        	try {
					Korisnik koris=korisnikService.findOne(lekari.get(i).getId());
						emailService.sendNotificaitionObavezanLekarOperacija( koris,nova.getTerminoperacija());
					}catch( Exception e ){
						logger.info("Greska prilikom slanja emaila: " + e.getMessage());
					}
				}
	        Operacija operacija=oService.findOneById(operacijaId);
	        operacija.setLekari(doktori);
	        operacija.setId(operacijaId);
	        oService.save(operacija);
	        
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("uspesanA");
	        return modelAndView;
	    }
	 
	 @Scheduled(cron = "${greeting.cron}")
		public void cronJob() {
			
			// neka logika
			long pause = 5000;
			long start = System.currentTimeMillis();
			
			List<Operacija> bezSale=oService.pokaziSveBezSale();
			List<Sala> sale=salaService.sveSlobodne();
			Boolean gotovo=false;
			
			if(bezSale.size()==sale.size() || bezSale.size()<sale.size()) {
				for(int i=0; i<bezSale.size(); i++) {
					Operacija izBaze=oService.findOneById(bezSale.get(i).getId());
				 	Sala sala=salaService.findOneById(sale.get(i).getId());
					Operacija o= new Operacija();
					o.setId(izBaze.getId());
					o.setIdpacijenta(izBaze.getIdpacijenta());
					o.setIdlekaroperacija(izBaze.getIdlekaroperacija());
					o.setSala(sala.getNaziv());
					if(izBaze.getTerminoperacija().equals(sala.getDatum())) {
						try {
							Korisnik koris=korisnikService.findOne(izBaze.getIdlekaroperacija());
								emailService.sendNotificaitionOperacijaPacijent( koris,sala.getDatum());
							}catch( Exception e ){
								logger.info("Greska prilikom slanja emaila: " + e.getMessage());
							}
					}else {
					try {
						Korisnik koris=korisnikService.findOne(izBaze.getIdlekaroperacija());
							emailService.sendNotificaitionPromenaDatumaOperacije( koris,sala.getDatum());
						}catch( Exception e ){
							logger.info("Greska prilikom slanja emaila: " + e.getMessage());
						}
					}
					o.setTerminoperacija(sala.getDatum());
					o.setObradjen(true);
					sala.setRezervisana(true);
					salaService.save(sala);
					oService.save(o);
					gotovo=true;
				}
			}else {
				for(int i=0; i<sale.size(); i++) {
					Operacija izBaze=oService.findOneById(bezSale.get(i).getId());
				 	Sala sala=salaService.findOneById(sale.get(i).getId());
					Operacija o= new Operacija();
					o.setId(izBaze.getId());
					o.setIdpacijenta(izBaze.getIdpacijenta());
					o.setIdlekaroperacija(izBaze.getIdlekaroperacija());
					o.setSala(sala.getNaziv());
					if(izBaze.getTerminoperacija().equals(sala.getDatum())) {
						try {
							Korisnik koris=korisnikService.findOne(izBaze.getIdlekaroperacija());
								emailService.sendNotificaitionOperacijaPacijent( koris,sala.getDatum());
							}catch( Exception e ){
								logger.info("Greska prilikom slanja emaila: " + e.getMessage());
							}
					}else {
					try {
						Korisnik koris=korisnikService.findOne(izBaze.getIdlekaroperacija());
							emailService.sendNotificaitionPromenaDatumaOperacije( koris,sala.getDatum());
						}catch( Exception e ){
							logger.info("Greska prilikom slanja emaila: " + e.getMessage());
						}
					}
					o.setTerminoperacija(sala.getDatum());
					o.setObradjen(true);
					sala.setRezervisana(true);
					salaService.save(sala);
					oService.save(o);
					gotovo=true;
				}
			}
			
			do {
				if (gotovo=true) {
					break;
				}
			} while (true);
		
			logger.info("< cronJob");
		}
	 }

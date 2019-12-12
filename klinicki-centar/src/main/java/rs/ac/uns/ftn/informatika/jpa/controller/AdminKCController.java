package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.dto.DijagnozaDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.KlinikaDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.KorisnikDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.LekDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.Response;
import rs.ac.uns.ftn.informatika.jpa.model.Dijagnoza;
import rs.ac.uns.ftn.informatika.jpa.model.Klinika;
import rs.ac.uns.ftn.informatika.jpa.model.Korisnik;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;
import rs.ac.uns.ftn.informatika.jpa.model.Role;
import rs.ac.uns.ftn.informatika.jpa.service.DijagnozaServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;
import rs.uns.ac.ftn.informatika.jpa.constatns.AppConstant;

@Controller
public class AdminKCController {
	

	private Logger logger = LoggerFactory.getLogger(AdminKCController.class);
	
	@Autowired
	private EmailService emailService;
	
	 @Autowired
	    private KorisnikService korisnikService;
	 
	 @Autowired
	 private KlinikaService klinikaService;
	
	 
	 @Autowired
	 private LekServiceImpl lekService;
	 
	 @Autowired
	 private DijagnozaServiceImpl dijagnozaService;

	 	@Value("${max.result.per.page}")
	    private int maxResults;

	    @Value("${max.card.display.on.pagination.tray}")
	    private int maxPaginationTraySize;

	    
	    
	    

	   /* @GetMapping("/zahteviRegistrovanje")
	    public ModelAndView home(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
	                             @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
	                             HttpServletRequest request, HttpServletResponse response) {

	        ModelAndView modelAndView = new ModelAndView();
	     
	            modelAndView.setViewName("home");
	            Page<Korisnik> allUsers = korisnikService.listUsers(PageRequest.of(page, size, Sort.by("firstName")));
	            modelAndView.addObject("allUsers", allUsers);
	            modelAndView.addObject("maxTraySize", size);
	            modelAndView.addObject("currentPage", page);

	        return modelAndView;
	    }*/



	   /* @GetMapping("/searchBox")
	    public ModelAndView searchByTerm(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
	                                     @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
	                                     @RequestParam(value = "searchTerm", required = false) String searchTerm) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("home");
	        Page<Korisnik> allUsers = korisnikService.searchByTerm(searchTerm.trim(), PageRequest.of(page, size, Sort.by("firstName")));
	        modelAndView.addObject("allUsers", allUsers);
	        modelAndView.addObject("maxTraySize", size);
	        modelAndView.addObject("currentPage", page);
	        return modelAndView;
	    }*/



	    @GetMapping("/search")
	    public ModelAndView search() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("search");
	        return modelAndView;
	    }

	 /*   @GetMapping("/lekovi")
	    public ModelAndView lekovi(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
                HttpServletRequest request, HttpServletResponse response) {
	    	 ModelAndView modelAndView = new ModelAndView();
	    	 modelAndView.setViewName("lekovi");
	         Page<Lek> allLekovi = lekService.listUsers(PageRequest.of(page, size, Sort.by("sifra")));
	         modelAndView.addObject("allLekovi", allLekovi);
	         modelAndView.addObject("maxTraySize", size);
	         modelAndView.addObject("currentPage", page);
	    	return null;
	    	
	    }

	  /*  @PostMapping("/searchSubmit")
	    public ModelAndView searchSubmit(@ModelAttribute SearchDTO searchDto) {
	        List<Korisnik> result = korisnikService.searchBy(searchDto.getSearchKeyword(), searchDto.getCriteria());
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("search");
	        modelAndView.addObject("result", result);
	        return modelAndView;
	    }*/



	    @GetMapping("/addNewAdminKC")
	    public ModelAndView addNewAdminKC() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-admin-kc");
	        return modelAndView;
	    }
	    
	    @GetMapping("/addNewAdminKlinike")
	    public ModelAndView addNewAdminKlinike() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-admin-klinike");
	        return modelAndView;
	    }

	    @GetMapping("/admin")
	    public ModelAndView addmin() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("admin");
	        return modelAndView;
	    }
	    
	    @GetMapping("/addNewDijagnoza")
	    public ModelAndView addNewDijagnoza() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-dijagnoza");
	        return modelAndView;
	    }

	    @GetMapping("/addNewKlinika")
	    public ModelAndView addNewKlinika() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-klinika");
	        return modelAndView;
	    }
	    
	    @GetMapping("/addNewLek")
	    public ModelAndView addNewLek() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-lek");
	        return modelAndView;
	    }
	    
	    @PostMapping("/noviLek")
	    public String noviLek(@ModelAttribute LekDTO lek) {
	        String result = "redirect:/";
	        Lek dbLek=lekService.findBySifra(lek.getSifra());
	        Lek lekic=new Lek();
	        lekic.setNaziv(lek.getNaziv());
	        lekic.setDodatno(lek.getDodatno());
	        lekic.setSifra(lek.getSifra());
	        if(lek.getNaziv()==null || lek.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewLek?error=Unesite naziv";
	        }
	        if (lek.getSifra() == null || lek.getSifra().trim().isEmpty()) {
	            result = "redirect:/addNewLek?error=Unesite sifru";
	        } else if (lek.getDodatno() == null || lek.getDodatno().trim().isEmpty()) {
	            result = "redirect:/addNewLek?error=Enter valid last name";
	        } 
	        if (dbLek == null) {
	            lekService.sacuvajLek(lekic);
	            result="redirect:/lekovi";
	        } else {
	            result = "redirect:/addNewLek?error=Lek vec postoji!";
	        }

	        return result;
	    }
	    
	    @PostMapping("/noviAdminKC")
	    public String noviAdminKC(@ModelAttribute KorisnikDTO korisnik) {
	        String result = "redirect:/";
	        Korisnik dbKorisnik=korisnikService.findByUsername(korisnik.getUsername());
	        Korisnik novi=new Korisnik();
	        novi.setUsername(korisnik.getUsername());
	        novi.setIme(korisnik.getIme());
	        System.out.println(novi.getIme());
	        novi.setPrezime(korisnik.getPrezime());
	        novi.setEmail(korisnik.getEmail());
	        novi.setPassword(korisnik.getPassword());
	        novi.setDrzava(korisnik.getDrzava());
	        novi.setGrad(korisnik.getGrad());
	        novi.setAdresa(korisnik.getAdresa());
	        novi.setTelefon(korisnik.getTelefon());
	        novi.setJedBrOsig(korisnik.getJedBrOsig());
	        novi.setFirst_Login(true);
	        novi.setIsActive(false);
	        novi.setRoleName(Role.ADMIN.name());
	        
	    
	        if(korisnik.getUsername()==null || korisnik.getUsername().trim().isEmpty()) {
	        	result = "redirect:/addNewAdminKC?error=Unesite naziv";
	        }
	        if (korisnik.getPassword() == null || korisnik.getPassword().trim().isEmpty()) {
	            result = "redirect:/addNewAdminKC?error=Unesite sifru";
	        } else if (korisnik.getEmail() == null || korisnik.getEmail().trim().isEmpty()) {
	            result = "redirect:/addNewAdminKC?error=Enter valid last name";
	        } 
	        if (dbKorisnik == null) {
	            korisnikService.saveMogKorisnika(novi); 
	            result="redirect:/pregledSvihAdmina";
	        } else {
	            result = "redirect:/addNewAdminKC?error=Lek vec postoji!";
	        }

	        try {
				emailService.sendNotificaitionZaAdminaKC(novi);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return result;
	    }
	    
	    @PostMapping("/noviAdminKlinike")
	    public String noviAdminKlinike(@ModelAttribute KorisnikDTO korisnik,HttpServletRequest request) {
	        String result = "redirect:/";
	        
	        Korisnik dbKorisnik=korisnikService.findByUsername(korisnik.getUsername());
	        Korisnik novi=new Korisnik();
	        novi.setUsername(korisnik.getUsername());
	        novi.setIme(korisnik.getIme());
	        System.out.println(novi.getIme());
	        novi.setPrezime(korisnik.getPrezime());
	        novi.setEmail(korisnik.getEmail());
	        novi.setPassword(korisnik.getPassword());
	        novi.setDrzava(korisnik.getDrzava());
	        novi.setGrad(korisnik.getGrad());
	        novi.setAdresa(korisnik.getAdresa());
	        novi.setTelefon(korisnik.getTelefon());
	        novi.setJedBrOsig(korisnik.getJedBrOsig());
	        novi.setFirst_Login(true);
	        novi.setIsActive(false);
	        novi.setRoleName(Role.ADMIN_KLINIKE.name());
	        String naziv=request.getParameter("odabrana");
	        Klinika clinic=klinikaService.findByNaziv(naziv);
	        System.out.println("KLINIKA "+ clinic.getNaziv());
	        //Klinika nova=new Klinika();
	        novi.setKlinika(clinic);
	        
	    
	        if(korisnik.getUsername()==null || korisnik.getUsername().trim().isEmpty()) {
	        	result = "redirect:/addNewAdminKlinike?error=Unesite naziv";
	        }
	        if (korisnik.getPassword() == null || korisnik.getPassword().trim().isEmpty()) {
	            result = "redirect:/addNewAdminKlinike?error=Unesite sifru";
	        } else if (korisnik.getEmail() == null || korisnik.getEmail().trim().isEmpty()) {
	            result = "redirect:/addNewAdminKlinike?error=Enter valid last name";
	        } 
	        if (dbKorisnik == null) {
	            korisnikService.saveMogKorisnika(novi); 
	            result="redirect:/pregledSvihAdminaKlinike";
	        } else {
	            result = "redirect:/addNewAdminKlinike?error=Admin vec postoji!";
	        }

	        try {
				emailService.sendNotificaitionZaAdminaKlinike(novi);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return result;
	    }
	    
	  /*  @PostMapping("/noviAdminKC")
	    public String noviAdminKC(@ModelAttribute Korisnik lek) {
	        String result = "redirect:/";
	        Lek dbLek=lekService.findBySifra(lek.getSifra());
	        if(lek.getNaziv()==null || lek.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewLek?error=Unesite naziv";
	        }
	        if (lek.getSifra() == null || lek.getSifra().trim().isEmpty()) {
	            result = "redirect:/addNewLek?error=Unesite sifru";
	        } else if (lek.getDodatno() == null || lek.getDodatno().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid last name";
	        } 
	        if (dbLek == null) {
	            lekService.sacuvajLek(lek);
	            result="redirect:/lekovi";
	        } else {
	            result = "redirect:/addNewUser?error=Lek vec postoji!";
	        }

	        return result;
	    }
	    */
	    @PostMapping("/novaDijagnoza")
	    public String novaDijagnoza(@ModelAttribute DijagnozaDTO dijagnoza) {
	        String result = "redirect:/";
	        Dijagnoza dbDijagnoza=dijagnozaService.findBySifra(dijagnoza.getSifra());
	        Dijagnoza dijagnozaN=new Dijagnoza();
	        dijagnozaN.setNaziv(dijagnoza.getNaziv());
	        dijagnozaN.setDodatno(dijagnoza.getDodatno());
	        dijagnozaN.setSifra(dijagnoza.getSifra());
	        if(dijagnoza.getNaziv()==null || dijagnoza.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewDijagnoza?error=Unesite naziv";
	        }
	        if (dijagnoza.getSifra() == null || dijagnoza.getSifra().trim().isEmpty()) {
	            result = "redirect:/addNewDijagnoza?error=Unesite sifru";
	        } else if (dijagnoza.getDodatno() == null || dijagnoza.getDodatno().trim().isEmpty()) {
	            result = "redirect:/addNewDijagnoza?error=Enter valid last name";
	        } 
	        if (dbDijagnoza == null) {
	            dijagnozaService.sacuvajDijagnozu(dijagnozaN);
	            result="redirect:/dijagnoze";
	        } else {
	            result = "redirect:/addNewDijagnoza?error=Dijagnoza vec postoji!";
	        }

	        return result;
	    }
	    
	    @PostMapping("/novaKlinika")
	    public String novaKlinika(@ModelAttribute KlinikaDTO klinika) {
	        String result = "redirect:/";
	        Klinika dbKlinika=klinikaService.findByNaziv(klinika.getNaziv());
	        Klinika klinikaN=new Klinika();
	        klinikaN.setNaziv(klinika.getNaziv());
	        klinikaN.setGrad(klinika.getGrad());
	        klinikaN.setDrzava(klinika.getDrzava());
	        klinikaN.setAdresa(klinika.getAdresa());
	        if(klinika.getNaziv()==null || klinika.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewKlinika?error=Unesite naziv";
	        }
	        if (dbKlinika == null) {
	            klinikaService.sacuvajKliniku(klinikaN);
	            result="redirect:/klinike";
	        } else {
	            result = "redirect:/addNewKlinika?error=Klinika vec postoji!";
	        }

	        return result;
	    }
	    
	    
	    @GetMapping("/zahteviRegistrovanje")
	    public ModelAndView zahtevi(HttpServletRequest request) {
	    	request.setAttribute("korisnici", korisnikService.pokaziSveZahteve());
			request.setAttribute("mode", "ALL_USERS");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("pregledZahteva");
	        return modelAndView;
	    }

	    @GetMapping("/sviIzBaze")
	    public ModelAndView svi(HttpServletRequest request) {
	    	request.setAttribute("korisnici", korisnikService.pokaziSvePacijente());
			request.setAttribute("mode", "ALL_USERS");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("sviIzBaze");
	        return modelAndView;
	    }
	    
	    @GetMapping("/klinike")
	    public ModelAndView klinike(HttpServletRequest request) {
	    	request.setAttribute("klinike", klinikaService.pokaziSveKlinike());
			request.setAttribute("mode", "ALL_KLINIKE");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("klinike");
	        return modelAndView;
	    }
	    
	    @GetMapping("/pregledSvihAdmina")
		public ModelAndView pokaziAdmineKC(HttpServletRequest request) {
			request.setAttribute("korisnici", korisnikService.pokaziAdmine());
			request.setAttribute("mode", "ALL_ADMINI");
			ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("adminiKC");
		    return modelAndView;
		
		}
	    
	    @GetMapping("/pregledSvihAdminaKlinike")
		public ModelAndView pokaziAdmineKlinike(HttpServletRequest request) {
			request.setAttribute("korisnici", korisnikService.pokaziAdmineKlinike());
			request.setAttribute("mode", "ALL_ADMINI_KLINIKE");
			ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("adminiKlinike");
		    return modelAndView;
		
		}
	    
	    @GetMapping("/lekovi")
	    public ModelAndView lekovi(HttpServletRequest request) {
	    	request.setAttribute("lekovi", lekService.showAll());
			request.setAttribute("mode", "ALL_LEKOVI");
	        ModelAndView modelAndView = new ModelAndView();
	        return modelAndView;
	    }

	    @GetMapping("/dijagnoze")
	    public ModelAndView dijagnoze(HttpServletRequest request) {
	    	request.setAttribute("dijagnoze", dijagnozaService.showAll());
			request.setAttribute("mode", "ALL_DIJAGNOZE");
	        ModelAndView modelAndView = new ModelAndView();
	        return modelAndView;
	    }
	    
	    @GetMapping("/adminKlinike")
	    public ModelAndView adminiKlinike(HttpServletRequest request) {
	    	request.setAttribute("adminiKlinike", korisnikService.pokaziAdmineKlinike());
	    	System.out.println("atribut klinikea");
			request.setAttribute("mode", "ALL_ADMINI_KLINIKE");
			System.out.println("mode klinikea");
	        ModelAndView modelAndView = new ModelAndView();
	        System.out.println("modelbidjbkjdf");
	        return modelAndView;
	    }
	    
	    @ResponseBody
	    @PostMapping("/saveLek")
	    public Response update(@RequestBody LekDTO lek) {
	        Lek dbLek = lekService.findLekById(lek.getId());
	        dbLek.setNaziv(lek.getNaziv()); 
	        dbLek.setDodatno(lek.getDodatno());
	        lekService.sacuvajLek(dbLek);
	        return new Response(302, AppConstant.SUCCESS, "redirect:/lekovi");
	    }
	    
	    @GetMapping("/delete/{lekId}")
	    public String delete(@PathVariable Long lekId) {
	        lekService.obrisiLek(lekId); 
	        return "redirect:/lekovi";
	    }
	    
	    @ResponseBody
	    @PostMapping("/saveDijagnoza")
	    public Response updateDijagnoza(@RequestBody Dijagnoza dijagnoza) {
	        Dijagnoza dbDijagnoza = dijagnozaService.findDijagnozaById(dijagnoza.getId());
	        dbDijagnoza.setNaziv(dijagnoza.getNaziv()); 
	        dbDijagnoza.setDodatno(dijagnoza.getDodatno());
	        dijagnozaService.sacuvajDijagnozu(dbDijagnoza); 
	        return new Response(302, AppConstant.SUCCESS, "redirect:/lekovi");
	    }
	    
	    @GetMapping("/deleteDijagnoza/{dijagnozaId}")
	    public String deleteDijagnoza(@PathVariable Long dijagnozaId) {
	        dijagnozaService.obrisiDijagnozu(dijagnozaId);  
	        return "redirect:/dijagnoze";
	    }
	    
	    @GetMapping("/disable/{korisnikId}")
	    public ModelAndView disable(@PathVariable Long korisnikId,HttpServletRequest request) {
	        Korisnik k=korisnikService.findOne(korisnikId);
	        k.setIsActive(true);
	        k.setFirst_Login(false);
	        korisnikService.saveMogKorisnika(k);
	        
	      /*  try {
				emailService.sendNotificaitionOdbijenaRegistracija(k);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return "redirect:/zahteviRegistrovanje";*/
	        request.setAttribute("korisnik", korisnikService.findOne(korisnikId));
			request.setAttribute("mode", "ODBIJANJE");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("razlogOdbijanja");
	        return modelAndView;
	    }
	    
	  
	    
	    
	    @GetMapping("/reject/{korisnikId}")
	    public String reject(@PathVariable Long korisnikId) {
	        Korisnik k=korisnikService.findOne(korisnikId);
	        k.setIsActive(true);
	        k.setFirst_Login(false);
	        korisnikService.saveMogKorisnika(k);
	        
	        try {
				emailService.sendNotificaitionOdbijenaRegistracija(k);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return "redirect:/zahteviRegistrovanje";
	    }
	    
	    @GetMapping("/enable/{korisnikId}")
	    public String enable(@PathVariable Long korisnikId) {
	        Korisnik k=korisnikService.findOne(korisnikId);
	        k.setIsActive(true);
	        k.setFirst_Login(true);
	        korisnikService.saveMogKorisnika(k);
	        
	        try {
				emailService.sendNotificaitionOdobrenaRegistracija(k);
			}catch( Exception e ){
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}
	        
	        return "redirect:/zahteviRegistrovanje";
	    }
	    
	    
	  /*  @ResponseBody
	    @PostMapping("/save")
	    public Response update(@RequestBody Korisnik user) {
	        Korisnik dbUser = userService.findById(user.getId());
	        dbUser.setFirstName(user.getFirstName());
	        dbUser.setLastName(user.getLastName());
	        userService.saveUser(dbUser);
	        return new Response(302, AppConstant.SUCCESS, "/");
	    }*/



	/*    @PostMapping("/registerAK")
	    public String registerAK(@ModelAttribute Korisnik user) {
	        String result = "redirect:/";
	        Korisnik dbUser = userService.findUserByEmail(user.getEmail());
	        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid fist name";
	        } else if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid last name";
	        } else if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid email";
	        } else if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
	            result = "redirect:/addNewUser?error=Enter valid password";
	        } else if (StringUtils.isEmpty(user.getRoleName())) {
	            result = "redirect:/addNewUser?error=Select a valid Role";
	        }
	        if (dbUser == null) {
	            userService.saveUser(user);
	        } else {
	            result = "redirect:/addNewUser?error=User Already Exists!";
	        }

	        return result;
	    }



	    @GetMapping("/delete/{userId}")
	    public String delete(@PathVariable Long userId) {
	        korisnikService.deleteMyUser(userId);
	        return "redirect:/";
	    }



	/*    @ResponseBody
	    @GetMapping("/removeAll")
	    public Boolean removeAll() {
	        return korisnikService.removeAll();
	    }*/



	    @GetMapping("/403")
	    public ModelAndView accessDenied() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("403");
	        return modelAndView;
	    }



	    @GetMapping("/error")
	    public ModelAndView error() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("error");
	        return modelAndView;
	    }
	    

		@PostMapping("/editpassword")
		public String putEditPassword(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,HttpServletRequest request) {
		
			request.setAttribute("korisnik", korisnikService.findOne(id));
			Korisnik korisnik=korisnikService.findOne(id);
			//Korisnik k=new Korisnik();
			Long Idx=korisnikd.getId();
			System.out.println("Pokupljen id iz fronta "+korisnikd.getId());
			korisnik.setPassword(korisnikd.getPassword());
			korisnik.setFirst_Login(false);
			korisnikService.saveMogKorisnika(korisnik);
			System.out.println(korisnik.getPassword());
				//map.put("logged", korisnik);
			
			return "admin";
		}
	    
		@PostMapping("/sacuvajNovaLozinka") // korisnik povezan sa valuom iz js
		public String UpdateKorisnik2(@RequestParam Long id,@ModelAttribute KorisnikDTO korisnikd, BindingResult bindingResult,
				HttpServletRequest request) {
		
			Korisnik izBaze=korisnikService.findOne(id);
			
			Korisnik k = new Korisnik();
			Long Idx = korisnikd.getId();
			k.setPassword(korisnikd.getPassword());
			korisnikService.saveMogKorisnika(k);

			try {
				emailService.sendNotificaitionSync(k);
			} catch (Exception e) {
				logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			}

			return "uspesnaIzmenaInfo";

		}

		 @PostMapping("/razlogOdbijanja/{korisnikId}")
		    public String mejlOdbijanja(@PathVariable Long korisnikId,
					HttpServletRequest request) {
		        Korisnik k=korisnikService.findOne(korisnikId);
		       /* k.setId(korisnikd.getId());
		        k.setIme(korisnikd.getIme());
		        k.setPrezime(korisnikd.getPrezime());
		        k.setAdresa(korisnikd.getAdresa());
		        k.setDrzava(korisnikd.getDrzava());
		        k.setEmail(korisnikd.getEmail());
		        k.setGrad(korisnikd.getGrad());
		        k.setJedBrOsig(korisnikd.getJedBrOsig());
		        k.setUsername(korisnikd.getUsername());*/
		        String s=request.getParameter("razlog");
		       // String ss=request.getParameter("mail");
		      ///  System.out.println(ss);
		        
		        try {
					emailService.sendNotificaitionRazlogOdbijanja(k,s);
				}catch( Exception e ){
					logger.info("Greska prilikom slanja emaila: " + e.getMessage());
				}
		        
		        return "redirect:/zahteviRegistrovanje";
		        
		    }
	
}

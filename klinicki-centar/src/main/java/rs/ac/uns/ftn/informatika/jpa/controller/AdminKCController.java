package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.dto.DijagnozaDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.LekDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.Response;
import rs.ac.uns.ftn.informatika.jpa.model.Dijagnoza;
import rs.ac.uns.ftn.informatika.jpa.model.Lek;
import rs.ac.uns.ftn.informatika.jpa.service.DijagnozaServiceImpl;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;
import rs.uns.ac.ftn.informatika.jpa.constatns.AppConstant;

@Controller
public class AdminKCController {
	
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
	    public ModelAndView addNewAdminKlinike() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-admin-kc");
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
	        if(lek.getNaziv()==null || lek.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewLek?error=Unesite naziv";
	        }
	        if (lek.getSifra() == null || lek.getSifra().trim().isEmpty()) {
	            result = "redirect:/addNewLek?error=Unesite sifru";
	        } else if (lek.getDodatno() == null || lek.getDodatno().trim().isEmpty()) {
	            result = "redirect:/addNewLek?error=Enter valid last name";
	        } 
	        if (dbLek == null) {
	            lekService.sacuvajLek(dbLek);
	            result="redirect:/lekovi";
	        } else {
	            result = "redirect:/addNewLek?error=Lek vec postoji!";
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
	        if(dijagnoza.getNaziv()==null || dijagnoza.getNaziv().trim().isEmpty()) {
	        	result = "redirect:/addNewDijagnoza?error=Unesite naziv";
	        }
	        if (dijagnoza.getSifra() == null || dijagnoza.getSifra().trim().isEmpty()) {
	            result = "redirect:/addNewDijagnoza?error=Unesite sifru";
	        } else if (dijagnoza.getDodatno() == null || dijagnoza.getDodatno().trim().isEmpty()) {
	            result = "redirect:/addNewDijagnoza?error=Enter valid last name";
	        } 
	        if (dbDijagnoza == null) {
	            dijagnozaService.sacuvajDijagnozu(dbDijagnoza);
	            result="redirect:/dijagnoze";
	        } else {
	            result = "redirect:/addNewDijagnoza?error=Dijagnoza vec postoji!";
	        }

	        return result;
	    }
	    
	    
	    @GetMapping("/zahteviRegistrovanje")
	    public ModelAndView zahtevi(HttpServletRequest request) {
	    	request.setAttribute("korisnici", korisnikService.pokaziSveKorisnike());
			request.setAttribute("mode", "ALL_USERS");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("pregledZahteva");
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
		public ModelAndView pokaziPacijente(HttpServletRequest request) {
			request.setAttribute("korisnici", korisnikService.pokaziAdmine());
			request.setAttribute("mode", "ALL_ADMINI");
			ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("adminiKC");
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
	    
	
}

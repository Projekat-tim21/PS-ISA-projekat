package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.repository.DijagnozaRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.KlinikaRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.KorisnikRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.LekRepository;
import rs.ac.uns.ftn.informatika.jpa.service.DijagnozaService;
import rs.ac.uns.ftn.informatika.jpa.service.KlinikaService;
import rs.ac.uns.ftn.informatika.jpa.service.KorisnikService;
import rs.ac.uns.ftn.informatika.jpa.service.LekServiceImpl;

@Controller
public class AdminController {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	 @Autowired
	    private KorisnikService korisnikService;
	 
	 @Autowired
	 private KlinikaRepository klinikaRepository;
	 
	 @Autowired
	 private KlinikaService klinikaService;
	 
	 @Autowired
	 private LekRepository lekRepository;
	 
	 @Autowired
	 private LekServiceImpl lekService;
	 
	 @Autowired
	 private DijagnozaRepository dijagnozaRepository;
	 
	 @Autowired
	 private DijagnozaService dijagnozaService;

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



	    @GetMapping("/addNewAdminKlinike")
	    public ModelAndView addNewAdminKlinike() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-admin-klinike");
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

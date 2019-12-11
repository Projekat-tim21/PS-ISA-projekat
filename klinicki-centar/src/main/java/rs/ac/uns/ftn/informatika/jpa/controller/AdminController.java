package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import rs.ac.uns.ftn.informatika.jpa.repository.AdminRepository;
import rs.ac.uns.ftn.informatika.jpa.service.AdminService;
import rs.ac.uns.ftn.informatika.jpa.service.PregledService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	

	
	@Autowired
	private AdminRepository adminRepo;
	
	/*@RequestMapping("/zakazivanjePregleda/odobreno")
	public String zakaziPregled(@ModelAttribute PregledDTO pregled, HttpServletRequest request) {

		Pregled p = pregledSer.findByVremeDatum(pregled.getDatum(), pregled.getVreme());
		// if(!k.getRoleName().equals(Role.PACIJENT.name())) {

		Pregled p2 = new Pregled();
		//k = korisnikServis.findByUsernameAndPassword(korisnik.getUsername(), korisnik.getPassword());

		if (pregledSer.findByVremeDatum(pregled.getDatum(), pregled.getVreme()) != null) {
			request.setAttribute("message", "Uspesno ste zakazali pregled!");
			String datum = request.getParameter("datum");
			
			HttpSession session = request.getSession();
			session.setAttribute("datum", datum);
		}
		
		return "zakazivanjePregleda";
	}*/
	
	

/*	@RequestMapping("/zakazivanjePregleda")
	public void zakaziPregled(@ModelAttribute PregledDTO pregled, HttpServletRequest request) {
		
		Pregled p = pregledSer.findByDate(pregled.getDatum());
		
		
	}*/


/*	
	 @Autowired
	    private KorisnikService userService;

	    @Value("${max.result.per.page}")
	    private int maxResults;

	    @Value("${max.card.display.on.pagination.tray}")
	    private int maxPaginationTraySize;



	    @GetMapping("/")
	    public ModelAndView home(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
	                             @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
	                             HttpServletRequest request, HttpServletResponse response) {

	        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
	                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	        List<String> list = new ArrayList<>();
	        authorities.forEach(e -> {
	            list.add(e.getAuthority());
	        });

	        ModelAndView modelAndView = new ModelAndView();
	        if (list.contains(Role.ADMIN.name())) {
	            modelAndView.setViewName("home");
	            Page<Korisnik> allUsers = userService.listUsers(PageRequest.of(page, size, Sort.by("firstName")));
	            modelAndView.addObject("allUsers", allUsers);
	            modelAndView.addObject("maxTraySize", size);
	            modelAndView.addObject("currentPage", page);
	        } else {
	            modelAndView.setViewName("user-home");
	            Korisnik user = userService.findByUsername(request.getUserPrincipal().getName());
	            modelAndView.addObject("currentUser", user);
	        }

	        return modelAndView;
	    }



	    @GetMapping("/searchBox")
	    public ModelAndView searchByTerm(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
	                                     @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
	                                     @RequestParam(value = "searchTerm", required = false) String searchTerm) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("home");
	        Page<Korisnik> allUsers = userService.searchByTerm(searchTerm.trim(), PageRequest.of(page, size, Sort.by("firstName")));
	        modelAndView.addObject("allUsers", allUsers);
	        modelAndView.addObject("maxTraySize", size);
	        modelAndView.addObject("currentPage", page);
	        return modelAndView;
	    }



	    @GetMapping("/search")
	    public ModelAndView search() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("search");
	        return modelAndView;
	    }



	    @PostMapping("/searchSubmit")
	    public ModelAndView searchSubmit(@ModelAttribute SearchDTO searchDto) {
	        List<Korisnik> result = userService.searchBy(searchDto.getSearchKeyword(), searchDto.getCriteria());
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("search");
	        modelAndView.addObject("result", result);
	        return modelAndView;
	    }



	    @GetMapping("/addNewUser")
	    public ModelAndView addNewUser() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("create-user");
	        return modelAndView;
	    }



	    @ResponseBody
	    @PostMapping("/save")
	    public Response update(@RequestBody User user) {
	        Korisnik dbUser = userService.findById(user.getId());
	        dbUser.setFirstName(user.getFirstName());
	        dbUser.setLastName(user.getLastName());
	        userService.saveUser(dbUser);
	        return new Response(302, AppConstant.SUCCESS, "/");
	    }



	    @PostMapping("/registerAK")
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
	        userService.removeById(userId);
	        return "redirect:/";
	    }



	    @ResponseBody
	    @GetMapping("/removeAll")
	    public Boolean removeAll() {
	        return userService.removeAll();
	    }



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
*/
	
	
	
}

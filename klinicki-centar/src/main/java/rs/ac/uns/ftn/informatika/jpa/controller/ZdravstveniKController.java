package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.ac.uns.ftn.informatika.jpa.service.ZKartonService;

@Controller
public class ZdravstveniKController {

	@Autowired
	private ZKartonService zdravKService;
	/*
	@RequestMapping("/kartonZ")
	public String prikazZKartona( HttpServletRequest request) {
		request.setAttribute("zkartoni", zdravKService.pokaziZdravKarton());
		request.setAttribute("mode", "MODE_ZKARTON");
		return "zdravstveniKartonPacijenta";
	}
	

*/
	
}

package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.ZKarton;
import rs.ac.uns.ftn.informatika.jpa.repository.ZKartonRepository;

@Service
@Transactional
public class ZKartonService {

	private final ZKartonRepository zkrepo;
	
	public ZKartonService(ZKartonRepository zkrepo) {
		this.zkrepo = zkrepo;
	}
	
	public List<ZKarton> pokaziZdravKarton() {
		// TODO Auto-generated method stub
		List<ZKarton> zkartoni = new ArrayList<ZKarton>();
		for (ZKarton zkarton : zkrepo.findAll()) {
			zkartoni.add(zkarton);
		}
		return zkartoni;
	}


}

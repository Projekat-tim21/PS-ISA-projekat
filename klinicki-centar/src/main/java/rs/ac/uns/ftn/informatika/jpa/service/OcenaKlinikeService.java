package rs.ac.uns.ftn.informatika.jpa.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.OcenaKlinike;
import rs.ac.uns.ftn.informatika.jpa.repository.OcenaKlinikeRepository;

@Service
@Transactional
public class OcenaKlinikeService {

	private final OcenaKlinikeRepository okRepo;

	public OcenaKlinikeService(OcenaKlinikeRepository okRepo) {
				this.okRepo=okRepo;
			}

	public void saveOcenaKlinike(OcenaKlinike ocenaklin) {
		okRepo.save(ocenaklin);
	}

	public OcenaKlinike findOne(Long id) {
		return okRepo.findById(id).orElseGet(null);
	}

	public void setOcenaKlinikeUNjegovojKlasi(Long k, double ocenapregleda) {
		// TODO Auto-generated method stub

	}

}

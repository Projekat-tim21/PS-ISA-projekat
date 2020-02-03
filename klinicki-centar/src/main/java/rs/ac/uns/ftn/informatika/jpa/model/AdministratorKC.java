package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;


@Entity
public class AdministratorKC extends Korisnik{
	
	@Column(name = "firstLogin", nullable = false)
	private boolean firstLogin;
	
	@Column(name = "predefinisani", nullable = false)
	private boolean predefinisani;
	

	@Version
	private Long version;
	
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public AdministratorKC() {
		
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public boolean isPredefinisani() {
		return predefinisani;
	}

	public void setPredefinisani(boolean predefinisani) {
		this.predefinisani = predefinisani;
	}
	
}

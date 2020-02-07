package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="klinika")
public class Klinika {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "naziv", nullable = false)
		String naziv;

		@Column(name = "grad", nullable = false)
		String grad;
		
		@Column(name = "drzava", nullable = false)
		private String drzava;

		@Column(name = "ocena", nullable = true)
		private double ocena;
	
		@Column(name = "adresa", nullable = false)
		private String adresa;
		
		@Column(name = "tip", nullable = false)
		private String tip;
		/*
		@Version
		private Long version;
*/

		@OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private Set<Korisnik> admini = new HashSet<Korisnik>();
		
		public Klinika() {
			super();
		}

		
		
		public Klinika(Long id, String naziv, String grad, String drzava, double ocena, String adresa,
				String tip) {
			super();
			this.id = id;
			this.naziv = naziv;
			this.grad = grad;
			this.drzava = drzava;
			this.ocena = ocena;
			this.adresa = adresa;
			this.tip = tip;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNaziv() {
			return naziv;
		}

		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}


		/*
		public Long getVersion() {
			return version;
		}


		public void setVersion(Long version) {
			this.version = version;
		}

*/

		public String getGrad() {
			return grad;
		}

		public void setGrad(String grad) {
			this.grad = grad;
		}

		public String getDrzava() {
			return drzava;
		}

		public void setDrzava(String drzava) {
			this.drzava = drzava;
		}

		public double getOcena() {
			return ocena;
		}

		public void setOcena(double ocena) {
			this.ocena = ocena;
		}

		public String getAdresa() {
			return adresa;
		}

		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}

		public String getTip() {
			return tip;
		}

		public void setTip(String tip) {
			this.tip = tip;
		}


		public Set<Korisnik> getAdmini() {
			return admini;
		}


		public void setAdmini(Set<Korisnik> admini) {
			this.admini = admini;
		}
		
		@Override
		public int hashCode() {
			return Objects.hashCode(id);
		}


		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Klinika s = (Klinika) o;
			if (s.id == null || id == null) {
				return false;
			}
			return Objects.equals(id, s.id);
		}
		
		
		
	
	
	
}

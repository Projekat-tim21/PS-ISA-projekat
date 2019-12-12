package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
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
		private int ocena;
	
		@Column(name = "adresa", nullable = false)
		private String adresa;
		
		@Column(name = "cena", nullable = false)
		private int cena;

		@OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private Set<Korisnik> admini = new HashSet<Korisnik>();
		
		public Klinika() {
			super();
		}

		
		public Klinika(Long id, String naziv, String grad, String drzava, int ocena, String adresa,
				int cena) {
			super();
			this.id = id;
			this.naziv = naziv;
			this.grad = grad;
			this.drzava = drzava;
			this.ocena = ocena;
			this.adresa = adresa;
			this.cena = cena;
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

		public int getOcena() {
			return ocena;
		}

		public void setOcena(int ocena) {
			this.ocena = ocena;
		}

		public String getAdresa() {
			return adresa;
		}

		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}

		public int getCena() {
			return cena;
		}

		public void setCena(int cena) {
			this.cena = cena;
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

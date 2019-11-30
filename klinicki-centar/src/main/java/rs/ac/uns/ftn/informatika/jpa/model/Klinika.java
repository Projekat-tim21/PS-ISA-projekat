package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="klinika")
public class Klinika {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "naziv", unique = true, nullable = false)
		String naziv;

		@Column(name = "grad", unique = true, nullable = false)
		String grad;
		
		@Column(name = "drzava", nullable = false)
		private String drzava;

		@Column(name = "prosecna_ocena", nullable = false)
		private int prosecna_ocena;
	
		@Column(name = "adresa", nullable = false)
		private String adresa;
		
		@Column(name = "cena", nullable = false)
		private int cena;

		
		public Klinika() {
			super();
		}

		
		
		public Klinika(Long id, String naziv, String grad, String drzava, int prosecnaOcena, String adresa,
				int cena) {
			super();
			this.id = id;
			this.naziv = naziv;
			this.grad = grad;
			this.drzava = drzava;
			this.prosecna_ocena = prosecnaOcena;
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

		public int getProsecnaOcena() {
			return prosecna_ocena;
		}

		public void setProsecnaOcena(int prosecna_ocena) {
			this.prosecna_ocena = prosecna_ocena;
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
		
		
		
	
	
	
}

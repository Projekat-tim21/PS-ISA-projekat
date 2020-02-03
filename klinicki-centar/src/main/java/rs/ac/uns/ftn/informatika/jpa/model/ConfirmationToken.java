package rs.ac.uns.ftn.informatika.jpa.model;



import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Korisnik.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Korisnik user;
    

	@Version
	private Long version;
	
	

    public long getTokenid() {
		return tokenid;
	}



	public void setTokenid(long tokenid) {
		this.tokenid = tokenid;
	}



	public String getConfirmationToken() {
		return confirmationToken;
	}



	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Korisnik getUser() {
		return user;
	}



	public void setUser(Korisnik user) {
		this.user = user;
	}



	public Long getVersion() {
		return version;
	}



	public void setVersion(Long version) {
		this.version = version;
	}



	public ConfirmationToken(Korisnik user) {
        this.user = user;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

    // getters and setters
}
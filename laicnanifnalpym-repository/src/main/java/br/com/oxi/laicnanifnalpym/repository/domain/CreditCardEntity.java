package br.com.oxi.laicnanifnalpym.repository.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.oxi.laicnanifnalpym.utils.enums.FlagCard;
import br.com.oxi.laicnanifnalpym.utils.enums.Status;

/***
 * 
 * @author Ocean Cortez
 *
 */
@Entity
@Table(name = "credit_card")
public class CreditCardEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_credit_card")
	private Long id;
	
	@Column(name = "num_last_credit_card")
	@NotNull
	private Integer numberAgency;
		
	@NotNull
	@Column(name = "nam_credit_card")
	private String name;
	
	@Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "ind_flag_card")
	private FlagCard flagCard;
	
	@Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "ind_credit_card_status")
	private Status status;
	
    @Column(name = "dat_creation")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date creationDate;
    
    @Column(name = "dat_update")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date updateDate;
//	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "user_credit_card", joinColumns = @JoinColumn(name = "id_credit_card"), inverseJoinColumns = @JoinColumn(name = "id_user"))
//	private List<User> user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumberAgency() {
		return numberAgency;
	}

	public void setNumberAgency(Integer numberAgency) {
		this.numberAgency = numberAgency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

//	public List<User> getUser() {
//		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}

	public FlagCard getFlagCard() {
		return flagCard;
	}

	public void setFlagCard(FlagCard flagCard) {
		this.flagCard = flagCard;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", numberAgency=" + numberAgency + ", name=" + name + ", flagCard=" + flagCard
				+ ", status=" + status + ", creationDate=" + creationDate + ", updateDate=" + updateDate + "]";	//", user="	+ user + "]";
	}
	


}

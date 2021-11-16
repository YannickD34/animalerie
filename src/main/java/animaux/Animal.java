package animaux;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import animalerie.PetStore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="ANIMAL")
public abstract class Animal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="BIRTH", length=10, nullable=false, columnDefinition="DATE")
	private Date birth;
	
	@Column(name="COULEUR", length=10, nullable=false)
	private String couleur;
	
	@ManyToOne
	@JoinColumn(name="ID_PETSTORE")
	protected PetStore petStore;
	
	public Animal() {
	}

	public Animal(Date birth, String couleur, PetStore petStore) {
		super();
		this.birth = birth;
		this.couleur = couleur;
		this.petStore = petStore;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", birth=" + birth + ", couleur=" + couleur + ", petStore=" + petStore + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public PetStore getPetStore() {
		return petStore;
	}

	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}

}

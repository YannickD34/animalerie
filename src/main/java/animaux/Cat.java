package animaux;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import animalerie.PetStore;

@Entity(name = "CAT")
public class Cat extends Animal {
	
	@Column(name="CHIP_ID", length=10, nullable=false)
	private String chipId;
	
	public Cat() {
	}

	public Cat(Date birth, String couleur, PetStore petStore, String chipId) {
		super(birth, couleur, petStore);
		this.chipId = chipId;
	}

	public String getChipId() {
		return chipId;
	}

	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

}

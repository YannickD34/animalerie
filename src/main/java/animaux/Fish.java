package animaux;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import animalerie.PetStore;
import enumerations.FishLivEnv;

@Entity(name = "FISH")
public class Fish extends Animal {
	
	@Column(name="LIVING_ENV", length=12, nullable=false)
	@Enumerated(EnumType.STRING)
	private FishLivEnv livingEnv;
	
	public Fish() {
	}

	public Fish(Date birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
		super(birth, couleur, petStore);
		this.livingEnv = livingEnv;
	}

	public FishLivEnv getLivingEnv() {
		return livingEnv;
	}

	public void setLivingEnv(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}

}

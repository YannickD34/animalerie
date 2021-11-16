
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import animalerie.Adress;
import animalerie.PetStore;
import animalerie.Product;
import animaux.Animal;
import animaux.Cat;
import animaux.Fish;
import enumerations.FishLivEnv;
import enumerations.ProdType;

public class TestPetStore {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animalerie");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		// Insertion de 3 adresses en BDD
		Adress adr1 = new Adress();
		adr1.setCity("Montpellier");
		adr1.setNumber("1");
		adr1.setStreet("Rue Pierre Fabre");
		adr1.setZipCode("34000");
		em.persist(adr1);
		
		Adress adr2 = new Adress("2", "Boulevard Saint Quentin", "69000", "Lyon");
		em.persist(adr2);
		
		Adress adr3 = new Adress("3", "Avenue du Général de Gaulle", "75000", "Paris");
		em.persist(adr3);
		
		// Insertion de 3 animaleries en BDD
		PetStore animalerie1 = new PetStore();
		animalerie1.setName("La première animalerie");
		animalerie1.setManagerName("Yannick");
		animalerie1.setAddress(adr1);
		em.persist(animalerie1);
		
		PetStore animalerie2 = new PetStore("Deuxième animalerie", "Baptiste", adr2);
		em.persist(animalerie2);

		PetStore animalerie3 = new PetStore("L'ultime animalerie", "Jean", adr3);
		em.persist(animalerie3);
		
		// Insertion de 3 produits en BDD
		Product prod1 = new Product();
		prod1.setCode("AAA001");
		prod1.setLabel("Arbre à chat 001");
		prod1.setType(ProdType.ACCESSORY);
		prod1.setPrice(42);
		prod1.addPetStore(animalerie3);
		em.persist(prod1);
		
		Product prod2 = new Product("FFF004", "Food 4 Fish", ProdType.FOOD, 12);
		prod2.addPetStore(animalerie1);
		prod2.addPetStore(animalerie2);
		prod2.addPetStore(animalerie3);
		em.persist(prod2);
		
		Product prod3 = new Product("CCC012", "Cleaning product 12", ProdType.CLEANING, 25.5);
		em.persist(prod3);
		
		// Insertion des produits dans les animaleries
		animalerie1.addProduct(prod1);
		animalerie1.addProduct(prod2);
		em.persist(animalerie1);
		
		animalerie3.addProduct(prod2);
		em.persist(animalerie3);
		
		// Insertion de 3 poissons en BDD
		Fish pois1 = new Fish();
		pois1.setCouleur("rouge");
		pois1.setBirth(new Date(121, 1, 1));
		pois1.setLivingEnv(FishLivEnv.FRESH_WATER);
		pois1.setPetStore(animalerie1);
		em.persist(pois1);
		
		Fish pois2 = new Fish(new Date(121, 2, 2), "blanc", animalerie2, FishLivEnv.SEA_WATER);
		em.persist(pois2);
		
		Fish pois3 = new Fish(new Date(121, 9, 9), "noir", animalerie3, FishLivEnv.FRESH_WATER);
		em.persist(pois3);
		
		// Insertion de 3 chats en BDD
		Cat chat1 = new Cat();
		chat1.setCouleur("noir");
		chat1.setBirth(new Date(121, 1, 0));
		chat1.setChipId("ABC123");
		chat1.setPetStore(animalerie3);
		em.persist(chat1);
		
		Cat chat2 = new Cat(new Date(121, 10, 9), "blanc", animalerie2, "ZZZ999");
		em.persist(chat2);
		
		Cat chat3 = new Cat(new Date(121, 04, 19), "roux", animalerie3, "RTY456");
		em.persist(chat3);
		
		et.commit();
		
		// Réaliser une requête qui permet d’extraire tous les animaux d’une animalerie donnée (ici celle ayant 3 pour ID - L'ultime animalerie)
		Query extraire = em.createQuery("SELECT a FROM Animal a JOIN a.petStore p WHERE p.id = 3");
		List<Animal> animals = extraire.getResultList();
		
		for (Animal animal : animals) {
			System.out.println(animal);
		} 
		
		em.close();
		emf.close();

	}

}

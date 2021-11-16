package animalerie;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import enumerations.ProdType;

@Entity
@Table(name="PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="CODE", length=10, nullable=false)
	private String code;
	
	@Column(name="LABEL", length=50, nullable=false)
	private String label;
	
	@Column(name="TYPE", length=50, nullable=false)
	@Enumerated(EnumType.STRING)
	private ProdType type;
	
	@Column(name="PRICE", length=10, nullable=false)
	private double price;
	
	@ManyToMany(mappedBy="products")
	private List<PetStore> petStores = new ArrayList<>();
	
	public Product() {
	}

	public Product(String code, String label, ProdType type, double price) {
		super();
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
	}

	public Product(String code, String label, ProdType type, double price, List<PetStore> petStores) {
		super();
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
		this.petStores = petStores;
	}
	
	public void addPetStore(PetStore petStore) {
		petStores.add(petStore);
		petStore.addProduct(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProdType getType() {
		return type;
	}

	public void setType(ProdType type) {
		this.type = type;
	}

	public List<PetStore> getPetStores() {
		return petStores;
	}

	public void setPetStores(List<PetStore> petStores) {
		this.petStores = petStores;
	}
	
}

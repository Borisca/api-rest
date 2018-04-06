package fr.hardis.formation.poe.fpgapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

	@NotEmpty(message="Le nom de peut pas etre vide")
    private String name;

	@NotEmpty(message="Le prenom de peut pas etre vide")
	private String firstName;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String email;
    

    @Min(value=6,message="le mot de passe doit faire au moins 6 caracteres")
    private String motDePasse;
    
    
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public long getId() {
 		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }



	
	@Override
	public String toString() {
		return "User [name=" + name + ", firstName=" + firstName + ", id=" + id + ", email=" + email + ", motDePasse="
				+ motDePasse + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    
}
package fr.hardis.formation.poe.fpgapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
public class User {

	@NotEmpty
    private String name;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private int age;
    
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
}
package medical;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import utility.Diagnosis;

@Entity
@Table(name="Medicine")
public class Medicine {
	
	private String name;
	private String description;
	
	private int ID;
	private Set<Diagnosis> diagnosises;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Set<Diagnosis> getDiagnosises() {
		return diagnosises;
	}
	public void setDiagnosises(Set<Diagnosis> diagnosises) {
		this.diagnosises = diagnosises;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Medicine " + name;
	}

}

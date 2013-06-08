package eu.people1.example.domain;

import java.util.Date;

import eu.people1.frango.annotations.XEntity;
import eu.people1.frango.annotations.XField;
import eu.people1.frango.annotations.ParseType;

@XEntity(parseType = ParseType.ROW)
public class Student {

	@XField(position = 2)
	private Long roleNumber;
	
	@XField(position = 3)
	private String name;
	
	@XField(position = 4)
	private Date dateOfBirth;
	
	@XField(position = 5)
	private String fatherName;
	
	@XField(position = 6)
	private String motherName;
	
	@XField(position = 7)
	private String address;
	
	@XField(position = 8)
	private Double totalScore;

	public Long getRoleNumber() {
    	return roleNumber;
    }

	public String getName() {
    	return name;
    }

	public Date getDateOfBirth() {
    	return dateOfBirth;
    }

	public String getFatherName() {
    	return fatherName;
    }

	public String getMotherName() {
    	return motherName;
    }

	public String getAddress() {
    	return address;
    }

	public Double getTotalScore() {
    	return totalScore;
    }

	
}

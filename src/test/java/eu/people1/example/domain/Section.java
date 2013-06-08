package eu.people1.example.domain;

import java.util.List;

import eu.people1.frango.annotations.MappedExcelObject;
import eu.people1.frango.annotations.XEntity;
import eu.people1.frango.annotations.XField;
import eu.people1.frango.annotations.ParseType;


@XEntity(parseType = ParseType.COLUMN)
public class Section {

	@XField(position = 2)
	private String year;

	@XField(position = 3)
	private String section;
	
	@MappedExcelObject
	private List<Student> students;

	public List<Student> getStudents() {
    	return students;
    }

	public String getYear() {
		return year;
	}

	public String getSection() {
		return section;
	}
}

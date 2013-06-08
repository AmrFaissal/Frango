package eu.people1.frango;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test; 

import eu.people1.example.domain.Section;
import eu.people1.frango.exception.FileParsingException;

public class SheetParserTest {

	private SheetParser parser;
	private Sheet sheet;
	private String sheetName = "Sheet1";
	private InputStream inputStream;

	@Before
	public void setUp() throws IOException {
		parser = new SheetParser();
		inputStream = getClass().getClassLoader().getResourceAsStream("Student Profile.xls");
		sheet = new HSSFWorkbook(inputStream).getSheet(sheetName);
	}

	@After
	public void tearDown() throws IOException {
		inputStream.close();
	}

	@Test
	public void shouldCreateEntityBasedOnAnnotation() throws FileParsingException {
		List<Section> entityList = parser.createEntity(sheet, sheetName,2, 2, Section.class);
		assertEquals(1, entityList.size());
		Section section = entityList.get(0);
		assertEquals("IV", section.getYear());
		assertEquals("B", section.getSection());
		assertEquals(3, section.getStudents().size());
		
		assertEquals(2001L, section.getStudents().get(0).getRoleNumber().longValue());
		assertEquals("Adam", section.getStudents().get(0).getName());
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
		assertEquals("01/01/2002", simpleDateFormat.format(section.getStudents().get(0).getDateOfBirth()));
		assertEquals("A", section.getStudents().get(0).getFatherName());
		assertEquals("D", section.getStudents().get(0).getMotherName());
		assertEquals("XYZ", section.getStudents().get(0).getAddress());
		assertNull(section.getStudents().get(0).getTotalScore());
	}
}

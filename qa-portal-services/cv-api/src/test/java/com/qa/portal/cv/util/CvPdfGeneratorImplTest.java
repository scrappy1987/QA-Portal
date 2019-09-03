package com.qa.portal.cv.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.portal.cv.domain.CvVersion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@RunWith(MockitoJUnitRunner.class)
public class CvPdfGeneratorImplTest {

	@Test
	public void test() {
		CvPdfGeneratorImpl pdfGen = new CvPdfGeneratorImpl();
		pdfGen.loadfonts();
		try {
		byte[] pdfBytes = pdfGen.generateCv(getCvVersion("cv-version.json")); 
		// Create File from byte[] and save to file system /output/filename.pdf
		OutputStream os = new FileOutputStream("test.pdf");
		os.write(pdfBytes);
		os.close();
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private CvVersion getCvVersion(String cv) throws IOException {
		Resource res =  new ClassPathResource(cv);
		ObjectMapper om = new ObjectMapper();
		CvVersion cvVersion = om.readValue(res.getInputStream(), CvVersion.class);
		return cvVersion;
	}
}


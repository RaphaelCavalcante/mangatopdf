package com.home.rhounsell.mangatopdf.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.home.rhounsell.mangatopdf.GenerateMangaPDF;

public class GenerateMangaPDFTest {
	private GenerateMangaPDF pdfManga;
	private static final String FILE_NAME = "test_artifact/MANGA_PDF_TEST_01.pdf";
	private static final String MANGA_PATH= "test_artifact/MangaTitle";
	private static final String TITLE= "MANGA_01";
	@Before
	public void init(){
		pdfManga=new GenerateMangaPDF(MANGA_PATH, TITLE);
	}
	@Test
	public void test() {
		pdfManga.createPdf(FILE_NAME);
		File fp= new File(FILE_NAME);
		assertTrue(fp.exists());
		
	}

}

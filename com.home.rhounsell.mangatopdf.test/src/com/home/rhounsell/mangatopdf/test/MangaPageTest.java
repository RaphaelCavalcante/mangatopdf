package com.home.rhounsell.mangatopdf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.home.rhounsell.mangatopdf.MangaPage;
import com.home.rhounsell.mangatopdf.Orientation;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

public class MangaPageTest {
	private MangaPage verticalPage;
	private MangaPage horizontalPage;
	private File pageHorFile;
	private File pageVertFile;
	private static final String ARTIFACT_IMAGEVER_PATH="test_artifact/imageVert01.jpg";
	private static final String ARTIFACT_IMAGEHOR_PATH="test_artifact/imageHor01.jpg";
	@Before
	public void init() throws BadElementException, MalformedURLException, IOException{
		pageVertFile= new File(ARTIFACT_IMAGEVER_PATH);
		pageHorFile= new File(ARTIFACT_IMAGEHOR_PATH);
		verticalPage=new MangaPage(pageVertFile);
		horizontalPage=new MangaPage(pageHorFile);
	}
	@Test
	public void getMangaPageTest() throws BadElementException, MalformedURLException, IOException {
		Image img=horizontalPage.getMangaPageImage();
		assertNotNull(img);
	}
	@Test
	public void getVerticalOrientationTest() throws BadElementException, MalformedURLException, IOException{
		assertEquals(verticalPage.getOrienation(), Orientation.VERTICAL);
	}
	@Test
	public void getHorizontalOrientationTest() throws BadElementException, MalformedURLException, IOException{
		assertEquals(horizontalPage.getOrienation(), Orientation.HORIZONTAL);
	}

}

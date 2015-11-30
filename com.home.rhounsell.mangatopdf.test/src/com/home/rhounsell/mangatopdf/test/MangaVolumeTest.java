package com.home.rhounsell.mangatopdf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.home.rhounsell.mangatopdf.MangaVolume;

public class MangaVolumeTest {
	private static final String VOLUME_PATH="test_artifact/MangaVolume";
	private static final int MANGA_CHAPTERS = 4;
	private MangaVolume vol;
	@Before
	public void init(){
		vol=new MangaVolume(new File(VOLUME_PATH), 1);	
	}
	@Test
	public void mangaVolumeLoadTest() {
		assertNotNull(vol);
		assertFalse(vol.getVolumeChapters().isEmpty());
	}
	@Test
	public void mangaChaptersQuantityTest(){
		assertEquals(MANGA_CHAPTERS, vol.getVolumeChapters().size());
	}
	@Test
	public void mangaVolumeNumberTest(){
		assertEquals(1, vol.getVolNumber());
	}
	

}

package com.home.rhounsell.mangatopdf.test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.home.rhounsell.mangatopdf.Manga;
import com.home.rhounsell.mangatopdf.MangaVolume;

public class MangaTest {
	private Manga manga;
	private static final String MANGA_PATH="test_artifact/MangaTitle";
	@Before
	public void init(){
		manga = new Manga("Manga01", MANGA_PATH);
	}
	@Test
	public void loadedMangaTest() {
		assertEquals(1, manga.getMangaVolumes().size());
	}
	@SuppressWarnings("rawtypes")
	@Test
	public void getLoadedManga(){
		Iterator it=manga.getMangaVolumes().iterator();
		while(it.hasNext()){
			System.out.println(((MangaVolume)it.next()).getVolumeChapters().size());
		}
	}
}

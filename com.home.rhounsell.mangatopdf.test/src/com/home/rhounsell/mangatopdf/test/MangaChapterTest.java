package com.home.rhounsell.mangatopdf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.home.rhounsell.mangatopdf.MangaChapter;
import com.home.rhounsell.mangatopdf.MangaPage;

public class MangaChapterTest {
	private static final int PAGES = 47;
	public MangaChapter chapter;
	public static String PATH_TO_CHAPTER="test_artifact/MangaChapter";
	@Before
	public void init(){
		chapter=new MangaChapter(new File(PATH_TO_CHAPTER), 1);
	}
	@Test
	public void mangaPagesTest() {
		List<MangaPage> pages=chapter.getChapterPages();
		assertFalse(pages.isEmpty());
	}
	@Test
	public void mangaPagesQuantityTest(){
		List<MangaPage> pages=chapter.getChapterPages();
		assertEquals(PAGES, pages.size());
	}
}

package com.home.rhounsell.mangatopdf.interfaces;

import java.io.File;
import java.util.List;

import com.home.rhounsell.mangatopdf.MangaChapter;
import com.home.rhounsell.mangatopdf.MangaPage;

public interface IChapter {
	List <MangaPage> getChapterPages();
	List<MangaPage> compilePageFromChapter(MangaChapter chapter,List<MangaPage> pages);
	int getChapterNumber();
}

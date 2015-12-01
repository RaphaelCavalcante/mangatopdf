package com.home.rhounsell.mangatopdf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.home.rhounsell.mangatopdf.interfaces.IChapter;
import com.itextpdf.text.BadElementException;

public class MangaChapter extends MangaAbstract implements IChapter{
	private File chapterDirectory;
	private int chapterNumber;

	public MangaChapter(File path, int chapterNumber) {
		this.chapterDirectory = path;
		this.chapterNumber = chapterNumber;
	}

	@Override
	public int getChapterNumber() {
		return this.chapterNumber;
	}

	@Override
	public List <MangaPage> getChapterPages() {
		final List <MangaPage> mangaPages = new ArrayList<MangaPage>();
		
		File[] list = chapterDirectory.listFiles();
		for (int index = 0; index < list.length; index++) {
			try {
				if (list[index].getAbsolutePath().contains(".db")) {
					continue;
				} else {
					MangaPage page = new MangaPage(list[index]);
					page.setChapter(chapterNumber);
					page.setPageNumber(index);

					mangaPages.add(page);
				}
			} catch (BadElementException | IOException e) {
				e.printStackTrace();
			}
		}
		return mangaPages;
	}
	@Override
	public List<MangaPage> compilePageFromChapter(MangaChapter chapter,
			List<MangaPage> pages) {
		Iterator <MangaPage> it = chapter.getChapterPages().iterator();
		while (it.hasNext()) {
			pages.add(it.next());
		}
		return pages;
	}
}

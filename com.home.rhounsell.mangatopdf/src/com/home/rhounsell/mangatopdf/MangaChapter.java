package com.home.rhounsell.mangatopdf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.BadElementException;

public class MangaChapter extends MangaAbstract {
	private File chapterDirectory;
	private int chapterNumber;

	public MangaChapter(File path, int chapterNumber) {
		this.chapterDirectory = path;
		this.chapterNumber = chapterNumber;
	}

	public int getChapterNumber() {
		return this.chapterNumber;
	}

	public List<MangaPage> getChapterPages() {
		final List<MangaPage> pages;
		pages = new ArrayList<MangaPage>();
		File[] list = chapterDirectory.listFiles();
		for (int index = 0; index < list.length; index++) {
			try {
				if (list[index].getAbsolutePath().contains(".db")) {
					continue;
				} else {
					MangaPage page;
					page = new MangaPage(list[index]);
					page.setChapter(chapterNumber);
					page.setPageNumber(index);

					pages.add(page);
				}
			} catch (BadElementException | IOException e) {
				e.printStackTrace();
			}
		}
		return pages;
	}

	public List<MangaPage> compilePageFromChapter(MangaChapter chapter,
			List<MangaPage> pages) {
		@SuppressWarnings("rawtypes")
		Iterator it = chapter.getChapterPages().iterator();
		while (it.hasNext()) {
			pages.add(((MangaPage) it.next()));
		}
		return pages;
	}
}

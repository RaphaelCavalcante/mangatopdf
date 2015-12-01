package com.home.rhounsell.mangatopdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateMangaPDF {
	private Manga mangaFile;

	public GenerateMangaPDF(Manga mangaFile) {
		this.mangaFile = mangaFile;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public void createPdf(String fileName) {
		Document pdf = new Document();
		try {

			PdfWriter writer = PdfWriter.getInstance(pdf, new FileOutputStream(
					fileName));

			Iterator it = mangaFile.getMangaVolumes().iterator();

			List<MangaPage> pages = new ArrayList<MangaPage>();

			while (it.hasNext()) {
				List<MangaChapter> chaps = ((MangaVolume) it.next())
						.getVolumeChapters();
				pages.addAll(getChapterFiles(chaps));
			}

			pdf.open();
			for (MangaPage page : pages) {
				Image img = page.getMangaPageImage();
				img.scaleToFit(pdf.getPageSize().getWidth(), pdf.getPageSize()
						.getHeight());
				pdf.add(img);
				pdf.newPage();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		pdf.close();
	}

	@SuppressWarnings("rawtypes")
	private List<MangaPage> getChapterFiles(List<MangaChapter> chaps) {
		Iterator it = chaps.iterator();
		List<MangaPage> pages = new ArrayList<MangaPage>();
		while (it.hasNext()) {
			MangaChapter chapter = (MangaChapter) it.next();
			pages = ((MangaChapter) it.next()).compilePageFromChapter(chapter,
					pages);
		}
		return pages;
	}
}

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
	
	private String mangaPath;
	private String title;
	public GenerateMangaPDF(String mangaPath, String title){
		this.mangaPath= mangaPath;
		this.title = title;
	}
	@SuppressWarnings({ "unused", "rawtypes" })
	public void createPdf(String fileName){
		Document pdf = new Document();
		try {

			PdfWriter writer = PdfWriter.getInstance(pdf, new FileOutputStream(
					fileName));

			Manga manga = new Manga(title, mangaPath);

			Iterator it = manga.getMangaVolumes().iterator();
			List<MangaPage> pages = new ArrayList<MangaPage>();

			while (it.hasNext()) {
				List<MangaChapter> chaps = ((MangaVolume) it.next())
						.getVolumeChapters();
				pages.addAll(getChapsFiles(chaps));
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
	public List<MangaPage> getChapsFiles(List<MangaChapter> chaps){
		Iterator it= chaps.iterator();
		List <MangaPage> pages=new ArrayList<MangaPage>();
		while (it.hasNext()){
			MangaChapter chapter = (MangaChapter)it.next();
			pages=((MangaChapter)it.next()).compilePageFromChapter(chapter, pages);
		}
		return pages;
	}
}

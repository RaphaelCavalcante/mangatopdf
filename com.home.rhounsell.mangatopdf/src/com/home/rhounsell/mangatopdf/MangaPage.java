package com.home.rhounsell.mangatopdf;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

public class MangaPage {
	private static final int ALIGN_CENTER = 6;
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public Orientation getOrienation(){
		return this.orientation;
	}
	private int pageNumber;
	private int chapter;
	private int volume;
	private Image image;
	private Orientation orientation;
	
	public MangaPage(File mangaPageFile) throws BadElementException, MalformedURLException, IOException{
		setMangaImage(mangaPageFile);
		setOrientation();
	}
	
	private void setMangaImage(File mangaPageFile) throws BadElementException, MalformedURLException, IOException{
		
		String absolutePath = mangaPageFile.getAbsolutePath();
		this.image = Image.getInstance(absolutePath);
		this.image.setAlignment(ALIGN_CENTER);
	}
	public Image getMangaPageImage(){
		return this.image;
	}
	
	private void setOrientation(){
		if(this.image.getHeight()>image.getWidth()){
			this.orientation = Orientation.VERTICAL;
		}else{
			this.orientation= Orientation.HORIZONTAL;
		}		
	}
	
	public MangaPage[] SplitMangaPage(Image img){
		//TODO
		return null;
	}
	
	
}

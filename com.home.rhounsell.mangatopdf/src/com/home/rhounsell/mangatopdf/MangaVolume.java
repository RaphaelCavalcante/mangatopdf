package com.home.rhounsell.mangatopdf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MangaVolume extends MangaAbstract{
	private int volNumber;
	private File volumePath;
	
	public MangaVolume(File volumePath, int volNumber){
		this.volumePath=volumePath;
		this.volNumber = volNumber;
	}
	
	public int getVolNumber(){
		return this.volNumber;
	}
	
	public List <MangaChapter> getVolumeChapters(){
		List <MangaChapter> chapters= new ArrayList<MangaChapter>();
		File [] volumes= volumePath.listFiles();
		for(int chapter=0;chapter<volumes.length;chapter++){
			MangaChapter chap= new MangaChapter(volumes[chapter],chapter);
			chapters.add(chap);
		}
		return chapters;
	}
}

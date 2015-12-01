package com.home.rhounsell.mangatopdf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.home.rhounsell.mangatopdf.interfaces.IVolume;


public class MangaVolume extends MangaAbstract implements IVolume{
	private int volNumber;
	private File volumePath;
	
	public MangaVolume(File volumePath, int volNumber){
		this.volumePath=volumePath;
		this.volNumber = volNumber;
	}
	@Override
	public int getVolNumber(){
		return this.volNumber;
	}
	@Override
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

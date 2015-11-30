package com.home.rhounsell.mangatopdf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Manga extends MangaAbstract{
	private List<MangaVolume> mangaVol = null;
	
	public Manga(String title, String pathToMangaDirectory){
		setTitle(title);
		loadManga(pathToMangaDirectory);
	}
	private void loadManga(String pathToMangaDirectory){
		File manga=new File(pathToMangaDirectory);
		File[] volPaths= manga.listFiles();
		mangaVol = new ArrayList<MangaVolume>();
		for(int vol=0;vol<volPaths.length;vol++){
			MangaVolume volume=new MangaVolume(volPaths[vol], vol);
			mangaVol.add(volume);
		}
	}
	public List<MangaVolume> getMangaVolumes(){
		return this.mangaVol;
	}
	public int getVolumes(){
		return this.mangaVol.size();
	}
}

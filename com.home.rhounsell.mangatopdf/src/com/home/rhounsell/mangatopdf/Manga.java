package com.home.rhounsell.mangatopdf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.home.rhounsell.mangatopdf.interfaces.IManga;

public class Manga extends MangaAbstract implements IManga{
	private List<MangaVolume> mangaVol = null;
	
	public Manga(String title, String pathToMangaDirectory){
		setTitle(title);
		loadManga(pathToMangaDirectory);
	}
	@Override
	public void loadManga(String pathToMangaDirectory) {
		File manga=new File(pathToMangaDirectory);
		File[] volPaths= manga.listFiles();
		mangaVol = new ArrayList<MangaVolume>();
		for(int vol=0;vol<volPaths.length;vol++){
			MangaVolume volume=new MangaVolume(volPaths[vol], vol);
			mangaVol.add(volume);
		}
	}

	@Override
	public List<MangaVolume> getMangaVolumes() {
		return this.mangaVol;
	}

	@Override
	public int getVolumes() {
		return this.mangaVol.size();
	}
}

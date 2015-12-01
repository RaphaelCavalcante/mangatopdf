package com.home.rhounsell.mangatopdf.interfaces;

import java.util.List;

import com.home.rhounsell.mangatopdf.MangaVolume;

public interface IManga {
	void loadManga(String pathToMangaDirectory);
	List <MangaVolume>getMangaVolumes();
	int getVolumes();
}

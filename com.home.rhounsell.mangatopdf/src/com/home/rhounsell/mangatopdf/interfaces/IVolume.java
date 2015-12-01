package com.home.rhounsell.mangatopdf.interfaces;

import java.util.List;

import com.home.rhounsell.mangatopdf.MangaChapter;

public interface IVolume {
	int getVolNumber();
	List <MangaChapter> getVolumeChapters();
}

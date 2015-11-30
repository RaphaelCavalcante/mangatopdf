package com.home.rhounsell.mangatopdf.comandline;

import com.home.rhounsell.mangatopdf.GenerateMangaPDF;
import com.home.rhounsell.mangatopdf.Manga;

public class ComandLineMain {
	private static final String USAGE = "<title> <path_to_manga>";
	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println(USAGE);
			System.exit(1);
		}
		String mangaFileName = args[0]+".pdf";
		Manga manga= new Manga(args[0], args[1]);
		
		new GenerateMangaPDF(manga).createPdf(mangaFileName);
	}

}

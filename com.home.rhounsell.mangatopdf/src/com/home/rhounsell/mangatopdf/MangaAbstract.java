package com.home.rhounsell.mangatopdf;


public abstract class MangaAbstract {
	private String title;
	private String url;
	
	protected void setURL(String url){
		this.url= url;
	}
	protected String getURL(){
		return this.url;
	}
	protected void setTitle(String title){
		this.title= title;
	}
	protected String getTitle(){
		return this.title;
	}
}

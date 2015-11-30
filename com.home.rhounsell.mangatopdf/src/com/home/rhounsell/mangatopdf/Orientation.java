package com.home.rhounsell.mangatopdf;

public enum Orientation {
	HORIZONTAL(0), VERTICAL(1);
	private int orientation;

	private Orientation(final int orientation) {
		this.orientation = orientation;
	}
	public final int getOrienation() {
		return this.orientation;
	}
}

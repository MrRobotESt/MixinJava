package de.th_nuernberg.softa.aufgabe3_lsg;

//********************************************************************
//The interface of the classes that can be mixed with the mixin.
//This interface depicts the behavior that the mixin requires.
//********************************************************************

public interface MRequires {

	public void swap(int index_i, int index_j);
	public int get(int index);
	public int length();
}

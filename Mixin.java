package de.th_nuernberg.softa.aufgabe3_lsg;

//********************************************************************
//Represents a mixin for bubblesort applicable for subtypes of MRequires.
//********************************************************************


public class Mixin implements MProvides {

	private MRequires parent;
	private boolean isInitialized = false;

	public void bubblesort() {
		if(this.isInitialized){
			for (int index_i = parent.length() - 1; index_i >= 0; --index_i) {
				for (int index_j = 0; index_j < index_i; ++index_j) {
					if (parent.get(index_j) > parent.get(index_j + 1)) {
						parent.swap(index_j, index_j+1);
					}
				}
			}
		}
	}

	public void print() {
		if(this.isInitialized){
			String buf = "[ ";
			for (int i = 0; i < parent.length(); ++i) { 
				buf += parent.get(i);
				buf += " ";
			}
			System.out.print(buf + "]");
		}
	}

	public void initialize(MRequires arrayList) {
		this.parent = arrayList;
		this.isInitialized = true;
	}
}

package de.th_nuernberg.softa.aufgabe3_lsg;

//********************************************************************
//Represents an integer array implementation of an integer set with
//the mixin behavior.
//********************************************************************

public class IntArrSetMixedWithBubblesortAndPrint extends IntegerArraySet {

	private final MProvides mixin;

	public IntArrSetMixedWithBubblesortAndPrint(MProvides mixin){
		super();
		this.mixin = mixin;
		this.mixin.initialize(this);
	}

	public IntArrSetMixedWithBubblesortAndPrint(int initialCapacity, MProvides mixin){
		super(initialCapacity);
		this.mixin = mixin;
		this.mixin.initialize(this);
	}

	/******************************************************************
	 * Delegate to bubblesort method of the mixin.
	 ******************************************************************/
	public void bubblesort() {
		mixin.bubblesort();
	}

	/******************************************************************
	 * Delegate to print method of the mixin.
	 ******************************************************************/
	public void print() {
		mixin.print();
	}

}

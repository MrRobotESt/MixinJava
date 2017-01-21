package de.th_nuernberg.softa.aufgabe3_lsg;

//********************************************************************
//Represents an integer array implementation of an integer set.
//********************************************************************

public class IntegerArraySet implements MRequires {

	private final int DEFAULT_CAPACITY = 100;
	private final int NOT_FOUND = -1;
	private final int NO_ELEMENT = 0;
	private int data[];
	private int last;

	/******************************************************************
	 * Creates an empty set using the default capacity.
	 ******************************************************************/
	public IntegerArraySet()
	{
		last = 0;
		data =  new int[DEFAULT_CAPACITY];
	}

	/******************************************************************
	 * Creates an empty set using the specified capacity.
	 ******************************************************************/
	public IntegerArraySet(int initialCapacity)
	{
		last = 0;
		data = new int[initialCapacity];
	}

	/******************************************************************
	 * Swaps the elements specified by their indices.
	 ******************************************************************/
	public void swap(int index_i, int index_j) {
		int tmp = data[index_i];
		data[index_i] = data[index_j];
		data[index_j] = tmp;
	}

	/******************************************************************
	 * Gets the element at the specified index.
	 ******************************************************************/
	public int get(int index) {
		if(index < last){
			return data[index];
		}else{
			return NOT_FOUND;
		}
	}

	/******************************************************************
	 * Adds the specified element to the set if it is not already
	 * present. Expands the capacity of the integer set array if necessary.
	 ******************************************************************/
	public void add(int element) {
		if (!(contains(element)))
		{
			if (this.size() == this.length()){
				expandCapacity();
			}
			data[last] = element;
			++last;
		}
	}

	/******************************************************************
	 * Effective length of the array set.
	 ******************************************************************/
	public int length() {
		return last;
	}

	/******************************************************************
	 * Returns true if this set contains the specified element.
	 *******************************************************************/
	public boolean contains(int element) {
		int search = NOT_FOUND;

		for (int index=0; index < last && search == NOT_FOUND; ++index)
			if (data[index] == element){
				search = index;
			}
		return (search != NOT_FOUND);
	}

	/******************************************************************
	 * Removes the specified element from the set and returns it.
	 ******************************************************************/
	public int remove(int element) {
		int search = NOT_FOUND;

		assert (!(last==0));
		assert (contains(element));

		for (int index=0; index < last && search == NOT_FOUND; ++index)
			if (data[index]==element){
				search = index;
			}

		// postcondition
		assert (search != NOT_FOUND);

		int result = data[search];

		data[search] = data[last-1];
		data[last-1] = NO_ELEMENT;
		--last;

		return result;
	}

	/******************************************************************
	 * Double the size of the data array.
	 ******************************************************************/
	private void expandCapacity()
	{
		int[] larger = new int[data.length*2];

		for (int index=0; index < data.length; ++index){
			larger[index] = data[index];
		}
		data = larger;
	}

	/******************************************************************
	 * Principle size of the array.
	 ******************************************************************/
	private int size() {
		return data.length;
	}
}

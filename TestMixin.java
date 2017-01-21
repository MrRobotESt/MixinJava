package de.th_nuernberg.softa.aufgabe3_lsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestMixin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntArrSetMixedWithBubblesortAndPrint arraySetMixin;

		int initialCapacity = -1;
		boolean setUpSize;
		do{
			setUpSize = true;
			System.out.print("Enter initial capacity, if 0 then default capacity will be set: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String initialCapacityS = null;
			try {
				initialCapacityS = br.readLine();
				int initCapacity = Integer.parseInt(initialCapacityS);
				if(initCapacity>=0){
					initialCapacity = initCapacity;
				}else{
					throw new IllegalArgumentException("Please specify the size as a non-negative integer number.");
				}
			} catch (IOException ioe) {
				System.out.println("IO error trying to read the initial capacity.");
				setUpSize = false;
				System.exit(1);
			} catch (IllegalArgumentException iae) {
				System.out.println("Please specify the size as a non-negative integer number.");
				setUpSize = false;
				System.exit(1);
			}
		}while(!setUpSize);
		MProvides mixin = new Mixin();
		if(initialCapacity==0){
			arraySetMixin = new IntArrSetMixedWithBubblesortAndPrint(mixin);
		}
		else{
			arraySetMixin = new IntArrSetMixedWithBubblesortAndPrint(initialCapacity, mixin);
		}


		int arrayLength = -1;
		boolean setLength;
		do{
			setLength = true;
			System.out.print("Enter the number of integer elements to be put into the array set: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String lengthS = null;
			try {
				lengthS = br.readLine();
			} catch (IOException ioe) {
				setLength = false;
				System.out.println("IO error trying to read the number of integer elements.");
				System.exit(1);
			}
			int length = Integer.parseInt(lengthS);
			if(length==0){
				setLength=false;
				throw new IllegalArgumentException("Please specify the length as a non-negative, non-zero integer number.");
			}
			else if(length>0){
				arrayLength = length;
			}else{
				setLength=false;
				throw new IllegalArgumentException("Please specify the length as a non-negative, non-zero integer number.");
			}
		}while(!setLength);


		boolean ok;
		do{
			ok = true;
			try{
				System.out.print("Please enter " + arrayLength + " numbers for the array set. The numbers must be separated by ','. ");
				Scanner input = new Scanner(System.in);
				String numbers = input.next();

				String[] numberStrings = numbers.split(",");
				for(int i = 0; i < arrayLength; ++i){
					arraySetMixin.add(Integer.parseInt(numberStrings[i]));
				}

				input.close();
			}
			catch(ArrayIndexOutOfBoundsException aioobe){
				System.out.println("No! Please provide " + arrayLength + " DIFFERENT numbers for the array set (it is a set)!");
				ok=false;
			}
			catch(NumberFormatException nfe){
				System.out.println("Please respect the integer format!");
				ok=false;
			}

		}while(!ok);

		System.out.println("The following numbers were read in: ");
		arraySetMixin.print();
		System.out.println("\nThe sorted set: ");
		arraySetMixin.bubblesort();
		arraySetMixin.print();
	}
}

package me.niklas.weisz.java.secretsanta;

import java.util.Scanner;

/**
 * A class that asks the user to enter a list of name and then randomly assigns a partner to every name.
 * @author Niklas Finzel
 * @version 1.0
 */
public class DrawingNames {

	/**
	 * The original list of names.
	 */
	static String[] finalList;
	
	
	/**
	 * Constructor of the class DrawingNames
	 * @param args doesnt get used.
	 * 
	 */
	public static void main(String[] args) {
		
		String nameList = enterNames();
		String[] names = nameList.split("\\,");
		finalList = new String[names.length];
		
		for(int i=0;i<names.length;i++){
	
			finalList[i]=names[i];
		
		}
		getNames(randomDrawing(names)); 

	}
	
	/**
	 * Assigns a random name to every name.
	 * @param names2 the list of names.
	 * @return the index of the assigned name
	 */
	private static int[] randomDrawing(String[] names2) {
		int length = names2.length;
		int[] drawnNames = new int[length];
		String[] names3 = names2;
		
		for (int i=0;i<length;i++){
		
			boolean completed = false;

			while(!completed){
			
				completed = false;
				int number = (int) (Math.random()*length);
				
				if(number==i){
				
					completed = false;
				
				}
				else if(names3[number]=="--"){
				
					completed = false;
				
				}
				else{
				
					drawnNames[i] = number;
					names3[number] = "--";
					completed = true;
				
				}
			}
		}
		return drawnNames;
	}
	
	/**
	 * Outputs the names of the secret santa and their partner.
	 * @param names4 the array that assigns the partners.
	 * 
	 */
	private static void getNames(int[] names4) {
		System.out.println("Secret Santa and their partner:");
		
		for(int i=0;i<finalList.length;i++){
		
			System.out.println(i + ": " + finalList[i] + " | " + finalList[names4[i]]);
		
		}
		
	}

	/**
	 * Asks the user to input a list of names into the console.
	 * @return returns the list of names entered by user.
	 * 
	 */
	private static String enterNames() {
		
		Scanner InputName = new Scanner(System.in);
		System.out.println("Input names split with ','.");
		String nameList = InputName.next();
		InputName.close();
		return nameList;
		
	}
		
}
	
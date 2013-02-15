import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Created by Kai Austin
//March 2012

/*This program is designed to create a tree of integers which have to following properties
 * 1) The root node has a value of 1
 * 2) Each node tree has two children
 * 3) The value for the children nodes is determined as follows:
 * 		left child = sum of parent and left of parent
 * 		right = sum of parent and right of parent
 * Requires a value manually input
 * Builds tree then prints it out either in consule or seperate file
 * 
 * Eg. 	Input Value: 1
 * 		Tree output: 1
 * 
 * 		Input value: 2
 * 		Tree output 1
 * 				   1  1
 * 
 * 		Input value: 4
 * 		Tree output: 1
 * 				   1    1
 * 				 1   2 2   1
 * 				1 33 4 4  33 1
 * */

//PURPOSE: Launching ALL the things
public class Launch {
	
	public static void main(String[] args) {
		
		//Reading in the input number
		int rootNum;
		boolean activated = false;
		
		while (activated == false) {
			try {
				
				Scanner in = new Scanner(System.in);	//Making scanner for input value, Error if not int
				System.out.println("Enter a value between 1 and 10");	//Instructions, because they are helpful
				rootNum = in.nextInt();					//Transferring value to rootNum
				in.close();								//Closing Scanner
			
				//Creating new Tree with the given number of levels
				Tree t = new Tree(rootNum);
				new BuildTree(t.getTree(), rootNum);
				
				activated = true;
			}
			catch (InputMismatchException e) {	//Assuming input is anything but an int, will loop until one is put in
				System.out.println("That is not a recognized value");
			}
		}
		
	}
	
	
}
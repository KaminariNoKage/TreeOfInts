import java.util.*;

//Kai Austin
//March 2012

//PURPOSE: To take the tree that it is given and format it with branches (" / \ ") and appropriate spacing

public class BuildTree {
	
	ArrayList<String> ntree;
	ArrayList<String> finalTree;
	int rnum;
	private int len;
	private int a;		//Arbitrary value for whatever
	private String temp;
	private String newString;
	
	public BuildTree(ArrayList<String> tree, int rootNum) {
		ntree = tree;
		finalTree = new ArrayList<String>();
		rnum = rootNum;
		order();
	}
	
	//Organizing things and then printing them out
	private void order() {
		
		for (int i=0; i<ntree.size(); i++) {
			
			if (rnum == 1){
				finalTree.add(ntree.get(i));
				System.out.println(finalTree.get(i));	//Not much formating to worry about here
			}
			else {
				temp = fixSpacing(ntree.get(i));		//Attempting to fix spacing issues for easier read/format
				System.out.println(centerText(temp));	//Where everything prints out to the console
			}
		}

	}

	//Attempting to add more spaces between
	private String fixSpacing(String pass) {
		String neu = pass;
		
		neu = neu.replace("", " ").trim();

		return neu;
	}

	//Adds padding to each side of the string in an attempt to center
	private String centerText(String pass) {
		a = findLength();
		newString = pass;
		int len = newString.length();
		
		while (len <= a) {
			
			if (pass.length() > a) {
				//Do nothing, because if it is as longer than it needs to be, centering will not be fun
			}
			else {
			newString = "   " + newString + " ";	//adding spacing/padding at the front and back
			}
			
			len = newString.length();		//Just in case not over writing while loop
		}	
		
		return newString;
	}
	
	private int findLength() {
		len = ntree.get(ntree.size() - 1).length(); //Getting the length of the last string in the passed array
		return len;
	}	
	
}
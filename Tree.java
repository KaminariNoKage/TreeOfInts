import java.util.ArrayList;


//Kai Austin
//March 2012

//PURPOSE: In charge of handleing the values in the outcome of what the tree will be.
//Primary return is masterTree which is an ArrayList of all the children values at each level

public class Tree {
	
	int root;
	ArrayList<Integer> branchRow;	//making an ArrayList of Integers
	ArrayList<String> masterTree;	//will store entire string of trees
		
	public Tree(int t) {		//Constructor initializing for Launch and rest of class
		root = t;
		masterTree = new ArrayList<String>();
		makeTree();				//"Actual" activation
	}
	
	
	//Responsible for handling outcomes based on the input, whether to grow the tree or determine if something is invalid
	public void makeTree(){
		
		//For case where input node is 1
		if (root == 1) {	
			masterTree.add("1");
		}
		//For case where input node is less than 1 (negative or zero)
		else if (root < 1) {
			System.out.println("Please Enter a positive value. Trees don't grow backwards.");
		}
		else if (root > 10) {
			System.out.println("Give the poor program a break! You know how big that tree will be?");
		}
		//For all other hopefully normal cases
		else {
			masterTree.add("1");	//Adding the parent of all the children
			grow();
		}
		
	}
	
	//Methods that do ALL the things
	//Random variables here
	private int level;	//For indicating which level we are on
	private int a;		//Random variable 1 for passing usage
	private int b;		//Random variable 2 for passing usage
	private int newInt;	//Because c was too boring and uninformative
	private ArrayList<Integer> atemp;	//ArrayList to temporarily store the strings
	
	private void grow() {
		level = 1;
		branchRow = new ArrayList<Integer>();
		
		while (level != root){
			if (level ==1) {			//Should only activate if on the second level
				
				//Making the second level and creating branch Array
				branchRow.add(1);
				branchRow.add(1);
			}
			else {
				ArrayList<Integer> rowTemp = branchOut(branchRow, level);	//Throwing it into method to do work and storing in temporary place
				branchRow = rowTemp;
			}
			
			spacePrev();
			//masterTree.add(addBranches(branchRow));  //Making branches ( / \ ) to fit the number of children
			masterTree.add(unpack(branchRow));	//Since branchRow is an ArrayList of integers, need to seperate and store as strings
			
			level++;
		}
		
	}
	
	//Adds spacing between elements
	//NOTE: Will also add spacing between more than 1-digit numbers, making this ideal for 4 levels or less
	private void spacePrev() {
		int i = 0;
		while (i != masterTree.size()) {
			masterTree.get(i).replace("", " ").trim();
			i++;
		}
		
	}

	private ArrayList<Integer> branchOut(ArrayList<Integer> prev, int level) {
		atemp = new ArrayList<Integer>();
		int i = 0;						//Value = 0 as first position in ArrayList index is 0
				
		while (i != prev.size()){		//Extracting (or Calculating) each child here for each parent

			if (i==0){					//To avoid out of bounds error
				a = 1;					//There is no right sibling, so same value as parent (1)
				b = calcLeft(prev,i);
			}
			else if (i==prev.size()-1) { //To avoid out of bounds error as maximum size
				a = calcRight(prev, i);	
				b = 1;					//There is no left sibling, so same value as parent(1)
			}
			else {						//For all normal cases
				a = calcRight(prev, i);
				b = calcLeft(prev, i);
			}
			
			
			//Adding each to end of ArrayList
			atemp.add(a);	//Right child
			atemp.add(b);	//Left child
									
			i++;
		}
		
		
		return atemp;
	}

	//Calculating current i with its left sibling (so i is on the right)
	private int calcRight(ArrayList<Integer> prev, int curCalc){
		int c = prev.get(curCalc-1);	//Getting right
		int d = prev.get(curCalc);		//Getting current
		newInt = c+d;					//Adding together
		
		return newInt;
	}
	
	//Calculating current i with its right sibling (so i is on the left)
	private int calcLeft(ArrayList<Integer> pass, int curCalc) {
		int e = pass.get(curCalc);		//Getting current
		int f = pass.get(curCalc+1);	//Getting left
		newInt = e+f;					//Adding together
		
		return newInt;
	}
	
	//Converting ArrayList to a String
	//Note: Will all be converted and combined to a single line; not designed for anything else
	private String unpack(ArrayList<Integer> box){
		
		//Declaring things
		String fancyRow = "";
		boolean stop = false;	//Initial condition of while loop boolean
		int i = 0;				//ArrayLists start at element 0;
		int limit = box.size();	//Taking the size of the Array; automatically +1 since does not count 0
		
		while (stop != true) {
			
			//If there is no next item in the arrayList, the loop will stop and return the string
			if (i == limit) {
				stop = true;
			}
			//else the next item in the arrayList will be added to the main tree as a string
			else {
				fancyRow = fancyRow + box.get(i) + " ";
				
				i++;											//Increasing i
			}
		}
		
		return fancyRow;
	}
	
	//Adding the branches depending on what level we are on.
	private String addBranches(ArrayList<Integer> pass) {
		int a = pass.size()/2;
		String branchString = "";
		for (int i=0; i < a; i++) {
			branchString = branchString + "/ \\ ";	//Double slash as will not register otherwise
		}
		
		return branchString;
	}
	
	//Returning final tree ArrayList
	public ArrayList<String> getTree() {
			
		return masterTree;
	}
	
}
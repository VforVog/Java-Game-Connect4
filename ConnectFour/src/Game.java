import java.util.Scanner;
import java.util.Random;

public class Game {
	private String name[] = new String[3];
	private String chip[] = new String[3];
	private int i;
	private int j;
	private  int counter;
	private  int playerCounter;
	private String x = "x";
	private String y = "o";
	private String p = "-";
	private int col;
	private  int rows;
	private  int columns;
	private String[][] theGame = new String[15][15];
	Random rand = new Random();
	Methods methods = new Methods();
	boolean win = true;
	boolean tie = true;
	boolean flag1;
	boolean flag2;
	boolean flag3;

	
	public void takeNames() 
	{
		//Pernei Onomata
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Bienvenidos al Score 4!!");
		
		for(i=0; i<2; i++)
		{
			System.out.printf("Please enter the name of the " + (i+1) + " player:");
			name[i] = keyboard.nextLine();
		}	
	}
	
	public void takeChips()
	{
		//Pernei chips & Kanei elegxo Egkyrothtas gia strings
		
		Scanner keyboard = new Scanner(System.in);
		for(i=0; i<2; i++)
		{
			System.out.printf(name[i] + ", please select your chip x or o:");
			chip[i] = keyboard.nextLine();
			methods.CheckChips(chip, name, i, x, y);
		}
	}
	
	public void takelines()
		{
		//Elegxei kai Pernei ta katallhla Rows & Columns
		
			Scanner keyboard = new Scanner(System.in);

			System.out.printf("Please enter the number of rows: ");
			rows = keyboard.nextInt();
			methods.CheckRows(rows);
			
			System.out.printf("Please enter the number of columns: ");
			columns = keyboard.nextInt();
			methods.CheckColumns(columns);
			System.out.printf("\n");
		}
		
	public void theGameDesign()
	{
		//ARXIKOPOIEI kai emfanizei pinaka
		counter = 0;
	
		methods.BoardBuild(theGame, rows, columns);
		methods.PrintGame(theGame, rows, columns, counter);
		
	}	

	public void ChooseAndDrop()
	{
		//Emfanizei Allagmeno Pinaka, Ystera apo kinhseis paiktwn
		
		Scanner keyboard = new Scanner(System.in);
		
		int res = rand.nextInt(name.length);
	    System.out.printf(name[res] + ", your turn. Select column: ");
	    col = keyboard.nextInt();
	    System.out.printf("\n");
	 
 //Gia na pai6ei o PRWTOS tyxaios
	    	
	  if (name[res] == name[0]) {
		  playerCounter = 0;
		  
		  for(i=6; i>0; i--) {
	    		if(theGame[i][col] == "-"){
		    		theGame[i][col] = chip[0];
		    		break;
			    }
		   }
		  methods.PrintGame(theGame, rows, columns, counter); 
		  playerCounter++;
	  }
	  
	  else {
		  playerCounter = 1;
		  
		  for(i=6; i>0; i--) {
	    		if(theGame[i][col] == "-"){
		    		theGame[i][col] = chip[1];
		    		break;
			    }
		   }
		  methods.PrintGame(theGame, rows, columns, counter); 
		  playerCounter--;
	  }
	  
//End Gia na pai6ei o PRWTOS tyxaios  
	  
//6ekinaei h deuterh gyra mexri kai to telos, with the loop
	 
 
	  do {
		  if(playerCounter == 0)
		  {
			  methods.PlayerCounter0(name, theGame, chip, p, col, rows);
			  methods.PrintGame(theGame, rows, columns, counter); 
			  
			  flag1 = methods.HorizontalWin(theGame, chip, win, playerCounter,rows, columns);
			  flag2 = methods.VerticalWin(theGame, chip, win, playerCounter,rows, columns);
			  flag3 = methods.DiagonalWin(theGame, chip, win, playerCounter,rows, columns);
			  methods.Tie(theGame, p, tie, i, j);
			  playerCounter++;
			  if (flag1 == false || flag2 == false || flag3 == false) break;
		  }
		  
		  if(playerCounter == 1)
		  {
			  methods.PlayerCounter1(name, theGame, chip, p, col, rows);
			  methods.PrintGame(theGame, rows, columns, counter); 
			  
			  flag1 = methods.HorizontalWin(theGame, chip, win, playerCounter,rows, columns);
			  flag2 = methods.VerticalWin(theGame, chip, win, playerCounter,rows, columns);
			  flag3 = methods.DiagonalWin(theGame, chip, win, playerCounter,rows, columns);
			  methods.Tie(theGame, p, tie, i, j);
			  playerCounter--;
			  if (flag1 == false || flag2 == false || flag3 == false) break;
		  }
		
	  }while(flag1 == true || flag2 == true || flag3 == true || tie == true);
	  
//End 6ekinaei h deuterh gyra mexri kai to telos, with the loop
	  
	  
//Print the name of the winner or the Tie
	  if (flag1 == false || flag2 == false || flag3 == false)
	  {
		  if(playerCounter == 0)
		  {
			    System.out.println("The winner is: " + name[1]);
		  }
		  else {
			  System.out.println("The winner is: " + name[0]);
		  }
	  }
	  else {
		  System.out.println("Well Done, but we have a Tie");
	  }
		
	}

}


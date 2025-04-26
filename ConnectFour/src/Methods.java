import java.util.Scanner;

public class Methods {
	//Methods gia na eianai pio clean o kwdikas
	
	public void CheckChips(String chip[], String name[], int i, String x, String y)
	{
		Scanner keyboard = new Scanner(System.in);

		do {
			if (chip[i].equalsIgnoreCase(x) || chip[i].equalsIgnoreCase(y))
			{
				break;
			}
			else 
			{
				System.out.printf("Incorrect input. ");
				System.out.printf(name[i] + ", please select your chip x or o: ");
				chip[i] = keyboard.nextLine();
			}
		}while(chip[i].equalsIgnoreCase(x) || chip[i].equalsIgnoreCase(y)); 

	}
	
	public void CheckRows(int rows)
	{
		//Methodos pou Elegxei Egkyrothta gia Int
		//Arxh Epenalh6hs Douleuei entelws antitheta apo to logiko :p

		Scanner keyboard = new Scanner(System.in);

		do {
			if(rows>3 && rows<16) {
				break;
			}
			else {
				System.out.printf("Invalid. (Á small tip, put numbers >= 4 within numbers =< 15).\n");
				System.out.printf("Please enter the number of rows: ");
				rows = keyboard.nextInt();
			}
		}while(rows<3 || rows>16);
	}

	public void CheckColumns(int columns)
	{
		//Methodos pou Elegxei Egkyrothta gia Columns
		//Arxh Epenalh6hs Douleuei entelws antitheta apo to logiko :p...
		
		Scanner keyboard = new Scanner(System.in);

		do {
			if(columns>3 && columns<16) {
				break;
			}
			else {
				System.out.printf("Invalid. (Á small tip, put numbers >= 4 within numbers =< 15).\n");
				System.out.printf("Please enter the number of columns: ");
				columns = keyboard.nextInt();
			}
		}while(columns<3 || columns>16);
	}

	public void BoardBuild(String theGame[][], int rows, int columns)
	{
		for (int i=1;i<=rows;i++) {
			for(int j=1;j<=columns;j++)
			{
				theGame[i][j] = "-";
			}
		}
	}
	
	public void PrintGame(String theGame[][], int rows, int columns, int counter)
	{
		//Methodos pou kanei ton pinaka na emfanizetai
		
		//Board Print
		for (int i=1;i<=rows;i++) {
			if(i != 1)
			{
				System.out.printf("\n");
				System.out.printf("|");
			}
			else
			{
				System.out.printf("|");
			}
			for(int j=1;j<=columns;j++)
			{
				System.out.printf("%2s " , theGame[i][j]);
				if(j==columns)
				{
					System.out.printf("|");
				}
			}
		}
		
		//Gia to katw meros einai to print auto
		System.out.printf("\n");
		
		while (counter != columns-1)
		{
			System.out.printf("----");
			counter++;
		}
		
		System.out.printf("\n");
		
		for (int i=1;i<columns+1; i++)
		{
			System.out.printf("%3s" ,  i );
		}
		
		System.out.println("\n");
		//Same Thing with   System.out.printf("\n\n");
	}
		
	public void PlayerCounter0(String name[], String theGame[][], String chip[], String p, int col, int rows)
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.printf(name[0] + ", your turn. Select column: ");
		col = keyboard.nextInt();
		System.out.printf("\n");
		  
		   for(int i=rows; i>0; i--) {
	    		if(theGame[i][col] == "-"){
		    		theGame[i][col] = chip[0];
		    		break;
			    }
		   }
		 
	}
	
	public void PlayerCounter1(String name[], String theGame[][], String chip[], String p,int col, int rows)
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.printf(name[1] + ", your turn. Select column: ");
		   col = keyboard.nextInt();
		   System.out.printf("\n");
		   
		   for(int i=rows; i>0; i--) {
	    		if(theGame[i][col] == "-"){
		    		theGame[i][col] = chip[1];
		    		break;
			    }
		   }
		
	}

	public boolean Tie(String theGame[][], String p, boolean tie, int rows, int columns)
	{
		//Elegxei merika shmeia ths 1hs seiras ama exoun -, ama den exoun tote dinei TIE. 
		//Xrhsimopoihsa ayth thn texnikh, an kai oxi 100% apotelesmatikh
		//Alla arketa apotelesmatikh gia to Real Life wste na aporri6ei an oxi ola, polla apo ta endexomena
		
		int m = columns / 2;
		int mm = m / 2;
		int mmm = mm/2;
		
		if (!(theGame[1][1] == "-"  && theGame[1][columns] == "-" && theGame[1][m] == "-" && theGame[1][mm] == "-" && theGame[1][mmm] == "-") ) {
			tie = false;
			}
		
		return tie;
	}
	
	public boolean HorizontalWin(String theGame[][],String chip[], boolean win, int playerCounter, int rows, int columns)
	{
		int token;
		
		for(int d=rows; d>0;d--) {
			token = 0;
			for(int f=1; f<=columns;f++) {
				if (chip[playerCounter] == theGame[d][f]) {
					token++;
					
					//Stopper
					 if (chip[playerCounter] != theGame[d][f] && token <4)
					{
						token = 0;
					}
					
					if (token == 4) {
						win = false;
					}
				}
			}
		}
		return win;
	}
	
	public boolean VerticalWin(String theGame[][], String chip[], boolean win, int playerCounter, int rows, int columns)
	{
		int token;
		
		for(int f=1; f<=columns;f++) {
			token = 0;
			for(int d=rows; d>0;d--) {
				if (chip[playerCounter] == theGame[d][f]) {
					token++;
					if (token == 4) {
						win = false;
					}
					
					//Stopper
					  if (chip[playerCounter] != theGame[d][f] && token <4)
					{
						token = 0;
					}
					
					
				}
			}
		}
		return win;
	}
	
	public boolean DiagonalWin(String theGame[][],String chip[], boolean win, int playerCounter, int rows, int columns)
	{
		/*It's Done, but sometimes has problems -it shows winner in 3 chips- so i made it as a comment!!
		
		int token;
		
		for(int d=rows; d>0+3;d--) {
			token = 0;
			for(int f=1; f<=columns-3;f++) {
				if (chip[playerCounter] == theGame[d][f]) token++;
				if (chip[playerCounter] == theGame[d-1][f+1]) token++;
				if (chip[playerCounter] == theGame[d-2][f+2]) token++;
				if (chip[playerCounter] == theGame[d-3][f+3]) token++;
					
				if (token == 4) win = false;
					
			}
		}
		*/
		return win;
		
	}
}




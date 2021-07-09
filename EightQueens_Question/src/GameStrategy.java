public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................		
		
		int column=cellId%8;
		return column;	
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		
		int row=(int)cellId/8;
		return row;	
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		/*
			WRITE YOUR LOGIC HERE...............................

		*/

		//Row 
		for(int i=0;i<8;i++)
			if(placedQueens[row][i])
				isValid=false;

		//Column
		for(int i=0;i<8;i++)
			if(placedQueens[i][col])
				isValid=false;
		
		// Upper Right
	    for (int i=row,j=col; i>=0 && j>=0; i--, j--)
	        if (placedQueens[i][j])
	            isValid= false;
	  
	    // Lower Right
	    for (int i=row, j=col; j>=0 && i<8; i++, j--)
	        if (placedQueens[i][j])
	            isValid= false;
	    
	    // Upper Left 
	    for (int i=row,j=col; i<8 && j<8; i++, j++)
	        if (placedQueens[i][j])
	            isValid= false;
	    
	    // Lower Left 
	    for (int i=row, j=col; j<8 && i>=0; i--, j++)
	        if (placedQueens[i][j])
	            isValid= false;
	  
	    
	    if(isValid)
			placedQueens[row][col]=true;
	    
//	    System.out.println(row+" "+col);
//	    System.out.println(placedQueens[row][col]+" "+isValid);
		
		return isValid;
	}
}















import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TwoPlayerGameOfLife {

	public static void main(String[] args) {
// Get input file data
		Configuration conf = readInputConfigurationFromFile();
// Throw error if file didnt get read properly		
		if (conf == null) {
			System.out.println("Some error occured while reading input file!");
			return;
		}
// Display the input grid.		
		printCurrentConfiguration(conf);
		
// Get next generations and continue till a player wins
		playUntilSomeoneDies(conf);
	}

	public static void playUntilSomeoneDies(Configuration conf) {

		int gen = 1;
		// the main code goes here with rules
		while (conf.getLiveCellCountPlayer1()>0 && conf.getLiveCellCountPlayer2()>0) {
// make a copy of grid as all updates are simultaneous
			char gridCopy[][] = new char[conf.row][conf.col];
			
			for (int i=0; i<conf.row; i++)
				for (int j=0; j<conf.col; j++)
					gridCopy[i][j] = conf.grid[i][j];
			
			for (int i=0; i<conf.row; i++) {
				for (int j=0; j<conf.col; j++) {
					char newValue = getUpdatedCellValue(conf, gridCopy, i, j);
					if (newValue != 'X')
						conf.grid[i][j] = newValue;
				}
			
			}
// Print all generations
		//	printCurrentConfiguration(conf);
			
			System.out.println("The current grid configuration is as follows:");
			System.out.println("Generation" +gen );
			gen++;
			for (int i=0; i<conf.row; i++) {
				for (int j=0; j<conf.col; j++) {
					System.out.print(conf.grid[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
// Print final result
		if (conf.getLiveCellCountPlayer1() > 0) {
			System.out.println("Winner is Player 1");
			System.out.println("Live cells for Player 1: " + conf.getLiveCellCountPlayer1());
		}
		
		if (conf.getLiveCellCountPlayer2() > 0) {
			System.out.println("Winner is Player 2");
			System.out.println("Live cells for Player 2: " + conf.getLiveCellCountPlayer2());
		}
	
	    printCurrentConfiguration(conf);
		
	}

	public static char getUpdatedCellValue(Configuration conf, char[][] gridCopy, int i, int j) {

		int liveNeighbours = 0;
		LiveCells lc = new LiveCells();
		
		if (i<0 || j<0 || i>=conf.row || j>=conf.col)
			return 'X';
		
		//--------------------------------------------------------
		if (i>0) {
			liveNeighbours += isLive(gridCopy[i-1][j], lc) ? 1 : 0;
			if (j > 0)
				liveNeighbours += isLive(gridCopy[i-1][j-1], lc) ? 1 : 0;
			if (j < conf.col-1)
				liveNeighbours += isLive(gridCopy[i-1][j+1], lc) ? 1 : 0;
		}
		if (i < conf.row-1) {
			liveNeighbours += isLive(gridCopy[i+1][j], lc) ? 1 : 0;
			if (j > 0)
				liveNeighbours += isLive(gridCopy[i+1][j-1], lc) ? 1 : 0;
			if (j < conf.col-1)
				liveNeighbours += isLive(gridCopy[i+1][j+1], lc) ? 1 : 0;
		}
		if (j > 0)
			liveNeighbours += isLive(gridCopy[i][j-1], lc) ? 1 : 0;
		if (j < conf.col-1)
			liveNeighbours += isLive(gridCopy[i][j+1], lc) ? 1 : 0;
		//---------------------------------------------------------
		
		// rules
		if (liveNeighbours<2)
			return '.';
		else if (gridCopy[i][j]!='.' && ((liveNeighbours==2) || (liveNeighbours==3)))
			return gridCopy[i][j];
		else if ( gridCopy[i][j]!='.' && liveNeighbours > 3)
			return '.';
		else if ( gridCopy[i][j]=='.' && liveNeighbours == 3)
			return (lc.liveCellsPlayer1 > lc.liveCellsPlayer2) ? '1' : '2';
		
		return 'X';
	}

	public static boolean isLive(char c, LiveCells lc) {
		if (c == '1')
			lc.liveCellsPlayer1++;
		if (c == '2')
			lc.liveCellsPlayer2++;
		return (c=='1' || c=='2') ? true : false;
	}
	
	private static Configuration readInputConfigurationFromFile() {
		// read the input file and fill the grid here.

		Configuration conf = null;
		int rows = -1;
		int columns = -1;
		
		try {
			File file = new File("MyFile.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
		///	StringBuffer stringBuffer = new StringBuffer();
			String line;
			boolean rowColRead = false;
			int curRow = 0;// curCol = 0;
			
			while ((line = bufferedReader.readLine()) != null) {
				if (!rowColRead) {
					if (line.split("\\s+").length >= 2) {
						rows = Integer.parseInt(line.split("\\s+")[0]);
						columns = Integer.parseInt(line.split("\\s+")[1]);
						System.out.println(rows +" "+ columns);
						conf = new Configuration(rows, columns);
						rowColRead = true;
					} else {
						System.out.println("Invalid input file!");
						return null;
					}
				} else {
					String data = line.trim();
					if (conf == null || data.length() != columns) {
						System.out.println("Invalid input file; values are not as expected!");
						return null;
					}
			
					for (int i=0; i<data.length(); i++) {
						conf.grid[curRow][i] = data.charAt(i);
					}
					curRow++;
				}
				
				if (curRow >= rows)
					break;
			
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		return conf;
	}

	private static void printCurrentConfiguration(Configuration conf) {
		System.out.println("The current grid configuration is as follows:");
		for (int i=0; i<conf.row; i++) {
			for (int j=0; j<conf.col; j++) {
				System.out.print(conf.grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}

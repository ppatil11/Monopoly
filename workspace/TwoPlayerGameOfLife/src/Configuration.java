
public class Configuration {

	int row;
	int col;
	char grid[][] ;
	
	public Configuration(int x, int y) {
		this.row = x;
		this.col = y;
		grid = new char[x][y];
	}
	
	public int getLiveCellCountPlayer1() {
		int count = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == '1')
					count++;
			}
		}
		return count;
	}
	
	public int getLiveCellCountPlayer2() {
		int count = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == '2')
					count++;
			}
		}
		return count;
	}
	
	public int getDeadCellCount() {
		int count = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == '.')
					count++;
			}
		}
		return count;
	}
}

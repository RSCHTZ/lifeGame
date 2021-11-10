
package data;


/**
 * ����һ��ϸ����
 **/
public class CellArray {
	private int [][] cellArray;/*����ϸ������*/
	private int row; /*����ϸ����*/
	private int col; /*����ϸ����*/
	
	public CellArray(int row,int col)/*ϸ���๹�캯��*/
	{
		this.row = row;
		this.col = col;
		cellArray = new int [row][col];
	}

	public int getRow() {
		return row;
	}



	public void setRow( int row) {
		this.row = row;/*�и�ֵ*/
	}



	public int getCol() {
		return col;
	}



	public void setCol(int col) {
		this.col = col;/*�и�ֵ*/
	}



	public int getCell(int x, int y)
	{
		if(x >= 0 && x <row && y>=0 && y<col)
			return cellArray[x][y];
		return -1;
	}
	
	public void  setCell(int x,int y,int cell) {
		this.cellArray[x][y]=cell;
	}
	
	
	
}

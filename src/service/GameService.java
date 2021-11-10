package service;
import data.CellArray;
import java.util.Random;

import data.CellState;
public class GameService {	
	public static int[] temp= {-1,0,1};
	//Ϊ���ó���ʶ��ϸ��������������temp��������-1,0,1����״̬�ֱ��ʾԽ�磬���������Է����ж�ϸ����״̬

	//��ʼ������������ϸ��,����������ǵ�����
	public static CellArray initMap(int row,int col ) {
		CellArray cells=new CellArray(row,col);
		for(int  i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				Random r=new Random();
				int a=r.nextInt(4); //��0-3֮�����ѡһ����
				if(a==1) {
					cells.setCell(i,j,CellState.LIVE.getValue());
				}
				else {
					cells.setCell(i,j,CellState.DEAD.getValue());
					
				}
			}
		}
		return cells;
	}
	
	//�ж�ϸ����һ��������
	public static CellArray generate(CellArray cells) {
		CellArray nextCells=new CellArray(cells.getRow(),cells.getCol());
	  for(int i=0;i<nextCells.getRow();i++) 
		  for(int j=0;j<nextCells.getCol();j++) {
			  
			  int count=countNumber(cells,i,j);
			 if(count==3) {
				 nextCells.setCell(i, j, CellState.LIVE.getValue());   //���ھ�Ϊ�� ��
			 }
			 else if(count==2&&cells.getCell(i, j)==CellState.LIVE.getValue()) {  //���ھ�Ϊ�����Լ������ͻ��� ��
				 nextCells.setCell(i, j, CellState.LIVE.getValue());
			 }
			 else {
				 nextCells.setCell(i, j, CellState.DEAD.getValue());  //������� ��
			 }
		  }
	  
		
		return  nextCells;
		
	}
	//ͳ�Ʊ߽���ϸ�����ھӵĸ���
	public static int countNumber(CellArray cells,int x,int y) {
		int count = 0;
		 for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 3; ++j) {
	                if (CellState.LIVE.getValue() == cells.getCell(x + temp[i], y + temp[j])) {//����ھӻ�ĸ���
	                    ++count;
	                }
	            }
	        }	
		 if (CellState.LIVE.getValue() == cells.getCell(x, y)) {//�����ǰϸ���ǻ�ģ���ȥ�Լ���count-1
	            --count;
	        }
		
        return count;
	}
	
	
}

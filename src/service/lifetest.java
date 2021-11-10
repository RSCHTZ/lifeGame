package service;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.CellArray;


@SuppressWarnings("unused")
public class lifetest {

	@Before
	public void setUp() throws Exception {
	}
	@After
    public void tearDown() throws Exception{
    }

	@Test
	public void testGenerate() {
		 CellArray new_Cells=GameService.initMap(10, 10);
	        for(int i=0;i<10;i++)
	        {
	            for(int j=0;j<10;j++)
	            {
	                System.out.printf("%d  ",new_Cells.getCell(i, j));
	            }
	            System.out.println();
	        }

	        System.out.println();
	        CellArray next_Cells=GameService.generate(new_Cells);
	        System.out.printf("%d    (1,1)\n", next_Cells.getCell(1, 1));
	        System.out.printf("%d    (3,4)\n", next_Cells.getCell(3, 4));
	        System.out.printf("%d    (5,5)\n", next_Cells.getCell(5, 5));
	        System.out.printf("%d    (9,9)\n", next_Cells.getCell(9, 9));
	        System.out.printf("%d   (10,10)\n", next_Cells.getCell(10, 10));
	        System.out.printf("%d   (11,11)\n", next_Cells.getCell(11, 11));
	}

}

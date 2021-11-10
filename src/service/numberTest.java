package service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.CellArray;

public class numberTest {
	CellArray new_Cells = GameService.initMap(10, 10);

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCountNumber() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%d  ", new_Cells.getCell(i, j));
			}
			System.out.println();
		}
		System.out.printf("%d\n", GameService.countNumber(new_Cells, 0, 0));
		System.out.printf("%d\n", GameService.countNumber(new_Cells, 0, 1));
		System.out.printf("%d\n", GameService.countNumber(new_Cells, 0, 2));
		System.out.printf("%d\n", GameService.countNumber(new_Cells, 3, 3));
		System.out.printf("%d\n", GameService.countNumber(new_Cells, 5, 5));
		System.out.printf("%d\n", GameService.countNumber(new_Cells, 9, 9));
		System.out.printf("%d\n", GameService.countNumber(new_Cells, 10, 10));
	}

}

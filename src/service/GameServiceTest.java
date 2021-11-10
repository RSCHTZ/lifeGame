package service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.CellArray;
import junit.framework.Assert;

@SuppressWarnings({ "deprecation", "unused" })
public class GameServiceTest {
    CellArray new_Cells=GameService.initMap(20, 20);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void testInitMap() {
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                System.out.printf("%d  ",new_Cells.getCell(i, j));
            }
            System.out.println();
        }
    }

    

}

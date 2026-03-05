
package ArrayFindTest;

import arraysfind.MaxMinFind;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
   
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
     @Test
     public void testcase()
    {
        MaxMinFind fm=new  MaxMinFind();
        int res=fm.findMax(new int[] {1,2,3,4,5});
        assertEquals(5,res);
    }
     @Test
     public void testmin()
     {
         MaxMinFind fm=new  MaxMinFind();
           int res =fm.findMin(new int[] {10,12,3,14,15});
         assertEquals(3, res);
     }

   
   
}

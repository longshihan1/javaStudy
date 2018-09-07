package test.jnit.test;

import jnit.src.Calculate;
import jnit.test.CalcuteTest;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


/**
 * CalcuteTest Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class CalcuteTestTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: TestAdd()
     */
    //@Test(expected = ArithmeticException.class)
    @Test(timeout = 2000)
    public void testTestAdd() throws Exception {
        Calculate calcuteTestTest=new Calculate();
        int c=calcuteTestTest.add(1,2);
        org.junit.Assert.assertEquals(3,c,0);
    }


} 

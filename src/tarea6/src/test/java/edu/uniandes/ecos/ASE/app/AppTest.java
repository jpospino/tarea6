package edu.uniandes.ecos.ASE.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
        double valorEsperado = App.calculoX(0.20, 6);
         assertEquals(0.55338000, valorEsperado, 0.01);
    }
    
    public void testApp2()
    {
        double valorEsperado = App.calculoX(0.45, 15);
        assertEquals(1.7530800, valorEsperado, 0.01);
    }
    
    
    public void testApp3()
    {
        double valorEsperado = App.calculoX(0.495, 4);
        assertEquals(2.1489257, valorEsperado, 0.01);
    }
}

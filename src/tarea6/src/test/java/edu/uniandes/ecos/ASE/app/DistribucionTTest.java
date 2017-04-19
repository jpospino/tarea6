/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;

import junit.framework.TestCase;

/**
 *
 * @author JuanPablo
 */
public class DistribucionTTest extends TestCase {
     public DistribucionTTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of calculoDistribucion method, of class DistribucionT.
     */
    public void testCalculoDistribucion() {
        DistribucionT distribucionT = new  DistribucionT(10,1.1, 9);
        double valorCalculado = distribucionT.calculoDistribucion();
        assertEquals(0.3500589, valorCalculado, 0.01);
    }     
}

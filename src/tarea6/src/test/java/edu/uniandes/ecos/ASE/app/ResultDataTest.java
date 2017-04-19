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
public class ResultDataTest extends TestCase {
     public ResultDataTest(String testName) {
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
     * Test of valorCalculado method, of class ResultData.
     */
    public void testValorCalculado() {
        System.out.println("valorCalculado");
        ResultData instance = new ResultData(1, 0.11, 4, 9, 0.388035);
        double expResult = 0.05653;
        double result = instance.valorCalculado();
        assertEquals(expResult, result, 0.001);
    }
}

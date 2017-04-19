/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;


/**
 * <h1>ResultData</h1> 
 * Calcula cada uno de los intervalos en los que se divide el rango
 * 
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since 20170402
 */
public class ResultData {
    private int numeroSegmento;
    private double anchoSegmento;
    private double valorFuncion;
    private int multiplicador;
    private int DOF;
    private double valorFuncionDistribucionSimpson;
    
    
    /***
     * contructor de la lase 
     * @param numeroSegmento identficador del intervalo
     * @param anchoSegmento ancho del intervalo
     * @param multiplicador número multiplicador del intervalo
     * @param DOF grados de libertad del cálculo
     * @param valorFuncionDistribucionSimpson valor de la distribución
     */
    public ResultData(int numeroSegmento, double anchoSegmento,int multiplicador, int DOF,double valorFuncionDistribucionSimpson)
    {
        this.numeroSegmento = numeroSegmento;
        this.anchoSegmento = anchoSegmento;
        this.valorFuncion = valorFuncionDistribucionSimpson;
        this.multiplicador = multiplicador;
        this.DOF = DOF;
        this.valorFuncionDistribucionSimpson = valorFuncionDistribucionSimpson;
    }
    
    /***
     * método para el calculo total del intervalo
     * @return valor calculado
     */
    public double valorCalculado()
    {
        
        return anchoSegmento * this.multiplicador * this.valorFuncionDistribucionSimpson * cosienteIntervaloGradosLibertadElevadoGradosLIbertadSobre2() / 3;
    }
    
    /***
     * calcula la segunda columna del ejemplo del requerimiento
     * @return valor calculado
     */
    protected double cosienteIntervaloGradosLibertad()
    {
        double valorTmp = (Math.pow((((this.numeroSegmento == 0)? 1: this.numeroSegmento) *  anchoSegmento),2.0)/this.DOF);
        return 1 + valorTmp;
    }
    
    /***
     * calcula la tercera columna del ejemplo del requerimiento
     * @return calor calculado
     */
    protected double cosienteIntervaloGradosLibertadElevadoGradosLIbertadSobre2() 
    {
        double valorTmp1 =this.cosienteIntervaloGradosLibertad();
        double valorTmp2 = ((-1)*((this.DOF + 1)/ 2));
        return Math.pow(valorTmp1,valorTmp2 );
    }
}

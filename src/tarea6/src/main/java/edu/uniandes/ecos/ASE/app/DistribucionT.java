/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;


/**
 * <h1>DistribucionT</h1> 
 * Calcula al distribución T a partir de valores
 * 
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since 20170402
 */
public class DistribucionT {
    private int numeroSegmentos;
    private double intervalo;
    private int DOF;
    private ResultData[] resultado;
    
    /**
     * Contructor de la clase
     * @param numeroSegmentos numero de segmentos en los que se va dividir el intervalo
     * @param intervalo hasta desde 0 del rango de la función
     * @param DOF  número de grados de libertad
     */
    public DistribucionT(int numeroSegmentos, double intervalo, int DOF )
    {
        this.numeroSegmentos = numeroSegmentos;
        this.intervalo = intervalo;
        this.DOF = DOF;
        
        this.resultado = new ResultData[numeroSegmentos +1];
    }
    
    /***
     * Calculo final de toda la distribución
     * @return valor calculado
     */
    public double calculoDistribucion()
    {
        double resultado = 0.0;
        int multiplicador = 0;
        double tmpValor = 0.0;
        
        for(int i = 0; i < this.resultado.length - 1 ; i++)
        {
            multiplicador = 0;
            
            if(i == 0)
                multiplicador = 1;
            else 
                if((i%2) == 0)
                    multiplicador = 2;
                else 
                    if((i%2) != 0 && (i + 1) != this.resultado.length)
                        multiplicador = 4;
                        
            this.resultado[i] = new ResultData(i, (this.intervalo/ this.numeroSegmentos)  , multiplicador , this.DOF , this.calculaFuncionDistribucionSimpson() );
            tmpValor = this.resultado[i].valorCalculado();
            resultado += tmpValor;
        }
        
        
        multiplicador =   1;
        this.resultado[this.resultado.length -1] = new ResultData(this.resultado.length -1, (this.intervalo/ this.numeroSegmentos)  , multiplicador , this.DOF , this.calculaFuncionDistribucionSimpson() );
        tmpValor = this.resultado[this.resultado.length -1].valorCalculado();
        
        return resultado + tmpValor;
    }
    
    /***
     * Calcula el valor de la columna 5 del ejemplo
     * @return valor calculado
     */
    private double calculaFuncionDistribucionSimpson()
    {
        double divisor = this.calcularGama((this.DOF + 1));
        double cosiente = Math.sqrt(this.DOF * Math.PI) * this.calcularGama(this.DOF);
        return divisor / cosiente;
    }
    
    /***
     * Calcula el gama dado el valor de grados de libertad
     * @param DOF número de grados de libertad
     * @return valor calculado
     */
    private double calcularGama(int DOFCalculate)
    {
        double DOFCalculateTmp = (double)DOFCalculate;
        double valorResultado = ((DOFCalculateTmp/2 ) - 1);
        DOFCalculateTmp = ((DOFCalculateTmp/2 ) - 1);
        
        while(DOFCalculateTmp != 1 && DOFCalculateTmp != 0.5)
        {
            valorResultado = valorResultado * (DOFCalculateTmp - 1) ;
            DOFCalculateTmp = (DOFCalculateTmp - 1);
        }
        
        if(DOFCalculateTmp == 0.5)
            valorResultado = valorResultado * Math.sqrt(Math.PI);
        
        return valorResultado;
    }
}

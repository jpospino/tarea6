package edu.uniandes.ecos.ASE.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;


/**
 * <h1>App</h1> 
 * Punto de ejecución del programad
 * 
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @sin
 */
public class App 
{
    /***
     * Procedimiento principal del programa
     * @param args argumentos para ejecución
     */
    public static void main( String[] args )
    {
       if(args.length > 0) 
            System.out.println(calculoX(Double.parseDouble(args[0]) , Integer.parseInt(args[1]))); 
       
       port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/calculoXIntegral",  "application/json", (req, res) -> {
            double valorIntegral =   Double.parseDouble(req.queryParams("valorIntegral").toString());
            int DOFValue =  Integer.parseInt(req.queryParams("DOF").toString());
            return String.valueOf(calculoX(valorIntegral, DOFValue));
        });
    }
    
    /***
     * Método que itera el calculo de la integral hasta encontrar el valor aproximado
     * @param valorIntegral valor de la integral buscada
     * @param DOFValue grados de libertad
     * @return valor de X resultado
     */
    public static double calculoX(double valorIntegral, int DOFValue)
    {
        double d = 1.0;
        double x = 1.0;
        int numeroSegmentos = 50;
        
        
        DistribucionT  distribucionT = new DistribucionT(numeroSegmentos, x, DOFValue);
        double valorCalculadoIntegral = distribucionT.calculoDistribucion();
        double errorAnterior = 0.0;//valorIntegral - valorCalculadoIntegral;
        
        while(Math.abs(valorIntegral - valorCalculadoIntegral) > 0.00001)
        {
            if(errorAnterior == 0)
                d = ((valorIntegral - valorCalculadoIntegral) > 0) ? 1 : -1;
            else
                d = (((valorIntegral - valorCalculadoIntegral) > 0 && errorAnterior > 0) || ((valorIntegral - valorCalculadoIntegral) < 0 && errorAnterior < 0))? d : (-1) * d /2;   
            
            if(Math.abs(valorIntegral - valorCalculadoIntegral) > 0.00001)
            {
                x += d;
                distribucionT = new DistribucionT(numeroSegmentos, x, DOFValue);
                errorAnterior = valorIntegral - valorCalculadoIntegral;
                valorCalculadoIntegral = distribucionT.calculoDistribucion();
            }            
        }
        
        return x;
    }
}

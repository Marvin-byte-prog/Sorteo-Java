/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteo;

import Listado.ClsListapersonas;
import SQLserver.ClsConexion;
import SQLserver.Tabla_BD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Marvin
 */
public class Sorteo {

    public static void imprime(){
   ClsConexion conn = new ClsConexion();
        Tabla_BD persona;
        Iterator iter = conn.nombres().iterator();
        ArrayList<String> candidatos = new ArrayList<>();
        ArrayList<String> nombresGanadores = new ArrayList<>();
        System.out.println("Lista de participantes");
        while(iter.hasNext()){
            persona = (Tabla_BD) iter.next();
            System.out.println(persona.getNombre());
            candidatos.add(persona.getNombre());
        }
        
        System.out.println("\n");
        
        Collections.shuffle(candidatos);
        
        System.out.println("\nGanadores del sorteo: \n");
        for(int i=0;i<10;i++){
            
            nombresGanadores.add(candidatos.get(i));
            candidatos.remove(i);
            System.out.println("Ganador premio "+(i+1)+": " + nombresGanadores.get(i));
        }
        
        System.out.println("\nEliminados del sorteo: \n");
        Collections.sort(candidatos);
        System.out.println(candidatos);
        
        
    }
    public static void main(String[] args) {
        
    imprime();    

    
    }//fin metodo principal
    
}

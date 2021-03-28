/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listado;

import SQLserver.ClsConexion;
import SQLserver.Tabla_BD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Marvin
 */
public class ClsListapersonas {
    
    public List<String> listaPersonas (){
        ClsConexion conn = new ClsConexion();
        List<String> candidatos = new ArrayList<>();
        Tabla_BD persona;
        Iterator iter = conn.nombres().iterator();
        
        while(iter.hasNext()){
            persona = (Tabla_BD) iter.next();
            candidatos.add(persona.getNombre());
            
        }
        
        return candidatos;
    }
}

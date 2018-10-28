/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author marquirj
 */
public class Sorpresa {
    private String texto;
    private TipoSorpresa tipo;
    private int valor;
   
    
    Sorpresa(String texto, int valor,TipoSorpresa tipo){
    this.texto=texto;
    this.tipo=tipo;
    this.valor=valor;
    }
    protected String  getTexto(){
        return this.texto;
    }
    protected TipoSorpresa getTipo(){
        return this.tipo;
    }
    protected int getValor(){
        return this.valor;
    }

    @Override
    public String toString(){
       return "Sorpresa{" + "texto =" + this.texto + ", valor= " + Integer.toString(this.valor)  + " tipo= " + this.tipo + "}\n\n"  ;
    }
    
}


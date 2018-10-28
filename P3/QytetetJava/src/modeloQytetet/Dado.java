/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloQytetet;

/**
 *
 * @author marquirj
 */
public class Dado {
    private static final Dado instance = new Dado();
    private int valor;
    int tirar(){
        return 21;
     }
    int getValor(){
        return this.valor;
    }
    private Dado(){}
    public static Dado getInstance() {
        return instance;
    }
}

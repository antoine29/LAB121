/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedex;

/**
 *
 * @author antoine
 */
public class Pokemon implements java.io.Serializable{
    
    private String nombre, tipo, imagen;
    
    public Pokemon(){}
    
    public Pokemon(String n, String t, String i){
        nombre=n;
        tipo=t;
        imagen=i;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getImagen() {
        return imagen;
    }
    
    public void mostrar(){
        System.out.println(nombre + " - " + tipo + imagen);
    }
    
    
    
    
    
    
    
}

// No olviden cambiar o borrar el package en sus proyectos
package prac5.pkg1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        
        Archivo archi = new Archivo("archivoMedico.dat");
        archi.crear();
        
        /*
        // Este bloque solo debe ser ejecutado en la 1ra ejecucion, si se ejecuta mas veces
        // el archivo agregara los mismos objetos una y otra vez.
        
        Medico m1 = new Medico("juan", "cod1", "odon");
        Medico m2 = new Medico("rodri", "cod2", "ciru");
        Medico m3 = new Medico("ruben", "987656DFE", "odon");
        Medico m4 = new Medico("juan", "cod1", "ciru");
        Medico m5 = new Medico("rodri", "cod2", "ofta");
        Medico m6 = new Medico("juan", "cod1", "radio");
        
        archi.adicionar(m1);
        archi.adicionar(m2);
        archi.adicionar(m3);
        archi.adicionar(m4);
        archi.adicionar(m5);
        archi.adicionar(m6);
        */
        
        System.out.println("Contenido del archivo : ");
        archi.listar();
        
        archi.medicosPorEspecialidad();
        
        System.out.println("---------------------------------");
        
        archi.medicosConMasDe2Esps();
        
        System.out.println("---------------------------------");
       
        archi.elimina("aaaa");
        
        archi.listar();
    }
}

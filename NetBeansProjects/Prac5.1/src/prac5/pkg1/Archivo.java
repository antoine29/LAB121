// No olviden cambiar o borrar el package en sus proyectos
package prac5.pkg1;

import java.io.*;

public class Archivo {
        
    private String nomArch; // Este es el nombre del archivo, pueden buscarlo en la carpeta del proyecto
    private Medico obj;     // Este es un archivo de objetos "Medico", cambiar para archs de otros objs. 
	
    public Archivo(String na) {
	this.nomArch = na;
    }
	
    public void crear()throws ClassNotFoundException, IOException{
        ObjectOutputStream archEs = null;
        try{
            File arch = new File(nomArch);  // Verificamos si el archivo existe
            if(!arch.exists()){
                archEs = new ObjectOutputStream(new FileOutputStream(nomArch));
                // Esta sentencia abre el archivo para SOBREESCRIBIR el contenido
                // Es decir que cada ves que ejecutamos esta sentencia, no escribimos al final sino desde el principio
                archEs.close();
            }
        }
        catch(Exception e){
            System.out.println("Error en la creacion del archivo");
        }	
    }
    
    public void listar()throws ClassNotFoundException, IOException{
        ObjectInputStream archEs=null;
        try {   
            archEs = new ObjectInputStream(new FileInputStream(nomArch));
            
            while(true){
                obj = new Medico();
                obj = (Medico)archEs.readObject();
                obj.mostrar();
            }
        } catch (Exception e) {
            System.out.print("\n FIN LISTADO : " + e.getMessage());
            System.out.println();
        }finally{
            archEs.close();
        }
    }

    // Los sgtes metodos son utiles para faciltaros el trabajo
    // Es mas facil trabajar con un vector de objetos que con un archivo!
    public int nroRegistrosEnArchivo()throws ClassNotFoundException, IOException{
        int c=0;
        ObjectInputStream archEs=null;
        try {
            archEs = new ObjectInputStream(new FileInputStream(nomArch));
            while(true){
                obj = new Medico();
                obj = (Medico)archEs.readObject();	
                c++;
            } 
        } catch (Exception e) {
            //System.out.print("\n ERROR AL CONTAR OBJETOS   " + e.getMessage());
        } finally{
            archEs.close();
            return c;
        }
    }

    public Medico[] archivoToVector()throws ClassNotFoundException, IOException{
        Medico vec[] = new Medico[this.nroRegistrosEnArchivo()];
        int i=0;
        ObjectInputStream archEs=null;
        try {
            archEs = new ObjectInputStream(new FileInputStream(nomArch));
            while(true){
                obj = new Medico();
                obj = (Medico)archEs.readObject();
                //obj.mostrar();
                vec[i] = obj; 
                i++;
            }
        } catch (Exception e) {
            //System.out.print("\n ERROR AL LLEVAR ARCHIVO TO VECTOR    " + e.getMessage());
        }finally{
            archEs.close();
            return vec;
        }
    }

    // Para adicionar un obj al archivo necesitamos antes vaciar el archivo a un vector (por lo de la sobreescritura)
    // Despues vaciamos el vector al archivo y el objeto p
    public void adicionar(Medico p)throws ClassNotFoundException, IOException{
        ObjectOutputStream archEs = null;
        try{
            Medico vec[] = this.archivoToVector();
            archEs = new ObjectOutputStream(new FileOutputStream(nomArch));	
            for (int i = 0; i < vec.length; i++) archEs.writeObject(vec[i]);
            archEs.writeObject(p);
            archEs.close();
        } catch(Exception e){
            System.out.print("\n FIN ADICIONA");
            System.out.print(e.getCause());
        }
    }
    
    // Para los sgtes metodos es mas facil trabajar con un vector contruido con el archivo
    // Es decir vaciamos el archivo a un vector y trabajamos con el vector
    public void medicosPorEspecialidad() throws ClassNotFoundException, IOException{
         
        // 1ro sacamos un vector con todos los medicos del archivo
        Medico vecMed[] = this.archivoToVector();
        
        // 2do sacamos todas las especialidades (sin repeticiones)
        String especialidades[] = new String[20];
        int nroEspes = 0;
        
        for(int i=0; i<vecMed.length; i++){
            
            boolean sw = true;
            for(int j=0; j<nroEspes; j++) if(vecMed[i].getEspecialidad().equals(especialidades[j])) sw = false;
            
            if(sw){
                especialidades[nroEspes] = vecMed[i].getEspecialidad();
                nroEspes++;
            }
        }
        
        // hasta aqui tengo un vector con las especialidades del archivo
        // ahora solo queda buscar las ccantidades
        
        for (int i = 0; i < nroEspes; i++){
            int cantidad = 0;
            for (int j = 0; j < vecMed.length; j++) if(especialidades[i].equals(vecMed[j].getEspecialidad())) cantidad++;
            System.out.println("total de " + especialidades[i] + " = " + cantidad);
        } 
    }
    
    public void medicosConMasDe2Esps() throws ClassNotFoundException, IOException{
        Medico vecMed[] = this.archivoToVector();
        
        // Hay que buscar si un medico tiene mas de 2 esps, un medico tiene un codigo unico
        // Entonces hay que buscar los codigos que se repitan mas de 2 veces.
        
        // saco los codigos sin repeticiones
        String codigos[] = new String[20];
        int nroCods = 0;
        for(int i=0; i<vecMed.length; i++){
            boolean sw = true;
            for(int j=0; j<nroCods; j++) if(vecMed[i].getCodMedico().equals(codigos[j])) sw = false;
            if(sw){
                codigos[nroCods] = vecMed[i].getCodMedico();
                nroCods++;
            }
        }
        
        // hasta aqi tengo un vector con los codigos sin repes
        // ahora solo queda ver si un cod tiene mas de 2 repes en el vector
        for (int i = 0; i < nroCods; i++) {
            
            // cuenta las repeticiones de un codigo
            int c = 0;
            for (int j = 0; j < vecMed.length; j++) if(codigos[i].equals(vecMed[j].getCodMedico())) c++;
            
            if(c>2){
                // busco y muestro al medico con codigos[i]
                for (int j = 0; j < vecMed.length; j++){
                     if(codigos[i].equals(vecMed[j].getCodMedico())){
                         System.out.println(vecMed[j].getNombre());
                         break; // para salir del for
                     }
                }
            }
        }
    }
    
    //elimina el objeto en la posicion i del archivo
    public void elimina(String x)throws ClassNotFoundException, IOException{

        Medico vec[] = this.archivoToVector();

        Medico vec2[] = new Medico[vec.length];
        int j=0;

        for (int i = 0; i < vec.length; i++) {
            if(!vec[i].getCodMedico().equals(x)){
                vec2[j] = vec[i];
                j++;
            } 
        }

        // hasta aqui tengo vec2[] sin el elemento a eliminar, es decir con posiciones en "null"
        // ahora debo reemplazar el contenido de vec2[] en el archivo
        ObjectOutputStream archEs = null;
        try{
            archEs = new ObjectOutputStream(new FileOutputStream(nomArch));	
            for (int i = 0; i < vec2.length; i++) if(vec2[i] != null) archEs.writeObject(vec2[i]);
            archEs.close();
        }catch(Exception e){
            System.out.print("\n FIN ADICIONA");
        }
    }
}

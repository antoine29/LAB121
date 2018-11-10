package pokedex;

import java.io.*;
import java.util.Scanner;

public class ArchivoPokemon {
    
	private String nomArch;
	private Pokemon est;
	
	public ArchivoPokemon(String na) {
		this.nomArch = na;
	}
	
	public void crear()throws ClassNotFoundException, IOException{
            try{
                File arch = new File(nomArch);
                if(!arch.exists()){
                    // Si no exsite el archivo
                    ObjectOutputStream archEs = new ObjectOutputStream(new FileOutputStream(nomArch));
                    
                    // Descomentar para adicionar unos pokemones 
                    this.adicionar(new Pokemon("pikachu", "electrico", "pk0.png"));
                    this.adicionar(new Pokemon("charmander", "fuego", "pk1.png"));
                    this.adicionar(new Pokemon("squarttle", "agua", "pk2.png"));
                    
                    archEs.close();
                }
            }
            catch(Exception e){
                System.out.println("Error en la creacion del archivo");
            }	
	}
        
        public void adicionar(Pokemon p) throws ClassNotFoundException, IOException{
		ObjectOutputStream archEs = null;
		try{
                    Pokemon vec[] = this.archivoToVector();
                    archEs = new ObjectOutputStream(new FileOutputStream(nomArch));	
                    for (int i = 0; i < vec.length; i++) archEs.writeObject(vec[i]);
                    archEs.writeObject(p);
                    
                    archEs.close();
		}catch(Exception e){
			System.out.print("\n FIN ADICIONA");
		}

	}
        
        public void listar()throws ClassNotFoundException, IOException{
		ObjectInputStream archEs=null;
		try {
			archEs = new ObjectInputStream(new FileInputStream(nomArch));
			while(true){
				est = new Pokemon();
				est = (Pokemon)archEs.readObject();
				est.mostrar();
			}
	
		} catch (Exception e) {
			System.out.print("\n FIN LISTADO    " + e.getMessage());
		}finally{
			archEs.close();
		}
	}
        
        public int nroRegistrosEnArchivo()throws ClassNotFoundException, IOException{
            int c=0;
            ObjectInputStream archEs=null;
		try {
			archEs = new ObjectInputStream(new FileInputStream(nomArch));
			while(true){
                            est = new Pokemon();
                            est = (Pokemon)archEs.readObject();	
                            c++;
                        } 
	
		} catch (Exception e) {
			//System.out.print("\n TERMINO DE CONTAR    " + e.getMessage());
		}finally{
			archEs.close();
                        return c;
		}
        }
        
        public Pokemon[] archivoToVector()throws ClassNotFoundException, IOException{
            Pokemon vec[] = new Pokemon[this.nroRegistrosEnArchivo()];
            int i=0;
            ObjectInputStream archEs=null;
		try {
			archEs = new ObjectInputStream(new FileInputStream(nomArch));
			while(true){
                            est = new Pokemon();
                            est = (Pokemon)archEs.readObject();
                            //est.mostrar();
                            vec[i] = est; 
                            i++;
                        }
	
		} catch (Exception e) {
			//System.out.print("\n FIN ARCHITOVEC    " + e.getMessage());
		}finally{
			archEs.close();
                        return vec;
		}
        }
        
        //elimina el registro i
        public void elimina(int indice)throws ClassNotFoundException, IOException{
        
            Pokemon vec[] = this.archivoToVector();
            
            Pokemon vec2[] = new Pokemon[vec.length-1];
            
            int j=0;
            
            for (int i = 0; i < vec.length; i++) {
                if(i!=indice){
                    vec2[j] = vec[i];
                    j++;
                } 
            }
            
            // hasta aqui tengo un vector sin el elemento a eliminar
            // ahora debo reemplzar el contenido del vector con el contenido del vector
            ObjectOutputStream archEs = null;
		try{
                    archEs = new ObjectOutputStream(new FileOutputStream(nomArch));	
                    for (int i = 0; i < vec2.length; i++) archEs.writeObject(vec2[i]);
                    
                    archEs.close();
		}catch(Exception e){
			System.out.print("\n FIN ADICIONA");
		}
        }
	
}

// No olviden cambiar o borrar el package en sus proyectos
package prac5.pkg1;

public class Medico implements java.io.Serializable{
    
    private String nombre, codMedico, especialidad;
    
    public Medico(){}
    
    public Medico(String n, String cm, String e){
        nombre = n;
        codMedico = cm;
        especialidad = e;
    }
    
    public void mostrar(){
        System.out.println("Medico: " + nombre + "\t" + codMedico + "\t" + especialidad);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodMedico() {
        return codMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
}

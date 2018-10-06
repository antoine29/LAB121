using System;

namespace HerenciaEjemploCsharp
{
	public class EntidadPublica : LugarDeTrabajo
	{
		protected int nroEmpleados, nroTareas;
		protected string [,]empleados = new string [50,3];
		protected string [,]tareas = new string [50,2];

		// donde :
		// empleados(nombre, ci, cargo)
		// tareas (nombreTarea, presupuesto)

		public EntidadPublica():base(){
			// constructor vacio sin empleados ni tareas ni nombre de LugarDeTrabajo
			// este construtor utiliza el superconstructor que no recibe parametros
			nroEmpleados = 0;
			nroTareas = 0;
		}

		// el parametro a define los atributos del constructor
		public EntidadPublica (string nombreTrab, int a):base(nombreTrab){
			// constructor en caso de a=1
			if (a == 1) {
				nroEmpleados = 2;
				empleados [0, 0] = "Juan";
				empleados [0, 1] = "12345";
				empleados [0, 2] = "Administrador"; 
				empleados [1, 0] = "Sonia";
				empleados [1, 1] = "111317";
				empleados [1, 2] = "RRH"; 

				nroTareas = 2;
				tareas[0,0] = "Contratar personal";
				tareas[0,1] = "5000";
				tareas[1,0] = "Alquilar oficinas";
				tareas[1,1] = "7000";
			}
			// constructor en caso de a=2
			if (a == 2) {
				nroEmpleados = 2;
				empleados [0, 0] = "Carlos";
				empleados [0, 1] = "67890";
				empleados [0, 2] = "Auditor"; 
				empleados [1, 0] = "Rodrigo";
				empleados [1, 1] = "23570";
				empleados [1, 2] = "Seguridad"; 

				nroTareas = 2;
				tareas [0, 0] = "Iniciar gestion";
				tareas [0, 1] = "1000";
				tareas [1, 0] = "Comprar implementos";
				tareas [1, 1] = "2500";
			}
			if(a!=1 && a!=2) {
				// constructor en caso de otro valor de a
				nroEmpleados = 0;
				nroTareas = 0;
			}
		}

		public int getNroEmpleados(){
			return nroEmpleados;
		}

		public string[,] getEmpleados(){
			return empleados;
		}

		public void showEntidadPublica(){

			base.showLugarDeTrabajo ();

			Console.WriteLine (nroEmpleados + " empleados : ");
			for (int i = 0; i < nroEmpleados; i++)
				Console.WriteLine ("empleado : " + empleados [i, 0] + "\t" + empleados [i, 1] + "\t" + empleados [i, 2]);

			Console.WriteLine (nroTareas +" tareas : ");
			for (int i = 0; i < nroTareas; i++) Console.WriteLine ("tarea : " + tareas [i, 0] + "\t" + tareas [i, 1]);
		}

		public int getNroDeTareasConPresuMayorA(int x){
			int s = 0;
			for (int i = 0; i < nroTareas; i++) if (int.Parse (tareas [i, 1]) > x) s++;
			return s;
		}
	}
}


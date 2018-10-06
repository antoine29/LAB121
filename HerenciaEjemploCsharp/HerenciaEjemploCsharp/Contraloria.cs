using System;

namespace HerenciaEjemploCsharp
{
	public class Contraloria : EntidadPublica {
		private int nroDeclaracionesJuradas;
		private string [,]declaracionesJuradas = new string[50,3];

		//donde :
		// declaracionesJurdas (nombre, ci, sueldo)

		//el parametro a definira los datos del superconstructor EntidadPublica
		public Contraloria (string nom, int a):base(nom, a){

			// constructor con 2 declaraciones por defecto 
			nroDeclaracionesJuradas = 2;

			declaracionesJuradas[0, 0] = "Juan";
			declaracionesJuradas[0, 1] = "12345";
			declaracionesJuradas[0, 2] = "5000";
			declaracionesJuradas[1, 0] = "Carlos";
			declaracionesJuradas[1, 1] = "67890";
			declaracionesJuradas[1, 2] = "3000";

		}

		public void showContraloria(){
			base.showEntidadPublica ();
			Console.WriteLine ("nro de declaraciones : " + nroDeclaracionesJuradas);
			for (int i = 0; i < nroDeclaracionesJuradas; i++)
				Console.WriteLine ("declaracion : " + declaracionesJuradas[i, 0] + "\t" + declaracionesJuradas[i,1] + "\t" + declaracionesJuradas[i,2]);

			Console.WriteLine ("\n");
		}

		public void buscaEmpleadosEnJuramentos(Ministerio m){

			string[,] empleadosAux = m.getEmpleados ();

			for (int i = 0; i < m.getNroEmpleados(); i++) {
				for (int j = 0; j < this.nroDeclaracionesJuradas ; j++)
					if (empleadosAux[i,0] == declaracionesJuradas [j, 0] && empleadosAux[i, 1] == declaracionesJuradas [j, 1])
						Console.WriteLine ("el empleado : " + empleadosAux[i, 0] + " " + empleadosAux[i, 1] + " realizo su juramento en la contraloria " + this.Nombre);
			}

		}
	}
}


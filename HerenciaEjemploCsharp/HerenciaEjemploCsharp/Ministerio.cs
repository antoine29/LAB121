using System;

namespace HerenciaEjemploCsharp
{
	public class Ministerio : EntidadPublica{
		private int nroProyectos;

		public Ministerio(){
			// contructor vacio
		}

		// los parametros nom y a son enviados al superconstructor con :base()
		// el parametro a definira los atributos del constructor de EntidadPublica
		public Ministerio (string nom, int a, int np):base(nom, a){
			nroProyectos = np;
		}

		public void showMinisterio(){
			base.showEntidadPublica ();
			Console.WriteLine ("nro de proyectos en el ministerio : " + nroProyectos);
			Console.WriteLine ("\n");
		}

		public void compara(Ministerio m, int x){
			if (this.getNroDeTareasConPresuMayorA (x) == m.getNroDeTareasConPresuMayorA (x))
				Console.WriteLine ("los ministerios tienen un nro igual de tareas con presup mayor a " + x);
			else {
				if(this.getNroDeTareasConPresuMayorA(x) > m.getNroDeTareasConPresuMayorA(x))
					Console.WriteLine(this.Nombre + " tiene mas tareas con presup mayor a " + x);
				else Console.WriteLine(m.Nombre + " tiene mas tareas con presup mayor a " + x);
			}
		}

	}
}


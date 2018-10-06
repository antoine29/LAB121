using System;

namespace HerenciaEjemploCsharp
{
	public class LugarDeTrabajo
	{
		protected string Nombre;

		public LugarDeTrabajo (){
			// constructor vacio
		}

		public LugarDeTrabajo (string n){
			Nombre = n;
		}

		public void showLugarDeTrabajo(){
			Console.WriteLine ("Lugar de trabajo : " + Nombre);
		}
	}
}


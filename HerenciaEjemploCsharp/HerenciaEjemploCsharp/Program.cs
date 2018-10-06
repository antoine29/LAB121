using System;

namespace HerenciaEjemploCsharp
{
	class MainClass
	{
		public static void Main (string[] args)
		{

			// a) instanciar 2 ministerios de manera distinta, un obj contraloria y mostrar datos

			Ministerio m1 = new Ministerio ("Min de salud", 1, 1);
			m1.showMinisterio ();

			Ministerio m2 = new Ministerio ("Min de gob", 2, 2);
			m2.showMinisterio ();

			Contraloria c1 = new Contraloria ("Contraloria central", 0);
			c1.showContraloria ();

			Console.WriteLine ("--------------------------");
			// b) Comparar 2 ministerios y mostrar que ministerio tiene mas tareas con presupuestos mayor a x

			m1.compara (m2, 3000);

			Console.WriteLine ("--------------------------");
			// c) Determinar que empleados del 1er ministerio realizaron su declaracion jurada en la contraloria

			c1.buscaEmpleadosEnJuramentos (m1);

		}
	}
}

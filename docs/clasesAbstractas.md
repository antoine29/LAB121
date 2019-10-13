# Clases abstractas en java

En java una clase abstracta es una clase "especial" en la cual solo se declaran los metodos que poseeran todas las clases que hereden de la clase abstracta. Cada  <br>
En la clase abstracta solo se declaran los nombres (y tipos en el caso de funciones) de los metodos que seran heredados y definidos despues en cada una de las subclases que hereden de la superclase abstracta.

#### Ejemplo con figuras geometricas 

La clase abstracta 'figuraGeometrica' define la funcion abstracta 'getArea()' note que que se define el tipo de dato a retornar pero no se define el cuerpo de la funcion, la definicion de la funcion abstracta se realizara en cada subclase que herede de la superclase abstracta.
```java
public abstract class figuraGeometrica {
	public abstract double getArea();
}
```

Las clases 'Circulo' y 'trianguloRectangulo' heredan de la superclase abstracta 'figuraGeometrica', por lo tanto estas clases deben definir los metodos abstractos heredados, caso contrario se presentaria un error de compilacion. <br>
Para definir los metodos heredados de clase abstracta utilzamos la palabra reservada '@Override' esta palabra reservada indica que el siguiente metodo es un metodo abstracto heredado y no debe agregarse a otros metodos propios de la subclase. 

```java
public class Circulo extends figuraGeometrica {

	private double radio; 
	
	public Circulo(double r) {
		radio = r ;
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radio, 2) ;
	}	
}
```

```java
public class trianguloRectangulo extends figuraGeometrica {
	
	private double a, b;
	
	public trianguloRectangulo(double a0, double b0) {
		this.a = a0;
		this.b = b0;
	}
	
	@Override
	public double getArea() {
		return (0.5) * this.a * this.b;
	}
}

```
Para verificar el funcionamiento de las clases instanciemos un par de cada objeto 'Circulo' y 'trinaguloRectangulo', ademas de un vector de objetos del tipo 'figuraGeometrica'

```java
public class Main {

	public static void main(String[] args) {
		
		Circulo c1 = new Circulo(5);
		Circulo c2 = new Circulo(3);
		trianguloRectangulo t1 = new trianguloRectangulo(2, 3.5);
		trianguloRectangulo t2 = new trianguloRectangulo(4, 1.6);
		
		figuraGeometrica vec[] = new figuraGeometrica[20];
		
		vec[0] = c1;
		vec[1] = c2;
		vec[2] = t1;
		vec[3] = t2;
		
		for(int i=0;i<4;i++){
			System.out.println("area : "+ vec[i].getArea());
		}
	}
}
```
Ya que las clases 'Circulo' y 'trianguloRectangulo' heredan de 'figuraGeometrica' se puede decir que los objetos del tipo 'Circulo' y 'trianguloRectangulo' tambien son objetos del tipo 'figuraGeometrica', es por eso que podemos declarar un vector de 'figuraGeometrica' y almacenar en el objetos 'Circulo' y 'trianguloRectangulo'.<br>
El resultado de la ejecucion del programa sera la impresion de las areas de todas las figuras geometricas en el vector (con cada area calculada correspondientemente al tipo de figuraGeometrica)

```java
area : 78.53981633974483
area : 28.274333882308138
area : 3.5
area : 3.2
```
Hasta aqui logramos calcular de manera distinta el area de cada circulo o trianguloRectangulo en el vector y mostrar los resultados. <br> ¿como podriamos saber de que objeto estamos mostrando su area?<br>
¿como podriamos obtener el nombre del objeto del cual estamos calculando el area?<br>
Para obtener estos datos utilizaremos los metodos : 

- **getClass()**: que devuelve la clase de un objeto
- **getName()**: que devuelve el nombre (String) de una clase

```java
...
for(int i=0;i<4;i++){
	System.out.println("area del " + vec[i].getClass().getName() + " : "+vec[i].getArea());
} 
...
```
La ejecucion del bloque anterior generara:

```java
area del Circulo : 78.53981633974483
area del Circulo : 28.274333882308138
area del trianguloRectangulo : 3.5
area del trianguloRectangulo : 3.2
```
Es decir que ademas de calcular el area de cada elemento en el vector estamos mostrando el nombre de la clase de la cual el objeto es instancia.

Como el metodo 'getClass().getName()' retorna un String podemos comparar este resultado con otros String.

El siguiente bloque de codigo cuenta el numero objetos 'Circulo' que hay en el vector de 'figuraGeometrica'

```java
int s=0;
for(int i=0;i<4;i++) {
	if(vec[i].getClass().getName().equals("Circulo")) s++;
}
System.out.println("cantidad de objetos Circulo es : " + s);
```
```java
cantidad de objetos Circulo es : 2
```
<br>
<br>
<br>

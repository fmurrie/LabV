package Ejercicios;

public class Main
{

    public static void main(String[] args)
    {
        //Ejercicios:

        //Ejercicio 1:

        //1.A:
        Contenedor<Elemento> caja = new Contenedor<Elemento>();

        caja.agregarElemento(new Elemento("Elemento 1"));
        caja.agregarElemento(new Elemento("Elemento 2"));
        Elemento elementoAagregar1 = new Elemento("Elemento 4");
        caja.agregarElemento(elementoAagregar1);

        Elemento elementoAbuscar1 = new Elemento("Elemento 3");

        if (caja.contieneValor(elementoAbuscar1))
            System.out.println("Lo contiene.");
        else
            System.out.println("No lo contiene.");

        if (caja.contieneValor(elementoAagregar1))
            System.out.println("Lo contiene.");
        else
            System.out.println("No lo contiene.");

        //1.B:
        System.out.println("El elemento de maximo indice es: " + caja.devolverMaximo().getNombre());

        //1.C:
        System.out.println("El elemento de minimo indice es: " + caja.devolverMinimo().getNombre());

        //Ejercicio 2:
        Elemento eliminado = caja.eliminarYdevolver(caja.devolverMaximo());
        System.out.println("El elemento eliminado fue: " + eliminado.getNombre());

        //Ejercicio 3:
        Pila<Integer> pila=new Pila<Integer>();
        pila.push(1);
        pila.push(2);
        pila.push(3);

        System.out.println("El primer elemento es: " + pila.pop().getData());

        System.out.println("La cantidad de elementos en la pila es: " + pila.size());

    }
}

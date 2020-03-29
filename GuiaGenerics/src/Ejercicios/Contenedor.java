package Ejercicios;

import java.util.ArrayList;

public class Contenedor<T>
{
    //Atributos:
    private ArrayList<T> lista;

    //Constructores:
    public Contenedor()
    {
        this.lista=new ArrayList<T>();
    }

    public Contenedor(ArrayList<T> lista)
    {
        this.lista=lista;
    }

    //Getters:
    public ArrayList<T> getLista()
    {
        return lista;
    }

    //Setters:
    public void setLista(ArrayList<T> lista)
    {
        this.lista = lista;
    }

    //Metodos:
    public void agregarElemento(T element)
    {
        this.getLista().add(element);
    }

    public boolean contieneValor(Object obj)
    {
        boolean resultado=this.lista.contains(obj);

        return resultado;
    }

    public T devolverMaximo()
    {
        return this.lista.get(this.lista.size()-1);
    }

    public T devolverMinimo()
    {
        return this.lista.get(0);
    }

    public T eliminarYdevolver(T element)
    {
        T eliminado=element;
        this.lista.remove(element);
        return eliminado;
    }
}

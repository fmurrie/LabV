package Ejercicios;

public class Pila<T>
{
    //Atributos:
    private Nodo<T> nodo;
    private int size;

    //Constructores:
    public Pila()
    {
        this.nodo = new Nodo<T>();
        this.size = 0;
    }

    //Metodos:
    public void push(T data)
    {
        Nodo<T> value = new Nodo<T>(data);

        if (nodo == null)
            this.nodo = value;
        else
            this.nodo.next = value;

        size++;
    }

    public Nodo<T> pop()
    {
        return this.nodo.next;
    }

    public int size()
    {
        Nodo<T> value = new Nodo<T>();
        return this.size;
    }

}

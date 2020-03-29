package Ejercicios;

public class Nodo<T>
{
    //Atributos:
    private T data;
    public Nodo next;

    //Constructores:
    public Nodo()
    {

    }

    public Nodo(T data)
    {
        this.data = data;
    }

    //Getters y Setters:
    public T getData()
    {
        return data;
    }
}

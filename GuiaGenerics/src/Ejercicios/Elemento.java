package Ejercicios;

public class Elemento implements Comparable
{
    //Atributos:
    private String nombre;

    //Constructores:
    public Elemento()
    {

    }

    public Elemento(String nombre)
    {
        this.nombre = nombre;
    }

    //Getters:
    public String getNombre()
    {
        return nombre;
    }

    //Setters:
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    //Metodos:
    @Override
    public int compareTo(Object o)
    {
        int resultado=0;

        if(o instanceof Elemento)
        {
            Elemento parametro=(Elemento)o;
            resultado=this.nombre.compareTo(parametro.nombre);
        }

        return resultado;
    }
}

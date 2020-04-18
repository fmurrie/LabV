package models;

import interfaces.*;

public class Spartan extends Human implements Urinate, Drink
{
    public Spartan(String name, Integer age, Integer weight)
    {
        super(name, age, weight);
    }

    @Override
    public String Drink()
    {
        return "Drinks as a Spartan";
    }

    @Override
    public String Urinate()
    {
        return "Urinates as a Spartan";
    }

    @Override
    public String toString()
    {
        return "->Spartan<-\n"+super.toString();
    }
}

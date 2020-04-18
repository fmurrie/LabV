package models;

import interfaces.*;

public class Viking extends Human implements Urinate, Drink
{
    public Viking(String name, Integer age, Integer weight)
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
        return "->Viking<-\n"+super.toString();
    }
}

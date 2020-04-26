package Model;

import Interface.IAttack;
import Interface.IDefend;

public class Spartan extends Human
{
    //Constructors:
    public Spartan(Integer IdHumano, String Name, Integer Edad, Integer Peso,IAttack attack,IDefend defend)
    {
        super(IdHumano, Name, Edad, Peso,attack,defend);
    }

    public Spartan(String Name, Integer Edad, Integer Peso,IAttack attack,IDefend defend)
    {
        super(Name, Edad, Peso,attack,defend);
    }

    public Spartan(Integer IdHumano, String Name, Integer Age, Integer Weight)
    {
        super(IdHumano,Name,Age,Weight);
    }
}

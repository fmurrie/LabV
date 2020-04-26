package Model;

import Interface.IAttack;
import Interface.IDefend;

public class Viking extends Human
{
    //Constructors:
    public Viking(Integer IdHumano, String Name, Integer Edad, Integer Peso,IAttack attack,IDefend defend)
    {
        super(IdHumano, Name, Edad, Peso,attack,defend);
    }

    public Viking(String Name, Integer Edad, Integer Peso,IAttack attack,IDefend defend)
    {
        super(Name, Edad, Peso,attack,defend);
    }

    public Viking(Integer IdHumano, String Name, Integer Age, Integer Weight)
    {
        super(IdHumano,Name,Age,Weight);
    }
}

package Model;

import Interface.IAttack;
import Interface.IDefend;

public abstract class Human
{
    //Atributtes:
    private Integer IdHuman;
    private String Name;
    private Integer Age;
    private Integer Weight;
    public IAttack iattack;
    public IDefend idefend;

    //Constructors:
    public Human(Integer IdHumano, String Name, Integer Age, Integer Weight,IAttack iattack,IDefend idefend)
    {
        this.IdHuman = IdHumano;
        this.Name = Name;
        this.Age = Age;
        this.Weight = Weight;
        this.iattack =iattack;
        this.idefend =idefend;
    }

    public Human(String Name, Integer Age, Integer Weight,IAttack iattack,IDefend idefend)
    {
        this.Name = Name;
        this.Age = Age;
        this.Weight = Weight;
        this.iattack =iattack;
        this.idefend =idefend;
    }

    public Human(Integer IdHumano, String Name, Integer Age, Integer Weight)
    {
        this.IdHuman = IdHumano;
        this.Name = Name;
        this.Age = Age;
        this.Weight = Weight;
        this.iattack =iattack;
        this.idefend =idefend;
    }

    //Getters and Setters:
    public int getIdHuman()
    {
        return this.IdHuman;
    }

    public void setIdHuman(Integer idHuman)
    {
        this.IdHuman = idHuman;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public int getAge()
    {
        return this.Age;
    }

    public void setAge(Integer Age)
    {
        this.Age = Age;
    }

    public int getWeight()
    {
        return this.Weight;
    }

    public void setWeight(Integer Weight)
    {
        this.Weight = Weight;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = true;

        if (obj instanceof Human)
        {
            Human objValue = (Human) obj;
            if ((objValue.getIdHuman() != this.IdHuman) || (objValue.getName() != this.Name) || (objValue.getName() != this.Name) || (objValue.getAge() != this.Age) || (objValue.getWeight() != this.Weight))
            {
                result = false;
            }
        }
        else
        {
            result = false;
        }

        return result;
    }

}

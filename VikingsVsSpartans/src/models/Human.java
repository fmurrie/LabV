package models;

public abstract class Human implements Comparable<Human>
{
    private String Name;
    private Integer Age;
    private Integer Weight;


    public Human(String name, Integer age, Integer weight)
    {
        this.Name = name;
        this.Age = age;
        this.Weight = weight;
    }

    public String getName()
    {
        return Name;
    }

    public Integer getAge()
    {
        return Age;
    }

    public Integer getWeight()
    {
        return Weight;
    }

    @Override
    public String toString()
    {
        return "Name: "+this.Name+"\nAge: "+this.Age+"\nWeight: "+this.Weight;
    }

    @Override
    public int compareTo(Human o)
    {
        return this.Age.compareTo(o.getAge());
    }
}

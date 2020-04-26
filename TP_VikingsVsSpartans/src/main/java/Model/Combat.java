package Model;

import java.util.Date;

public class Combat
{
    private int IdCombat;
    private String DateCombat;
    private int FighterOne;
    private int FighterTwo;
    private String Winner;

    public Combat(Integer IdCombat, String DateCombat, int FighterOne, int FighterTwo, String Winner)
    {
        this.IdCombat=IdCombat;
        this.DateCombat=DateCombat;
        this.FighterOne=FighterOne;
        this.FighterTwo=FighterTwo;
        this.Winner=Winner;
    }

    public Combat(int FighterOne, int FighterTwo, String Winner)
    {
        this.FighterOne=FighterOne;
        this.FighterTwo=FighterTwo;
        this.Winner=Winner;
    }

    public int getIdCombat()
    {
        return IdCombat;
    }

    public void setIdCombat(int idCombat)
    {
        IdCombat = idCombat;
    }

    public String getDateCombat()
    {
        return DateCombat;
    }

    public void setDateCombat(String dateCombat)
    {
        DateCombat = dateCombat;
    }

    public int getFighterOne()
    {
        return FighterOne;
    }

    public void setFighterOne(int fighterOne)
    {
        FighterOne = fighterOne;
    }

    public int getFighterTwo()
    {
        return FighterTwo;
    }

    public void setFighterTwo(int fighterTwo)
    {
        FighterTwo = fighterTwo;
    }

    public String getWinner()
    {
        return Winner;
    }

    public void setWinner(String winner)
    {
        Winner = winner;
    }
}

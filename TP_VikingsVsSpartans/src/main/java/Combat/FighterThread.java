package Combat;

import Model.Human;

public class FighterThread extends Thread
{
    //Atributtes:
    private Human fighter;
    private static final int INITIAL_VITALITY=100;
    private int pointsVitality;
    private Combat combat;

    //Construct
    public FighterThread(Human fighter)
    {
        this.fighter=fighter;
    }

    //Getters and Setters:
    public int getPointsVitality()
    {
        return pointsVitality;
    }

    public void setPointsVitality(int pointsVitality)
    {
        this.pointsVitality = pointsVitality;
    }

    public void acceptCombat(Combat combat)
    {
        this.pointsVitality=this.INITIAL_VITALITY;
        this.combat=combat;
    }

    public int getFighterId()
    {
        return fighter.getIdHuman();
    }

    public String getFighterName()
    {
        return fighter.getName();
    }

    //Methods:
    @Override
    public void run()
    {
        while(!combat.getCombatEnd())
        {
            combat.fighterTurn(this);
        }
    }

    public int attack()
    {
        return fighter.iattack.Attack();
    }

    public int defend()
    {
        return fighter.idefend.Defend();
    }
}

package Combat;

import Controller.CombatController;

import static java.lang.Thread.sleep;

public class Combat
{
    public FighterThread fighterOne;
    public FighterThread fighterTwo;
    public boolean combatEnd;
    private boolean isTurnAvailable;
    public String winner;

    public boolean getCombatEnd()
    {
        return combatEnd;
    }

    public synchronized void fighterTurn(FighterThread fighter)
    {
        try
        {
            while (!isTurnAvailable)
            {
                wait();
            }
            if(!combatEnd)
            {
                this.isTurnAvailable = false;

                if (fighter == fighterOne)
                {
                    int pointsAttack = fighter.attack();
                    sleep(1000);
                    System.out.println("[" + fighter.getFighterName() + ": " + fighter.getPointsVitality() + "] attacks -" + pointsAttack);
                    sleep(1000);
                    int pointsDefend = fighterTwo.defend();
                    System.out.println("[" + fighterTwo.getFighterName() + ": " + fighterTwo.getPointsVitality() + "] defends +" + pointsDefend);
                    sleep(1000);
                    int pointsLess = ((pointsAttack - pointsDefend) < fighterTwo.getPointsVitality()) ? (pointsAttack - pointsDefend) : fighterTwo.getPointsVitality();
                    fighterTwo.setPointsVitality(fighterTwo.getPointsVitality() - pointsLess);
                }
                if (fighter == fighterTwo)
                {
                    int pointsAttack = fighter.attack();
                    sleep(1000);
                    System.out.println("[" + fighter.getFighterName() + ": " + fighter.getPointsVitality() + "] attacks -" + pointsAttack);
                    sleep(1000);
                    int pointsDefend = fighterOne.defend();
                    System.out.println("[" + fighterOne.getFighterName() + ": " + fighterOne.getPointsVitality() + "] defends +" + pointsDefend);
                    sleep(1000);
                    int pointsLess = ((pointsAttack - pointsDefend) < fighterOne.getPointsVitality()) ? (pointsAttack - pointsDefend) : fighterOne.getPointsVitality();
                    fighterOne.setPointsVitality(fighterOne.getPointsVitality() - pointsLess);
                }
                if ((fighterOne.getPointsVitality() <= 0) || (fighterTwo.getPointsVitality() <= 0))
                {
                    combatEnd = true;
                    if (fighterOne.getPointsVitality() <= 0)
                    {
                        System.out.println("\n\nCombat ended - The Winner is " + fighterTwo.getFighterName());
                        this.winner=fighterTwo.getFighterName();
                        saveFight();
                    }
                    if (fighterTwo.getPointsVitality() <= 0)
                    {
                        System.out.println("\n\nCombat ended - The Winner is " + fighterOne.getFighterName());
                        this.winner=fighterTwo.getFighterName();
                        saveFight();
                    }
                    this.isTurnAvailable = true;
                } else
                {
                    this.isTurnAvailable = true;
                    System.out.println("<----------Next-Turn---------->");
                }

            }
            notifyAll();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void startFight(FighterThread fighterOne, FighterThread fighterTwo)
    {
        this.combatEnd=false;
        this.isTurnAvailable=true;
        fighterOne.acceptCombat(this);
        fighterTwo.acceptCombat(this);
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;

        fighterOne.start();
        fighterTwo.start();
    }

    public void saveFight()
    {
        CombatController controller=new CombatController();
        controller.addCombat(this);
    }

}

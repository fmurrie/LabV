package com.company;

import Combat.Combat;
import Combat.FighterThread;
import Controller.HumanController;
import Interface.ImpIAttack.SpartanIAttack;
import Interface.ImpIAttack.VikingIAttack;
import Interface.ImpIDefend.*;
import Model.Human;
import Model.Spartan;
import Model.Viking;

import java.util.List;


public class Main
{
    public static void main(String[] args)
    {
        HumanController humanController=new HumanController();
        List<Human> humans=humanController.getHumans();

        FighterThread fighterOne=null;
        FighterThread fighterTwo=null;

        int indexFighterOne= (int) (Math.random() * humans.size());
        int indexFighterTwo=(int) (Math.random() * humans.size());

        while(indexFighterOne==indexFighterTwo)
        {
            indexFighterTwo=(int) (Math.random() * humans.size());
        }

        if(humans.get(indexFighterOne) instanceof Viking)
        {
            humans.get(indexFighterOne).iattack=new VikingIAttack();
            humans.get(indexFighterOne).idefend=new VikingIDefend();
            fighterOne=new FighterThread(humans.get(indexFighterOne));
        }

        if(humans.get(indexFighterOne) instanceof Spartan)
        {
            humans.get(indexFighterOne).iattack=new SpartanIAttack();
            humans.get(indexFighterOne).idefend=new SpartanIDefend();
            fighterOne=new FighterThread(humans.get(indexFighterOne));
        }

        if(humans.get(indexFighterTwo) instanceof Viking)
        {
            humans.get(indexFighterTwo).iattack=new VikingIAttack();
            humans.get(indexFighterTwo).idefend=new VikingIDefend();
            fighterTwo=new FighterThread(humans.get(indexFighterTwo));
        }

        if(humans.get(indexFighterTwo) instanceof Spartan)
        {
            humans.get(indexFighterTwo).iattack=new SpartanIAttack();
            humans.get(indexFighterTwo).idefend=new SpartanIDefend();
            fighterTwo=new FighterThread(humans.get(indexFighterTwo));
        }


        Combat combat=new Combat();
        combat.startFight(fighterOne,fighterTwo);
    }
}

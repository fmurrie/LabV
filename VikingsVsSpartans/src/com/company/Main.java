package com.company;

import models.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Human> vikings=new ArrayList<Human>();
        List<Human> spartans=new ArrayList<Human>();

        vikings.add(new Viking("Ragnar",150,50));
        vikings.add(new Viking("Gordon",40,10));
        vikings.add(new Viking("Popeye",60,80));

        spartans.add(new Spartan("Leonidas",20,70));
        spartans.add(new Spartan("Perseo",80,150));
        spartans.add(new Spartan("Aquiles",50,120));

        Collections.sort(vikings);
        Collections.sort(spartans);

        for(Human value : vikings)
        {
            System.out.println(value.toString());
            System.out.print("\n");
        }

        for(Human value : spartans)
        {
            System.out.println(value.toString());
            System.out.print("\n");
        }
    }

}

package com.company;

public class BeerThread extends Thread
{
    private int amountSons;

    public BeerThread(String name)
    {
        super(name);
        this.amountSons = 0;
    }

    protected int getAmountSons()
    {
        return amountSons;
    }

    protected void setAmountSons(int amountSons)
    {
        this.amountSons = amountSons;
    }
}

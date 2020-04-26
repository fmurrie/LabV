package Interface.ImpIDefend;

import Interface.IDefend;

public class SpartanIDefend implements IDefend
{
    @Override
    public int Defend()
    {
        return (int)Math.floor(Math.random()*(4-(20+1))+(20));
    }
}

package Interface.ImpIDefend;

import Interface.IDefend;

public class VikingIDefend implements IDefend
{
    @Override
    public int Defend()
    {
        return (int)Math.floor(Math.random()*(4-(30+1))+(30));
    }
}

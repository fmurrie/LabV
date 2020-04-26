package Interface.ImpIAttack;

import Interface.IAttack;

public class VikingIAttack implements IAttack
{
    @Override
    public int Attack()
    {
        return (int)Math.floor(Math.random()*(5-(40+1))+(40));
    }
}
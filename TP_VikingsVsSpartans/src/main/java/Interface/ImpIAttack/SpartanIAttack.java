package Interface.ImpIAttack;

import Interface.IAttack;

public class SpartanIAttack implements IAttack
{
    @Override
    public int Attack()
    {
        return (int)Math.floor(Math.random()*(5-(50+1))+(50));
    }
}

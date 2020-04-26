package DAO;

public class SqlParameter
{
    private int position;
    private Object value;
    private boolean isOutput;

    public SqlParameter(int position,Object value,boolean isOutput)
    {
        this.position=position;
        this.value=value;
        this.isOutput=isOutput;
    }

    public int getPosition()
    {
        return position;
    }

    public Object getValue()
    {
        return value;
    }

    public boolean isOutput()
    {
        return isOutput;
    }
}

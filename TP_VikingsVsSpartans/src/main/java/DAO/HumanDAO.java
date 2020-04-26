package DAO;

import Model.Human;
import Model.Spartan;
import Model.Viking;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HumanDAO extends DataAccessObject<Human>
{
    @Override
    protected String ObjectDbName()
    {
        return super.ObjectDbName()+"Human";
    }

    public List<Human> readHumans(Connection conn) throws SQLException
    {
        List<Human> list=new ArrayList<Human>();
        connection = conn;
        String query=executeStoredProcedure(this.ObjectDbName()+"_Read");
        ResultSet result=executer.read(buildStatement(query));

        while(result.next())
        {
            Human value=null;
            if(result.getInt("FighterType")==1)
            {
                value=new Viking(result.getInt("IdHuman"),result.getString("Name"),result.getInt("Age"),result.getInt("Weight"));
            }
            if(result.getInt("FighterType")==2)
            {
                value=new Spartan(result.getInt("IdHuman"),result.getString("Name"),result.getInt("Age"),result.getInt("Weight"));
            }
            list.add(value);
        }

        return list;
    }

}

package DAO;

import Model.Combat;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


public class CombatDAO extends DataAccessObject<Combat>
{
    @Override
    protected String ObjectDbName()
    {
        return super.ObjectDbName()+"Combat";
    }

    public void addCombat(Combat combat, Connection conn) throws SQLException
    {
        connection = conn;
        String query=executeStoredProcedure(this.ObjectDbName()+"_Create ",3);
        ArrayList<SqlParameter> listParams=new ArrayList<SqlParameter>();
        listParams.add(createSqlParameter(1,combat.getFighterOne(),false));
        listParams.add(createSqlParameter(2,combat.getFighterTwo(),false));
        listParams.add(createSqlParameter(3,combat.getWinner(),false));
        executer.create(buildStatement(query,listParams));
    }

}

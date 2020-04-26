package Controller;

import Combat.Combat;
import DAO.CombatDAO;
import DAO.ConnectorBD;

import java.sql.Connection;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CombatController
{
    public void addCombat(Combat combat)
    {
        Connection conn=null;

        try
        {
            conn= ConnectorBD.OpenConnection();
            Model.Combat modelCombat=new Model.Combat(combat.fighterOne.getFighterId(),combat.fighterTwo.getFighterId(),combat.winner);
            CombatDAO combatDao=new CombatDAO();
            combatDao.addCombat(modelCombat,conn);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectorBD.CloseConnection();
        }
    }
}

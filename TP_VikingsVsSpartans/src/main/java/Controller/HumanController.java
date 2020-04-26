package Controller;

import DAO.ConnectorBD;
import DAO.HumanDAO;
import Model.Human;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HumanController
{
    public List<Human> getHumans()
    {
        List<Human> list=new ArrayList<Human>();
        Connection conn=null;

        try
        {
            conn= ConnectorBD.OpenConnection();
            HumanDAO humanDAO=new HumanDAO();
            list=humanDAO.readHumans(conn);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectorBD.CloseConnection();
        }

        return list;
    }
}

package Interface.ImpICrud;

import DAO.ConnectorBD;
import Interface.ICrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoICrud implements ICrud
{
    @Override
    public boolean create(PreparedStatement statement) throws SQLException
    {
        return this.executeUpdate(statement);
    }

    @Override
    public ResultSet read(PreparedStatement statement) throws SQLException
    {
        return this.executeQuery(statement);
    }

    @Override
    public boolean update(PreparedStatement statement) throws SQLException
    {
        return this.executeUpdate(statement);
    }

    @Override
    public boolean delete(PreparedStatement statement) throws SQLException
    {
        return this.executeUpdate(statement);
    }

    private boolean executeUpdate(PreparedStatement statement) throws SQLException
    {
        boolean result = false;
        int affected = 0;

        affected = statement.executeUpdate();
        if (affected != 0)
        {
            result = true;
        }

        return result;
    }

    private ResultSet executeQuery(PreparedStatement statement) throws SQLException
    {
        ResultSet resultSet = null;

        resultSet = statement.executeQuery();

        return resultSet;
    }

}

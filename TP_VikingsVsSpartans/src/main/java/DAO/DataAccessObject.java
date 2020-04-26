package DAO;

import Interface.ICrud;
import Interface.ImpICrud.DaoICrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public abstract class DataAccessObject<T>
{
    protected Connection connection = null;
    protected ICrud executer = new DaoICrud();

    protected String ObjectDbName()
    {
        return "tp_vikings_vs_spartans.";
    }

    protected SqlParameter createSqlParameter(int position, Object value, boolean isOutput)
    {
        return new SqlParameter(position, value, isOutput);
    }

    protected PreparedStatement buildStatement(String sqlQuery, List<SqlParameter> params) throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);

        for (SqlParameter parameter : params)
        {
            if (parameter.getValue() instanceof Integer)
            {
                statement.setInt(parameter.getPosition(), (Integer) parameter.getValue());
            }
            if (parameter.getValue() instanceof String)
            {
                statement.setString(parameter.getPosition(), (String) parameter.getValue());
            }
            if (parameter.getValue() instanceof Boolean)
            {
                statement.setBoolean(parameter.getPosition(), (Boolean) parameter.getValue());
            }
            if (parameter.getValue() instanceof Date)
            {
                statement.setDate(parameter.getPosition(), (Date) parameter.getValue());
            }
        }

        return statement;
    }

    protected PreparedStatement buildStatement(String sqlQuery) throws SQLException
    {
        return connection.prepareStatement(sqlQuery);
    }

    protected String executeStoredProcedure(String procedureName, int quantityParamsFirm)
    {
        return "CALL " + procedureName+" "+getProcedureFirm(quantityParamsFirm)+";";
    }

    protected String executeStoredProcedure(String procedureName)
    {
        return "CALL " + procedureName+";";
    }

    private String getProcedureFirm(int quantity)
    {
        String parametersFirm = (quantity > 0) ? "(" : "";

        for (int index = 0; index < quantity; index++)
        {
            if (index == 0)
            {
                parametersFirm = parametersFirm + "?";
            } else
            {
                parametersFirm = parametersFirm + ",?";
            }
        }
        parametersFirm = (quantity > 0) ? parametersFirm + ")" : "";

        return parametersFirm;
    }

}

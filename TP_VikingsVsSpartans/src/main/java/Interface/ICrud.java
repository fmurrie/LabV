package Interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ICrud
{
    boolean create(PreparedStatement statement) throws SQLException;
    ResultSet read(PreparedStatement statement) throws SQLException;
    boolean update(PreparedStatement statement) throws SQLException;
    boolean delete(PreparedStatement statement) throws SQLException;

}

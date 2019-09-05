package testjdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TestConneciton {

    public void check() {

        try {
            InitialContext ic = new InitialContext();
            //DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");
            DataSource ds = (DataSource) ic.lookup("jdbc/Library");
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TestConneciton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TestConneciton.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

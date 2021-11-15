import java.sql.SQLException;

public class Admin {
    Database db = Database.getInstance();
    public void logAdmin(String login, String password){
        String query = "select Password from administrator where Login = " + login;
        String db_password = null;
        try {
            db.rs = db.stmt.executeQuery(query);
            System.out.println("fwefwefwe");
            while (db.rs.next()) {
                db_password = db.rs.getString(1);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        finally {
            try { db.rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        assert db_password != null;
        if (db_password.equals(password)) {
            System.out.println("mar");
        }
    }
}

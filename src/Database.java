import java.sql.*;

public class Database {
    private static Database instance;
    private Connection myConnection;
    public static Statement stmt;
    public static ResultSet rs;
    private int size;

    private Database(){
        System.out.println("fwfwegqge");
        init();
    }

    public static Database getInstance(){
        if(instance == null ){
            instance = new Database();
        }
        return instance;
    }

    public void init()
    {
        try {
            myConnection= DriverManager.getConnection("jdbc:mysql://localhost/quality", "root", "admin");
            stmt = myConnection.createStatement();
//            getSize();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Successful!");
    }

    public Connection getMyConnection()
    {
        return myConnection;
    }

//    public int getSize() {
//        String query = "select count(*) from films";
//        int count = 0;
//
//        try {
//            rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                count = rs.getInt(1);
//                System.out.println("Total number of books in the table : " + count);
//            }
//            size = count;
//
//        } catch (SQLException sqlEx) {
//            sqlEx.printStackTrace();
//        } finally {
//            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
//        }
//        return size;
//    }

}

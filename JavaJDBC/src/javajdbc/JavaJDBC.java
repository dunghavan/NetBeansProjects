package javajdbc;

import java.sql.SQLException;

public class JavaJDBC {

    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            SQLServerConnUtils_JDBC.QueryDataExample();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        finally{
            //
        }
    }
    
}

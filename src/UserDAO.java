import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
 
public class UserDAO {
    
    private Connection conn=null;            
    private PreparedStatement pstmt=null;    
    private ResultSet rs=null;               
    
    public UserDAO(){
        try {
            String URL = "jdbc:oracle:thin:@localhost:1521:xe";
            String ID = "test";
            String PW = "1234";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(URL, ID, PW);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public int login(String ID, String PW) {
        String quary = "SELECT PW FROM MEMBER WHERE ID = ?";
        try {
            pstmt = conn.prepareStatement(quary);
            pstmt.setString(1, ID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                if(rs.getString(1).equals(PW))
                    return 1;    
                else
                    return 0; 
            }
            return -1;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -2; 
        
    }
}
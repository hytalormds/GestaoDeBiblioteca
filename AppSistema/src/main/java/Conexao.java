import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/BdBiblioteca";
    private static final String senha = "";
    private static final String usuario = "root";
    
    private static Connection conn;
    
    public static Connection getConexao(){
        try{
            if(conn == null){
               conn = DriverManager.getConnection(url, usuario, senha);
               return conn;
            }else{
                return conn;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

import Conecta.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class AppSistema {

    public static void main(String[] args) {
     Connection conexao = Conexao.getConexao();

        // Verifica se a conexão foi bem-sucedida
        if (conexao != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                // Fecha a conexão após o teste
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        } else {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
        }
    }
}

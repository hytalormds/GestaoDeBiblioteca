import java.sql.Connection;
import java.sql.PreparedStatement;

public class Autor {

    private int ID_Autor;
    private String nome;

    public Autor(int ID_Autor, String nome) {
        this.ID_Autor = ID_Autor;
        this.nome = nome;
    }

    public int getIdAutor() {
        return ID_Autor;
    }

    public void setIdAutor(int ID_Autor) {
        this.ID_Autor = ID_Autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /*Inserir dados no sistema*/
    public void cadastrarAutor(String nome) {
        String insertQuery = "INSERT INTO Autor(nome) VALUES(?)";

        try (Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement
                = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nome);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Autor cadastrado!");
            } else {
                System.out.println("Autor não cadastrado!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterarAutor(int ID_Autor, String nome) {
        String updateQuery = "UPDATE Autor SET nome = ? WHERE ID_Autor = ?";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement(updateQuery)){
            
            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, ID_Autor);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Autor Atualizado!");
            }else{
                System.out.println("Autor não atualizado!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /* Exclusão por id do autor cadastrado */
    public void excluirAutor(int ID_Autor) {
        String deleteQuery = "DELETE FROM Autor WHERE ID_Autor = ?";

        try (Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement
                = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, ID_Autor);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Autor excluido");
            } else {
                System.out.println("Autor não excluido");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

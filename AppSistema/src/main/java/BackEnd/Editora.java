package BackEnd;

import Conecta.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Editora {
    private int ID_Editora;
    private String nome;
    
    public Editora(int ID_Editora, String nome){
        this.ID_Editora = ID_Editora;
        this.nome = nome;
    }
    
    public int getIdEditora(){
        return ID_Editora;
    }
    
    public void setIdEditora (int ID_Editora){
        this.ID_Editora = ID_Editora;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public void cadastrarEditora(String nome){
        String insertQuery = "INSERT INTO Editora(nome) VALUES(?)";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement(insertQuery)){
                
            preparedStatement.setString(1, nome);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Editora cadastrada!");
            }else{
                System.out.println("Editora não cadastrado!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void alterarEditora(int ID_Editora, String nome){
        String updateQuery = "UPDATE Editora SET nome = ? WHERE ID_Editora";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement(updateQuery)){
            
            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, ID_Editora);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Editora atualizada!");
            }else{
                System.out.println("Editora não atualizada");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void excluirEditora(int ID_Editora){
        String deleteQuery = "DELETE FROM Editora WHERE ID_Editora = ?";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement(deleteQuery)){
            
            preparedStatement.setInt(1, ID_Editora);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Editora excluida!");
            }else{
                System.out.println("Editora não excluida!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

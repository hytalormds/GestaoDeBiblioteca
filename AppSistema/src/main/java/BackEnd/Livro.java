package BackEnd;

import Conecta.Conexao;
import BackEnd.Editora;
import BackEnd.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Livro {
    private int ID_Livro;
    private String Titulo;
    private int Ano_Publicacao;
    private String Status;
    
    private Autor autor;
    private Editora editora;
    
    public Livro(int ID_Livro, String Titulo, int Ano_Publicacao, String Status, Autor autor, Editora editora){
        this.ID_Livro = ID_Livro;
        this.Titulo = Titulo;
        this.Ano_Publicacao = Ano_Publicacao;
        this.Status = Status;
        this.autor = autor;
        this.editora = editora;
    }
    
    public int getIdLivro(){
        return ID_Livro;
    }
    
    public void setIdLivro(int ID_Livro){
        this.ID_Livro = ID_Livro;
    }
    
    public String getTitulo(){
        return Titulo;
    }
    
    public void setTitulo(String Titulo){
        this.Titulo = Titulo;
    }
    
    public int getAnoPublicacao(){
        return Ano_Publicacao;
    }
    
    public void setAnoPublicacao(int Ano_Aublicacao){
        this.Ano_Publicacao = Ano_Publicacao;
    }
    
    public String getStatus(){
        return Status;
    }
    
    public void setStatus(String Status){
        this.Status = Status;
    }
    
    public Autor getAutor(){
        return autor;
    }
    
    public void setAutor(Autor autor){
        this.autor = autor;
    }
    
    
    public void cadastrarLivro(String Titulo, int Ano_Publicacao, String Status, Autor autor, Editora editora){
        String insertQuery = "INSERT INTO Livros(Titulo, Ano_Publicacao, Status, ID_Autor, ID_Editora) VALUES(?, ?, ?, ?, ?)";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement (insertQuery)){
            
            preparedStatement.setString(1, Titulo);
            preparedStatement.setInt(2, Ano_Publicacao);
            preparedStatement.setString(3, Status);
            preparedStatement.setInt(4, autor.getIdAutor());
            preparedStatement.setInt(5, editora.getIdEditora());
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Livro cadastrado!");
            }else{
                System.out.println("Livro não excluido!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void alterarLivro(int ID_Livro, String Titulo, int Ano_Publicacao, String Status, Autor autor, Editora editora){
        String updateQuery = "UPDATE Livros SET Titulo = ?, Ano_Publicacao = ?, Status = ?, ID_Autor = ?, ID_Editora = ? WHERE ID_Livro = ?";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement(updateQuery)){
            
            preparedStatement.setString(1, Titulo);
            preparedStatement.setInt(2, Ano_Publicacao);
            preparedStatement.setString(3, Status);
            preparedStatement.setInt(4, autor.getIdAutor());
            preparedStatement.setInt(5, editora.getIdEditora());
            preparedStatement.setInt(6, ID_Livro);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Livro atualizado!");
            }else{
                System.out.println("Livro não atualizado!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void excluirLivro(int ID_Livro){
        String deleteQuery = "DELETE FROM Livros WHERE ID_Livro = ?";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement(deleteQuery)){
            
            preparedStatement.setInt(1, ID_Livro);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Livro excluido!");
            }else{
                System.out.println("Livro não escluido!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String pesquisarLivro(String titulo){
        return titulo;
    }
}

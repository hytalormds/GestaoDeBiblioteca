import java.sql.Connection;
import java.sql.PreparedStatement;

public class Usuario {
    private int ID_Usuario;
    private String Nome;
    private String Email;
    private String Telefone;
    private int Idade;
    private String Sexo;
    
    private Endereco endereco;
    
    public Usuario(int ID_Usuario, String nome, String email, String telefone, int idade, String sexo, Endereco endereco){
        this.ID_Usuario = ID_Usuario;
        this.Nome = Nome;
        this.Email = Email;
        this.Telefone = Telefone;
        this.Idade = Idade;
        this.Sexo = Sexo;
        this.endereco = endereco;
    }
    
    public int getIdUsuario(){
        return ID_Usuario;
    }
    
    public void setIdUsuario(int ID_Usuario){
        this.ID_Usuario = ID_Usuario;
    }
    
    public String getNome(){
        return Nome;
    }
    
    public void setNome(String Nome){
        this.Nome = Nome;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    }
    
    public String getTelefone(){
        return Telefone;
    }
    
    public void setTelefone(String Telefone){
        this.Telefone = Telefone;
    }
    
    public int getIdade(){
        return Idade;
    }
    
    public void setIdade(){
        this.Idade = Idade;
    }
    
    public String getSexo(){
        return Sexo;
    }
    
    public void setSexo(String Sexo){
        this.Sexo = Sexo;
    }
    
    public Endereco getEndereco(){
        return endereco;
    }
    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public void cadastrarUsuario(String Nome, String Email, String Telefone, int Idade, String Sexo, Endereco endereco){
        String insertQuery = "INSERT INTO Usuario (Nome, Email, Telefone, Idade, Sexo, ID_Endereco) VALUES (?, ?, ?, ?, ?, ?)";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement(insertQuery)){
            
            preparedStatement.setString(1, Nome);
            preparedStatement.setString(2, Email);
            preparedStatement.setString(3, Telefone);
            preparedStatement.setInt(4, Idade);
            preparedStatement.setString(5, Sexo);
            preparedStatement.setInt(6, endereco.getIdEndereco());
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Usuario cadastrado!");
            }else{
                System.out.println("Usuario não cadastrado");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void alterarUsuario(String Nome, String Email, String Telefone, int Idade, String Sexo, Endereco endereco){
        
    }
    
    public void excluirUsuario(int ID_Usuario){
        String deleteQuery = "DELETE FROM Usuario WHERE Id_Usuario = ?";
        
        try(Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement 
                = connection.prepareStatement(deleteQuery)){
            
            preparedStatement.setInt(1, ID_Usuario);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Usuario excluido!");
            }else{
                System.out.println("Usuario não excluido!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String pesquisarUsuario(String nome){
        return nome;
    }
}

import java.util.Date;

public class Usuario {
    private int ID_Usuario;
    private String nome;
    private String email;
    private String telefone;
    private Date data_de_nascimento;
    private String sexo;
    
    private Endereco endereco;
    
    public Usuario(int ID_Usuario, String nome, String email, String telefone, Date data_de_nascimento, String sexo, Endereco endereco){
        this.ID_Usuario = ID_Usuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.data_de_nascimento = data_de_nascimento;
        this.sexo = sexo;
        this.endereco = endereco;
    }
    
    public int getIdUsuario(){
        return ID_Usuario;
    }
    
    public void setIdUsuario(int ID_Usuario){
        this.ID_Usuario = ID_Usuario;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public Date getDataDeNascimento(){
        return data_de_nascimento;
    }
    
    public void setDataDeNascimento(){
        this.data_de_nascimento = data_de_nascimento;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public Endereco getEndereco(){
        return endereco;
    }
    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public void cadastrarUsuario(String nome, String email, String telefone, Date data_de_nascimento, String sexo, Endereco endereco){
        
    }
    
    public void alterarUsuario(String nome, String email, String telefone, Date data_de_nascimento, String sexo, Endereco endereco){
        
    }
    
    public void excluirUsuario(int ID_Usuario){
        
    }
    
    public String pesquisarUsuario(String nome){
        return nome;
    }
}

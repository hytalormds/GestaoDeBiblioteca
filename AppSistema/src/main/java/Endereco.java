public class Endereco {
    private int ID_Endereco;
    private String rua;
    private int numero;
    private String referencia;
    
    public Endereco(int ID_Endereco, String rua, int numero, String referencia){
        this.ID_Endereco = ID_Endereco;
        this.rua = rua;
        this.numero = numero;
        this.referencia = referencia;
    }
    
    public int getIdEndereco (){
        return ID_Endereco;
    }
    
    public void setIdEndereco(int ID_Endereco){
        this.ID_Endereco = ID_Endereco;
    }
    
    public String getRua(){
        return rua;
    }
    
    public void setRua(String rua){
        this.rua = rua;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public String getReferencia(){
        return referencia;
    }
    
    public void setReferencia(String referencia){
        this.referencia = referencia;
    }
    
    public void cadastrarEndereco(String rua, int numero, String referencia){
        
    }
    
    public void alterarEndereco(String rua, int numero, String referencia){
        
    }
    
    public void excluirEndereco(int ID_Endereco){
        
    }
}

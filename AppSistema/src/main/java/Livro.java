public class Livro {
    private int ID_Livro;
    private String titulo;
    private int ano_publicacao;
    private String status;
    
    private Autor autor;
    private Editora editora;
    
    public Livro(int ID_Livro, String titulo, int ano_publicacao, String status, Autor autor, Editora editora){
        this.ID_Livro = ID_Livro;
        this.titulo = titulo;
        this.ano_publicacao = ano_publicacao;
        this.status = status;
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
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public int getAnoPublicacao(){
        return ano_publicacao;
    }
    
    public void setAnoPublicacao(int ano_publicacao){
        this.ano_publicacao = ano_publicacao;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public Autor getAutor(){
        return autor;
    }
    
    public void setAutor(Autor autor){
        this.autor = autor;
    }
    
    
    public void cadastrarLivro(String titulo, int ano_publicacao, String status, Autor autor, Editora editora){
        
    }
    
    public void alterarLivro(String titulo, int ano_publicacao, String status, Autor autor, Editora editora){
        
    }
    
    public void excluirLivro(int ID_Livro){
        
    }
    
    public String pesquisarLivro(String titulo){
        return titulo;
    }
}

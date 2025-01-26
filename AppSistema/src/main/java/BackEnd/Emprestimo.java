package BackEnd;

import Conecta.Conexao;
import BackEnd.Livro;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Emprestimo {

    private int ID_Emprestimo;
    private int ID_Usuario;
    private int ID_Livro;
    private Date Data_Emprestimo;
    private Date Data_Devolucao;
    private int Qtd_Livros;

    private Usuario usuario;
    private Livro livro;

    private Emprestimo(int ID_Emprestimo, int ID_Usuario, int ID_Livro, Date Data_Emprestimo, Date Data_Devolucao, int Qtd_Livros, Usuario usuario, Livro livro) {
        this.ID_Usuario = ID_Usuario;
        this.ID_Emprestimo = ID_Emprestimo;
        this.ID_Livro = ID_Livro;
        this.Data_Emprestimo = Data_Emprestimo;
        this.Data_Devolucao = Data_Devolucao;
        this.Qtd_Livros = Qtd_Livros;
        this.usuario = usuario;
        this.livro = livro;
    }

    public int getIdUsuario() {
        return ID_Usuario;
    }

    public void setIdUsuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public int getIdEmprestimo() {
        return ID_Emprestimo;
    }

    public void setIdEmprestimo(int ID_Emprestimo) {
        this.ID_Emprestimo = ID_Emprestimo;
    }

    public int getIdLivro() {
        return ID_Livro;
    }

    public void setIdLivro(int ID_Livro) {
        this.ID_Livro = ID_Livro;
    }

    public Date getDataEmprestimo() {
        return Data_Emprestimo;
    }

    public void setDataEmprestimo(Date Data_Emprestimo) {
        this.Data_Emprestimo = Data_Emprestimo;
    }

    public Date getDataDevolucao() {
        return Data_Devolucao;
    }

    public void setDataDevolucao(Date Data_Devolucao) {
        this.Data_Devolucao = Data_Devolucao;
    }

    public int getQtdLivros() {
        return Qtd_Livros;
    }

    public void setQtdLivros(int Qtd_Livros) {
        this.Qtd_Livros = Qtd_Livros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void cadastrarEmprestimo(Date Data_Emprestimo, Date Data_Devolucao, int Qtd_Livros, Usuario usuario, Livro livro) {
        String insertQuery = "INSERT INTO Emprestimo(Data_Emprestimo, Data_Devolucao, Qtd_Livros, ID_Usuario, ID_Livro) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement
                = connection.prepareStatement(insertQuery)) {

            preparedStatement.setDate(1, new java.sql.Date(Data_Emprestimo.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(Data_Devolucao.getTime()));
            preparedStatement.setInt(3, Qtd_Livros);
            preparedStatement.setInt(4, usuario.getIdUsuario());
            preparedStatement.setInt(5, livro.getIdLivro());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Emprestimo cadastrado!");
            } else {
                System.out.println("Emprestimo não cadastrado!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterarEmprestimo(int ID_Emprestimo, Date Data_Emprestimo, Date Data_Devolucao, int Qtd_Livros, Usuario usuario, Livro livro) {
        String updateQuery = "UPDATE Emprestimo SET Data_Emprestimo = ?, Data_Devolucao = ?, Qtd_Livros = ?, ID_Usuario = ?, ID_Livro = ? WHERE ID_Emprestimo = ?";

        try (Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setDate(1, new java.sql.Date(Data_Emprestimo.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(Data_Devolucao.getTime()));
            preparedStatement.setInt(3, Qtd_Livros);
            preparedStatement.setInt(4, usuario.getIdUsuario());
            preparedStatement.setInt(5, livro.getIdLivro());
            preparedStatement.setInt(6, ID_Emprestimo);  

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Empréstimo alterado!");
            } else {
                System.out.println("Empréstimo não atualizado!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirEmprestimo(int ID_Emprestimo) {
        String deleteQuery = "DELETE FROM Emprestimo WHERE Id_Emprestimo = ?";

        try (Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement
                = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, ID_Emprestimo);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Emprestimo excluido!");
            } else {
                System.out.println("Emprestimo não excluido!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public Date calcularEmprestimo(){
       return 
   }*/
    public int pesquisarEmprestimo(int ID_Emprestimo) {
        return ID_Emprestimo;
    }
}

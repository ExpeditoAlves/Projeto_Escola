package Classes;
import JDBC.*;
import java.sql.*;

public class Funcionario extends Pessoa{
    protected String login, senha,tipo_user,graduacao;
    protected final Connection logado ;

    public Funcionario(String nome, String login,String senha) {
        super(nome);
        this.login = login;
        this.senha = senha;
        this.logado = new Acesso_Banco().conecta();
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }
    
    public boolean efetuarLogin(String login, String senha){
        
        try {
            String sql = "select User_Tipo, User_Nome from usuario WHERE User_Login = ? and User_Senha = ?";
            
            PreparedStatement stmt = logado.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.first()){
                this.setTipo_user(rs.getString(1));
                this.setNome(rs.getString(2));
                rs.close();
                stmt.close();
                logado.close();
                return true;
            }     
        } 
        catch (SQLException e) { 
            throw new RuntimeException(" Erro ao Efetuar Login" + e);
        }
           return false;
    }
    
    public boolean cadastrar_funcionario(Funcionario fun, String nome){
        
        try {
            
            // 1ª Insere os dados na tabela USUÁRIO
            String sql = "INSERT INTO USUARIO (User_Nome,User_Login,User_Senha,User_Tipo) VALUES('"+fun.getNome()+"','"+fun.getLogin()+
                    "','"+fun.getSenha()+"','"+fun.getTipo_user()+"');";
            PreparedStatement stmt = logado.prepareStatement(sql);
            stmt.executeQuery(sql);
           
            if(fun.getTipo_user().equals("3")){ // se for professor tem que fazer a relação usuario -> professor
                
                //2ª RECUPERA O USER_ID DO ULTIMO USUÁRIO CRIADO
                sql = "select User_ID from usuario WHERE User_Login ='"+fun.getLogin()+"'";
                stmt = logado.prepareStatement(sql);
                ResultSet rst = stmt.executeQuery(sql);
                rst.first();
                int user_id = rst.getInt(1);

                // acha o User_ID do usuario que tá cadastrando
                sql = "select User_ID from usuario WHERE User_Login ='"+nome+"'";
                stmt = logado.prepareStatement(sql);
                rst = stmt.executeQuery(sql);
                rst.first();
                int user_inser = rst.getInt(1);            

                // 3ª INSERE O PROFESSOR E ATRIBUI O ÚLTIMO USUARIO CRIADO A ELE
                sql = "INSERT INTO PROFESSOR (Prof_CPF,Prof_RG,Prof_Email,Prof_Graduacao,ID_User,DT_Inser,HR_Inser,User_Inser,Status)"
                        + " VALUES('"+fun.getCPF()+"','"+fun.getRG()+"','"+fun.getEmail()+"','"+fun.getGraduacao()+"','"+user_id+"',CURDATE(),CURTIME(),"+user_inser+","+1+");";
                stmt = logado.prepareStatement(sql);
                stmt.setString(1, fun.getCPF());
                stmt.setString(2, fun.getRG());
                stmt.setString(3, fun.getEmail());
                stmt.setString(4, fun.getGraduacao());
                stmt.setInt(5, user_id); 
                stmt.execute(sql);

                // 4ª PEGA O ID DO ÚLTIMO PROFESSOR CRIADO

                sql = "select Prof_ID from PROFESSOR WHERE Prof_CPF ='"+fun.getCPF()+"' ;";
                stmt = logado.prepareStatement(sql);
                rst = stmt.executeQuery(sql);
                rst.first();
                int prof_id = rst.getInt(1);

                // 5ª ATUALIZA O ÚLTIMO USUÁRIO PARA QUE ELE RECEBA O ID DO ULTIMO PROFESSOR CRIADO
                sql = "UPDATE USUARIO SET ID_Prof = "+prof_id+" WHERE User_ID = "+user_id+" ;";
                stmt = logado.prepareStatement(sql);
                if(stmt.execute(sql)){
                    rst.close();
                    stmt.close();
                    logado.close();
                    return true;
                }
            }
            else
                return true;
        } 
        catch (SQLException e) {
                throw new RuntimeException(e);     
        }
        return false; 
    } 
}


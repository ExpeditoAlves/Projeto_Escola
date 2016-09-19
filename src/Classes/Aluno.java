package Classes;

import JDBC.Acesso_Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Aluno extends Pessoa{
    protected String Nome_pai,Nome_Mae;
    protected final Connection logado ;
    public Aluno(String Nome_pai, String Nome_Mae, String num, String RG, String CPF, String email, String nome, String logradouro) {
        super(num, RG, CPF, email, nome, logradouro);
        this.Nome_pai = Nome_pai;
        this.Nome_Mae = Nome_Mae;
        this.logado = new Acesso_Banco().conecta();
    }

    public String getNome_pai() {
        return Nome_pai;
    }

    public void setNome_pai(String Nome_pai) {
        this.Nome_pai = Nome_pai;
    }

    public String getNome_Mae() {
        return Nome_Mae;
    }

    public void setNome_Mae(String Nome_Mae) {
        this.Nome_Mae = Nome_Mae;
    }
    
    public boolean cadastrar_aluno(Aluno alu, String nome,String turma, String turno){

     try {

            // 1ª Recuperar O Turma_ID com os valores de passados no cadastro do aluno
            String sql = "SELECT Turma_ID FROM Turma WHERE Turma_Serie = '"+turma+
                       "' AND Turma_Turno = '"+turno+"' AND Turma_Ano =" +"EXTRACT(YEAR FROM CURDATE())"+";";
            PreparedStatement stmt = logado.prepareStatement(sql);
            ResultSet rst = stmt.executeQuery(sql);

            rst.first(); // verifica se há registros com as especificações passadas
            int turma_id = rst.getInt(1); // ID da TURMA

           //2ª Recuperar o ID_User de quem tá cadastrando no sistema 

            sql = "SELECT User_ID from usuario WHERE User_Login ='"+nome+"'";
            stmt = logado.prepareStatement(sql);
            rst = stmt.executeQuery(sql);
            rst.first();
            int user_inser = rst.getInt(1);  // ID de quem inseriu o registro

            //3ª CADASTRA OS PAIS DO ALUNO INFORMADO NO CADASTRO DO ALUNO

            sql = "INSERT INTO PAIS (Pais_Pai,Pais_Mae,Pais_Logradouro,Pais_num,DT_Inser,HR_Inser,User_Inser,Status)"
                         + " VALUES('"+alu.getNome_pai()+"','"+alu.getNome_Mae()+"','"+alu.getLogradouro()+"','"+alu.getNum()+
                          "',CURDATE(),CURTIME(),"+user_inser+","+1+");";
            stmt = logado.prepareStatement(sql);
            stmt.execute(sql);

            // 4ª RETORNA ID DOS PAIS CADASTRADOS

            sql = "SELECT Pais_ID FROM Pais WHERE Pais_Pai ='"+alu.getNome_pai()+"' AND Pais_Mae = '"+alu.getNome_Mae()+
                    "' AND Pais_Logradouro = '"+alu.getLogradouro()+"' AND Pais_num = '"+alu.getNum()+"';";
            stmt = logado.prepareStatement(sql);
            rst = stmt.executeQuery(sql);
            rst.first();
            int pais_id = rst.getInt(1);            

            // 5ª CADASTRA O ALUNO
            sql = "INSERT INTO ALUNO (Alu_Nome,Alu_RG,Alu_CPF,Alu_Email,ID_Turma,ID_Pais,DT_Inser,HR_Inser,User_Inser,Status)"
                    + " VALUES('"+alu.getNome()+"','"+alu.getRG()+"','"+alu.getCPF()+"','"+alu.getEmail()+"','"+turma_id+"','"+pais_id+"',CURDATE(),CURTIME(),"+user_inser+","+1+");";
            stmt = logado.prepareStatement(sql);
            if(stmt.execute(sql)){
                rst.close();
                stmt.close();
                logado.close();
                return true;
            }
         }
        catch (SQLException e) {
             throw new RuntimeException(e);     
        }
     return false; 
 } 

}

package Classes;

public class Pessoa {
    protected String num;
    protected String RG;
    protected String CPF;
    protected String email;
    protected String nome;
    protected String logradouro;


    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String num, String RG, String CPF, String email, String nome, String logradouro) {
        this.num = num;
        this.RG = RG;
        this.CPF = CPF;
        this.email = email;
        this.nome = nome;
        this.logradouro = logradouro;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    } 

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;


public class Tutor {
    private String nome;
    private LocalDate dtaNascimento;
    private String endereco;
    
    public Tutor(String nome, LocalDate dtaNascimento, String endereco){
        this.nome = nome; 
        this.dtaNascimento = dtaNascimento;
        this.endereco = endereco;
    }

    //getters
    public String getNome(){
        return nome;
    }
    public LocalDate getDtaNascimento(){
        return dtaNascimento;
    }
    public String getEndereco(){
        return endereco;
    }
    
    //setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDtaNascimento(LocalDate dtaNascimento){
        this.dtaNascimento = dtaNascimento;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

}

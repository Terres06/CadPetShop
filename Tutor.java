import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;


public class Tutor {
    private String nome;
    private LocalDate dtaNascimento;
    private String endereco;
    private int cod;
    
    private ArrayList<Pet> pets = new ArrayList<Pet>();

    //Construtor Tutor
    public Tutor(String nome, LocalDate dtaNascimento, String endereco, int cod){
        this.nome = nome; 
        this.dtaNascimento = dtaNascimento;
        this.endereco = endereco;
        this.cod = cod;
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
    public int getCod(){
        return cod;
    }
    public int getIdade(){
        LocalDate dataSistema = LocalDate.now();
        int idade = Period.between(dtaNascimento, dataSistema).getYears();
        return idade;
    }
    
    //setters
    public void incluiPet(String nome, String tipo){
        Pet pet = new Pet(nome, tipo);
        pets.add(pet);
    }

    //Gerador de string com todos os dados do tutor
    public String toString(){
        //Formata a data para o tipo BR dd/mm/yyyy
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String ts = String.format("Cod tutor: %d \n",cod);
        ts+=String.format("Nome..............: %s\n",nome);
        ts += String.format("Data de nascimento: %s (%d anos)\n", dtaNascimento.format(fmt), getIdade());
        ts+=String.format("Endereco..........: %s\n",endereco);
        ts+=String.format("Relação de pets...: \n");
        if (pets.size() == 0)
            ts += "Pets de " +nome+": Nenhum pet cadastrado.\n";
        else{
            for (Pet p: pets){
                ts+= "- Nome do pet: "+p.getNome()+", ";
                ts+= "Tipo: "+p.getTipo()+".\n";
            }
        } 
        return ts;
    }
}

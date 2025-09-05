public class Pet {
    private String nome;
    private String tipo;

    //Construtor Pet
    public Pet(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    } 
    //getters
    public String getNome(){
        return nome;
    }
    public String getTipo(){
        return tipo;
    }
}

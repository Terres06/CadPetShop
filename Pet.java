public class Pet {
    private String nome;
    private String tipo;

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

    //setters
    public void setNome(String nome){
        this.nome = nome;
    } 
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}

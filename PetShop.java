import java.time.LocalDate;
import java.util.ArrayList;

public class PetShop{
    private static ArrayList<Tutor> tut = new ArrayList<Tutor>();
    public static void main(String[] args) {
        
    }
    public static int geraCodTutor(){
        if(tut.size() == 0)
            return 1;
        else
            return tut.get(tut.size()-1).getCod()+1;
    }

    public static void popularCadastro(){
        Tutor t;
        //Gera tutor 1 
        int codTut = geraCodTutor();
        LocalDate dtaNascimento = LocalDate.of(2000,5,11);
        t = new Tutor("Joao Machado",dtaNascimento,"Rua Iapo 23",codTut);
        t.incluiPet("Rex", "Cachorro");
        tut.add(t);
        //Gera tutor 2 
        codTut = geraCodTutor();
        dtaNascimento = LocalDate.of(1994,3,22);
        t = new Tutor("Renata da Silva",dtaNascimento,"Av. das Alamedas",codTut);
        t.incluiPet("Loro José", "Papagaio");
        tut.add(t);
        //Gera tutor 3
        codTut = geraCodTutor();
        dtaNascimento = LocalDate.of(1940,10,23);
        t = new Tutor("Edson Arantes",dtaNascimento,"R. Princesa Isabel 20",codTut);
        t.incluiPet("Peixão", "Peixe");
        tut.add(t); 
    }
}
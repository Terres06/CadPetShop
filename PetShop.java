import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PetShop{
    private static ArrayList<Tutor> tut = new ArrayList<Tutor>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char opcao;
        popularCadastro();
        do{
            System.out.println("***** ESCOLHER UMA OPÇÃO *****");
            System.out.println("c: cadastrar tutor + pet(s)");
            System.out.println("i: imprimir cadastro");
            System.out.println("b: buscar pets por codigo tutor");
            System.out.println("e: excluir pets por codigo tutor");
            System.out.println("x: encerrar.");
            System.out.print("Opção escolhida: ");

            String input = scanner.nextLine().toLowerCase();
            opcao = input.isEmpty() ? ' ' : input.charAt(0);

            switch (opcao){
                case 'i':
                    imprimeTutor();
                case 'x':
                    System.out.println("Sistema de cadastro encerrado!");
                default:
                    System.out.println("Opcao invalida, digite novamente.");
                    break;
            }
            System.out.println();   

        }while (opcao != 'x');
        scanner.close();
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
    public static void imprimeTutor(){
        System.out.println("*** Cadastro de Tutor ***");
        for (Tutor t: tut)
            System.out.println(t.toString());
    }
}
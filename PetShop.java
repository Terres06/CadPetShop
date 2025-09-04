import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
                    break;
                case 'x':
                    System.out.println("Sistema de cadastro encerrado!");
                    break;
                default:
                    System.out.println("Opcao invalida, digite novamente.");
                    break;
            }
            System.out.println();   

        }while (opcao != 'x');
        scanner.close();
    }
    private static int geraCodTutor(){
        if(tut.size() == 0)
            return 1;
        else
            return tut.get(tut.size()-1).getCod()+1;
    }
    private static void popularCadastro(){
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
    private static void cadTutor(){
        Tutor t;
        int codTut = geraCodTutor();
        Scanner scanner = new Scanner(System.in);
        
        while (true){
            System.out.println("Digite o nome do tutor(a): (vazio encerra o programa)");
            String nome = scanner.nextLine();
            
            if (nome.isEmpty())
                break;
            }
            System.out.println("Digite a data nascimento do tutor(a) (dd/mm/yyyy): ");
            System.out.println("(separado por espacos)");
            LocalDate dtaNascimento = null;
            while(dtaNascimento == null){
                int dia = scanner.nextInt();
                int mes = scanner.nextInt();
                int ano = scanner.nextInt();
                scanner.nextLine();
                if(validaData(dia, mes, ano)){
                    dtaNascimento = LocalDate.of(ano, mes, dia);
                }else{
                    System.out.println("Data invalida, digite novamente.");
                }
            }
        scanner.close();
    }
    private static boolean validaData(int dia, int mes, int ano){
        if (ano <= 0) return false;
        if (mes < 1 || mes > 12) return false;
        int[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (mes == 2 && ehBissexto(ano)){
            diasMes[1] = 29;
        }

        if (dia < 1 || dia > diasMes [mes - 1]) return false;

        int idade = Period.between(LocalDate.of(dia, mes, ano), LocalDate.now()).getYears();
        if(idade - 18 <= 0) return false;

        return true;
    }

    private static boolean ehBissexto(int ano) {
        return (ano % 400 == 0) || 
               (ano % 4 == 0 && ano % 100 != 0);
    }

    private static void imprimeTutor(){
        System.out.println("*** Cadastro de Tutor ***");
        for (Tutor t: tut)
            System.out.println(t.toString());
    }
}
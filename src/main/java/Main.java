import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>(); // Cria uma lista de usuário para funcionar como um
        // mock-up do banco de dados.
        usuarios.add(new Usuario("PereiraGus", "gustavo.castro@sptech.school", "urubu100"));
        usuarios.add(new Usuario("lariSonoda","larissa.sonoda@sptech.school", "12345"));
        usuarios.add(new Usuario("anaLuizaB","ana.bueno@sptech.school","6789"));
        usuarios.add(new Usuario("AHY","alexandra.yara@sptech.school", "tubarão"));
        usuarios.add(new Usuario("teusCapellari", "mateus.afonso@sptech.school", "hrrp"));

        System.out.println("\n,-*'^'~*-.,_,.-*~*-.,_,.-*~'^'*-,,-*'^'~*-.,_,.-*~*-.,_,.-*~'^'*-,");
        System.out.println(",-*'^'~*-.,_,.-*~ Javasoft Network 🦋☕ - 2023© ~*-.,_,.-*~'^'*-,");
        System.out.println(",-*'^'~*-.,_,.-*~*-.,_,.-*~'^'*-,,-*'^'~*-.,_,.-*~*-.,_,.-*~'^'*-,\n");

        Usuario usuarioAtual = new Usuario(); // Cria um objeto de usuário e o autentica
        usuarioAtual.login(usuarios); // usando o método respectivo.

        Boolean sair = false;
        do{
            System.out.println(String.format("\n[!] Olá, %s seja bem-vindo(a) ao Javasoft Network!🦋☕",
                    usuarioAtual.username));
            System.out.println("--------------------------------");
            System.out.println(String.format("| 👤 - %s [Online 🟢] |",usuarioAtual.username));
            System.out.println("--------------------------------");

            Integer numAmigos = usuarioAtual.amigos.size(); // Calcula o número de amigos do usuário logado
            System.out.println(String.format("ℹ️ Sua lista de amigos [0|%d]",numAmigos));

            for (String amigo: usuarioAtual.amigos) { // Se tiver mais de 0, os lista
                System.out.println("|\t👤 - "+amigo+" [Offline 🔴]");
            }
            if(numAmigos == 0){ // Se não tiver nenhum, dá uma mensagem informativa
                System.out.println("\t[/!\\] Você não tem amigos ☹️");
            }

            String acao = ""; // Dá as opções de adicionar amigos ou sair ("A" ou "S")
            System.out.println("\n[?] Digite [A] para adicionar amigos ou [S] para sair.");
            do {
                acao = scan.nextLine();
            }while (!(acao.equals("A"))&&!(acao.equals("S"))); // Vai manter esse loop até selecionar uma das
            // operações válidas
            switch (acao){
                case "A":
                    usuarioAtual.adicionar(usuarios); // Se for "A", chama o método para adicionar amigos,
                    //enviado com o parâmetro de mock do banco.
                    break;
                case "S":
                    sair = true; // Se for "S", deixa true a variável que antes prendia o programa num loop
                    // que voltava ao menu inicial após qualquer operação.
            }
        }while(!sair);
        System.out.println("[!] Até a próxima!");
    }
}

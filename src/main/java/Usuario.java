import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    String username;
    String email;
    String senha;
    ArrayList<String> amigos = new ArrayList<>(); //Lista de usernames dos amigos deste usuário

    Usuario(){} //Contrutor vazio, para criar um usuário sem nenhum atributo definido
    Usuario(String pUsername, String pEmail, String pSenha){ //Construtor com username, email e senha,
        username = pUsername; // para criar usuários com dados predefinidos.
        email = pEmail;
        senha = pSenha;
    }

    void login(List<Usuario> usuarios){
        Usuario usuarioAtual = new Usuario();//Criando novo usuário
        Scanner scan = new Scanner(System.in);

        Boolean emailEncontrado = false;
        do{
            System.out.println("[?] Insira seu email:"); //Solicitando o email
            String loginEmail = scan.nextLine();

            for (Usuario usuario : usuarios) {
                if(usuario.email.equals(loginEmail)){ //Comparando o email informado com os emails de cada
                    emailEncontrado = true; // usuário registrado. Se achar, quebra o loop
                    usuarioAtual = usuario; // e usa esse usuário correspondente como base das próximas
                    break; // comparações.
                }
            }
            if(!emailEncontrado){ //Se um usuário com o email informado não for encontrado, acusa erro
                System.out.println("[/!\\] Email inválido\n");
            }
        }while(!emailEncontrado);

        Boolean senhaCorreta = false;
        do{
            System.out.println(String.format("[?] Insira a senha para %s:",usuarioAtual.email));
            String loginSenha = scan.nextLine(); // Comparação de senha com o usuário encontrado anteriomente

            if(usuarioAtual.senha.equals(loginSenha)){
                senhaCorreta = true;
                break;
            } else{
                System.out.println("[/!\\] A senha digitada não confere.\n");
            }
        } while(!senhaCorreta);
        // Só sai do loop após email e senhas validados
        username = usuarioAtual.username; // Quando sai, atribui os valores do usuário validado à
        email = usuarioAtual.email; // instância atual de usuário.
        senha = usuarioAtual.senha;
        amigos = usuarioAtual.amigos;
    }

    void adicionar(List<Usuario> usuarios){
        Scanner scan = new Scanner(System.in);

        System.out.println("\n[?] Digite o nome do usuário que você deseja adicionar");
        String termoDeBusca = scan.nextLine(); // Pedindo o nome do usuário que deseja adicionar
        Boolean usuarioEncontrado = false;

        for (Usuario resultado: usuarios) {
            if(termoDeBusca.equals(username)){ //Se for igual ao username do usuário logado, acusa erro e
                System.out.println("[/!\\] Não é possível adicionar a sí próprio."); // quebra o loop.
                usuarioEncontrado = true;
                break;
            }
            for(String amigoAtual: amigos){ // Vasculha os amigos atuais do usuário logado, para ver se o
                if(termoDeBusca.equals(amigoAtual)){ // usuário buscado já não está adicionado.
                    System.out.println(String.format("[/!\\] \"%s\" já está na sua lista de amigos.",amigoAtual));
                    usuarioEncontrado = true; // Se estiver, quebra o loop.
                }
            }
            if(resultado.username.equals(termoDeBusca)){ // Mas, se o FOR não caiu em nenhum loop anterior
                amigos.add(resultado.username); // e encontrar um usuário correspondente ao username informado,
                System.out.println(String.format("[!] %s adicionado(a) à sua lista de contatos com sucesso!",
                        resultado.username)); // adiciona ele à lista de amigos do usuário logado.
                usuarioEncontrado = true;
                break;
            }
        }
        if(!usuarioEncontrado){
            System.out.println(String.format("[/!\\] Não foi possível encontrar nenhum usuário de nome \"%s\"",termoDeBusca));
            // Se nenhum usuário foi encontrado com aquele username, acusa erro.
        }
    }
}

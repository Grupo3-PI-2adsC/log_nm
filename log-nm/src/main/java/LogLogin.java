import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class LogLogin {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputText = new Scanner(System.in);

        ValidacaoLogin validar = new ValidacaoLogin();
        Boolean validou;

        System.out.println("""
                ----------------------------------------
                |                                      |
                |           Digite o seu email:        |
                |                                      |
                ----------------------------------------""");

        String emailLogin = inputText.nextLine();

        System.out.println("""
                ----------------------------------------
                |                                      |
                |           Digite a sua senha:        |
                |                                      |
                ----------------------------------------""");
        String senhaLogin = inputText.nextLine();

        System.out.println("""
                ----------------------------------------
                |                                      |
                |        Confirmar a sua senha:        |
                |                                      |
                ----------------------------------------""");
        String confirmarSenhaLogin = inputText.nextLine();

        validou = validar.validarLogin(emailLogin, senhaLogin, confirmarSenhaLogin);
        registrarTentativaLogin(emailLogin, validou);

        if (validou) {
            Computador computador01 = new Computador();
            computador01.buscarInfos();
        }
    }

    private static void registrarTentativaLogin(String email, boolean sucesso) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter("log_login.txt", true))) {
            escritor.println("Data e Hora: " + new Date());
            escritor.println("Email: " + email);
            escritor.println("Resultado: " + (sucesso ? "Sucesso" : "Falha"));
            escritor.println();
            escritor.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ValidacaoLogin {
    public boolean validarLogin(String email, String senha, String confirmarSenha) {
        return senha.equals(confirmarSenha) && email.contains("@");
    }
}

class Computador {
    public void buscarInfos() {
        System.out.println("Buscando informações do computador...");
    }
}

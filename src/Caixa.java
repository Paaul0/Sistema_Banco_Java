import java.util.Scanner;

public class Caixa{
    private Scanner teclado;
    private String loginUsuario;
    private String senhaUsuario;
    private String titular;
    private String tipoConta;
    private int resposta;

    public Caixa(){
        this.teclado = new Scanner(System.in);
    }

    public void iniciar(){
        String mensagem;
        mensagem = """                 
                    Olá, oque Deseja?\n
                    1- Criar novos dados de login
                    2- Fazer login
                    3- Sair
                    """;
        System.out.println(mensagem);
        resposta = teclado.nextInt();
        if (resposta == 1){
            System.out.println("Digite seu nome completo: ");
            titular = teclado.next();

            System.out.println("Digite o tipo de conta \n" +
                    "1- Conta corrente \n" +
                    "2- Conta poupança");
            tipoConta = teclado.next();
            if (tipoConta.equals(1)){
                System.out.println("Conta corrente criada!");
                String contaC = "Corrente";
                tipoConta = contaC;
            } else {
                System.out.println("Conta poupança criada!");
                String contaP = "Poupança";
                tipoConta = contaP;
            }

            System.out.println("Digite seu login: ");
            loginUsuario = teclado.next();
            System.out.println("Digite sua senha: ");
            senhaUsuario = teclado.next();
            System.out.println("Usuário criado");
        } else if (resposta == 2) {
            if (loginUsuario.equals(null)) {
                System.out.println("Perfil ainda não foi criado!");

            }
        }



    }


}

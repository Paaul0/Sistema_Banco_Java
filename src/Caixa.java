import java.util.Scanner;

public class Caixa extends Conta {
    private Scanner teclado;
    private String login;
    private String senha;
    private String titular;
    private String tipoConta;
    private int resposta;
    private boolean acesso;

    public Caixa() {
        this.teclado = new Scanner(System.in);
    }

    public void executavel() {
        boolean loginBemSucedido = iniciar();
        if (loginBemSucedido) {
            operacao();
        }
        System.out.println("sessão finalizada!");
    }

    private boolean iniciar() {
        while (true) {
            boolean acesso = false;
            String mensagem;
            mensagem = """                 
                    Olá, oque Deseja?\n
                    1- Criar novos dados de login
                    2- Fazer login
                    3- Sair
                    """;
            System.out.println(mensagem);
            resposta = teclado.nextInt();
            teclado.nextLine();

            switch (resposta) {
                case 1:
                    criarPerfil();
                    break;

                case 2:
                    if (login == null) {
                        System.out.println("Nenhum perfil foi criado. Escolha outra opção!");
                        continue;
                    }
                    if (fazerLogin()) {
                        return true;
                    }
                    break;

                case 3:
                    System.out.println("Deixando Sistema...");
                    return false;

                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    private void criarPerfil() {
        System.out.println("Digite seu nome completo: ");
        titular = teclado.next();

        System.out.println("Digite seu login: ");
        String loginUsuario = teclado.next();
        login = loginUsuario;
        System.out.println("Digite sua senha: ");
        String senhaUsuario = teclado.next();
        senha = senhaUsuario;

        System.out.println("Digite o tipo de conta \n" + "1- Conta corrente \n" + "2- Conta poupança");
        tipoConta = teclado.next();
        if (tipoConta.equals("1")) {
            System.out.println("Conta corrente criada!");
            String contaC = "Corrente";
            tipoConta = contaC;
        } else if (tipoConta.equals("2")) {
            System.out.println("Conta poupança criada!");
            String contaP = "Poupança";
            tipoConta = contaP;
        } else {
            System.out.println("Opção inexistente. Tente novamente");
        }
    }

    private boolean fazerLogin() {
        System.out.println("Digite seu Login: ");
        String tentativaLogin = teclado.next();
        System.out.println("Digite sua senha: ");
        String tentativaSenha = teclado.next();

        if (tentativaLogin.equals(login) && tentativaSenha.equals(senha)) {
            System.out.println("Bem vindo, " + this.titular + "!");
            this.acesso = true;

        } else {
            System.out.println("Login ou Senha incorretos, tente novamente!");
            this.acesso = false;
        }
        return this.acesso;
    }

    private void operacao() {
        while (resposta != 4) {
            String menu;
            menu = """
                    ************************************ \n
                    Dados do cliente \n
                    Titular: %s\n
                    Conta: %s\n
                    Saldo: %d\n
                    ************************************ \n
                    Operações:\n
                    1- Sacar\n
                    2- Depositar\n
                    3- Sacar
                    """.formatted(titular,tipoConta,getSaldo());
            System.out.println(menu);
        }
    }
}








/*
import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner banco = new Scanner(System.in);
        int dados = 0;
        String login = "Não há";
        String senha = "";
        boolean loginFeito = false;
        String nomes = "Não há";
        String novaConta = "Não há";

        while (dados != 3) {
            String mensagem;
            mensagem = """
                    Olá, oque Deseja?\n
                    1- Criar novos dados de login
                    2- Fazer login
                    3- Sair
                    """;
            System.out.println(mensagem);
            dados = banco.nextInt();
            if (dados == 1) {
                System.out.println("Digite seu nome: ");
                String nomeSalvo = banco.next();
                nomes = nomeSalvo;

                System.out.println("Digite o tipo de conta que você deseja criar:\n" + "1- Conta corrente\n" + "2- Conta poupança");
                String contaSalva = banco.next();
                if (contaSalva.equals("1")){
                    System.out.println("Sua conta corrente foi criada!");
                    String contaC = "Corrente";
                    novaConta = contaC;
                } else {
                    System.out.println("Sua conta poupança foi criada!");
                    String contaP = "Poupança";
                    novaConta = contaP;
                }


                System.out.println("Digite seu novo login: ");
                String loginSalvo = banco.next();
                login = loginSalvo;
                System.out.println("Digite sua nova senha: ");
                String senhaSalva = banco.next();
                senha = senhaSalva;
                System.out.println("Usuário criado!");

            } else if (dados == 2) {
                if (login.equals("Não há")) {
                    System.out.println("Perfil ainda não foi criado!\n");
                    continue;
                }
                System.out.println("Digite seu Login: ");
                String tentativaDeLogin = banco.next();

                System.out.println("Digite sua senha: ");
                String tentativaDeSenha = banco.next();

                if (tentativaDeLogin.equals(login) && tentativaDeSenha.equals(senha)) {
                    System.out.println("Acesso concedido!\n");
                    loginFeito = true;
                    break;
                } else {
                    System.out.println("Acesso Negado. Login e senha incorretos.\n");
                }
            }
        }

        if (loginFeito) {

            int resposta = 0;
            String nome = "";
            String tipoConta = "";
            double saldo = 2500.00;
            while (resposta != 4) {
                System.out.println("*****************************");
                System.out.println("Dados do cliente");
                System.out.println("Nome :      " + nomes);
                System.out.println("Tipo de conta:      " + novaConta);
                System.out.println("Saldo inicial:      " + saldo);
                System.out.println("*****************************");
                System.out.println("Operações:");
                System.out.println("1- Consultar saldo");
                System.out.println("2- Depositar");
                System.out.println("3- Transferir");
                System.out.println("4- finalizar");
                System.out.println("Digite a opção  desejada:");
                resposta = banco.nextInt();
                if (resposta == 1) {
                    System.out.println("O saldo atual é: " + saldo);
                } else if (resposta == 2) {
                    System.out.println("Insira a quantidade que deseja depositar: ");
                    double deposito = banco.nextDouble();
                    double saldoD = deposito + saldo;
                    saldo = saldoD;
                    System.out.println("Seu saldo atual agpra é: " + saldoD);
                } else if (resposta == 3) {
                    System.out.println("Informe a quantidade que deseja Transferir: ");
                    double sacar = banco.nextDouble();
                    if (sacar <= saldo) {
                        double saldoS = saldo - sacar;
                        saldo = saldoS;
                        System.out.println("Seu saldo atual agora é: " + saldoS);
                    } else {
                        System.out.println("Operação invalida. Você não possui esse valor!");
                    }
                } else if (resposta == 4) {
                    System.out.println("Sessão finalizada!");
                } else {
                    System.out.println("Opção invalida. Tente alguma outra opção!");
                }
            }
        }
    }
}

 */
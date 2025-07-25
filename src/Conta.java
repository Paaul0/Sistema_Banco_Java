public class Conta { ;
    private double saldo;


    public Conta(String titular, String tipoConta, double saldo){
        this.saldo = saldo;
    }

    public void consultarSaldo(){
        System.out.println("Saldo atual: " + saldo);
    }

    public void depositar(double valor){
        valor = saldo;
        System.out.println("Deposito Efetuado!");
    }

    public void sacar(double saque){
        if (saque <= saldo){
            saldo -= saque;
            System.out.println("Saque de: " + saque + " Efetuado. Saldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente. Tente um valor menor!");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

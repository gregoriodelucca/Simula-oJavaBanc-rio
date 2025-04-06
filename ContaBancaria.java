import java.util.Scanner;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saque inválido ou saldo insuficiente.");
        }
    }

    public void verSaldo() {
        System.out.println("Saldo atual de " + titular + ": R$" + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do titular: ");
        String nome = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome);

        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ver saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> conta.verSaldo();
                case 2 -> {
                    System.out.print("Digite o valor para depositar: ");
                    double valor = scanner.nextDouble();
                    conta.depositar(valor);
                }
                case 3 -> {
                    System.out.print("Digite o valor para sacar: ");
                    double valor = scanner.nextDouble();
                    conta.sacar(valor);
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

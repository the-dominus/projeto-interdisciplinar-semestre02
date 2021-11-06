import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        boolean isRunning = true;

        while (isRunning) {
            try {

                clearScreen();
                initialScreen();

                char resposta = scanner.nextLine().charAt(0);

                switch (resposta) {
                case '1':
                    printClientes(scanner, clientes);
                    break;
                case '2':
                    printVeiculos(scanner);
                    break;
                case '3':
                    printPedidos(scanner);
                    break;
                case '4':
                    printSobre(scanner);
                    break;
                case '5':
                    isRunning = false;
                    break;
                default:
                    break;
                }

            } catch (Exception e) {
                System.out.println("\n\nVocê fez algo de errado!");
                System.out.println("\nMensagem do erro: " + e.getMessage());
            }
        }

        scanner.close();

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printTitle(String title) {
        System.out.println("************************** Concessionária Goiabinha **************************\n");
        System.out.println(title + "\n");
    }

    public static void printOptionsMenu() {
        System.out.println("[1] Cadastrar");
        System.out.println("[2] Alterar");
        System.out.println("[3] Consultar");
        System.out.println("[4] Excluir");
        System.out.println("[5] Voltar ao menu inicial");

        System.out.print("\nDigite a opção desejada: ");
    }

    public static void initialScreen() {
        String title = "# Tela inicial";

        printTitle(title);

        System.out.println("[1] Clientes");
        System.out.println("[2] Veículos");
        System.out.println("[3] Pedidos");
        System.out.println("[4] Informações do sistema");
        System.out.println("[5] Sair");

        System.out.print("\nDigite a opção desejada: ");
    }

    public static void printSobre(Scanner scanner) {
        clearScreen();

        String title = "# Sobre o sistema";
        printTitle(title);
        System.out.println("Esses são nossos desenvolvedores: ");
        System.out.println("Cleyson");
        System.out.println("Bruno");
        System.out.println("Lari");
        System.out.println("Lucas");
        System.out.println("Luigi");
        System.out.println("Rodrigo");

        printResultados("", scanner);

    }

    public static void printClientes(Scanner scanner, ArrayList<Cliente> clientes) {

        String title = "# Clientes";
        boolean isBack = true;

        while (isBack) {
            clearScreen();
            printTitle(title);
            printOptionsMenu();

            char resposta = scanner.nextLine().charAt(0);

            switch (resposta) {
            case '1':
                clearScreen();
                cadastraCliente(scanner, clientes);
                printResultados("Cliente cadastrado com sucesso do Rodrigão!", scanner);
                break;
            case '2':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Alterô", scanner);
                break;
            case '3':
                clearScreen();

                consultarClientes(scanner, clientes);

                // printResultados(message, scanner);
                break;
            case '4':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Excluíu", scanner);
                break;
            case '5':
                isBack = false;
                break;

            default:
                break;
            }
        }

    }

    public static void cadastraCliente(Scanner scanner, ArrayList<Cliente> clientes) {

        String title = "# Cadastro de cliente";
        clearScreen();
        printTitle(title);

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("E por fim, seu e-mail: ");
        String email = scanner.nextLine();

        Usuario cliente = new Cliente(nome, cpf, email);

        clientes.add((Cliente) cliente);

    }

    public static void consultarClientes(Scanner scanner, ArrayList<Cliente> clientes) {

        String title = "# Nossos clientes";
        clearScreen();
        printTitle(title);

        String message = "";
        for (int i = 0; i < clientes.size(); i++) {
            message += clientes.get(i).getNome() + "\n";
        }

        printResultados(message, scanner);
    }

    public static void printVeiculos(Scanner scanner) {

        String title = "# Veículos";
        boolean isBack = true;

        while (isBack) {
            clearScreen();
            printTitle(title);
            printOptionsMenu();

            char resposta = scanner.nextLine().charAt(0);

            switch (resposta) {
            case '1':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Cadastrô", scanner);
                break;
            case '2':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Alterô", scanner);
                break;
            case '3':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Consultô", scanner);
                break;
            case '4':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Excluíu", scanner);
                break;
            case '5':
                isBack = false;
                break;

            default:
                break;
            }
        }

    }

    public static void printPedidos(Scanner scanner) {

        String title = "# Pedidos";
        boolean isBack = true;

        while (isBack) {
            clearScreen();
            printTitle(title);
            printOptionsMenu();

            char resposta = scanner.nextLine().charAt(0);

            switch (resposta) {
            case '1':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Cadastrô", scanner);
                break;
            case '2':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Alterô", scanner);
                break;
            case '3':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Consultô", scanner);
                break;
            case '4':
                clearScreen();
                // Aqui vai a funcionalidade de cadastrar um pedido
                printResultados("Excluíu", scanner);
                break;
            case '5':
                isBack = false;
                break;

            default:
                break;
            }
        }

    }

    public static void printResultados(String message, Scanner scanner) {
        System.out.println(message);
        System.out.println("\nAperte qualquer tecla para voltar ao menu anterior");

        try {
            scanner.nextLine();
        } catch (Exception e) {
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            try {

                clearScreen();
                initialScreen();

                char resposta = scanner.nextLine().charAt(0);

                switch (resposta) {
                case '1':
                    printClientes(scanner);
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

    public static void printResultados(String message, Scanner scanner) {
        System.out.println(message);
        System.out.println("\nAperte qualquer tecla para voltar ao menu anterior");

        try {
            scanner.nextLine();

        } catch (Exception e) {
        }
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

    public static void printClientes(Scanner scanner) {

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
                cadastraCliente(scanner);
                printResultados("\n\nCliente cadastrado com sucesso!", scanner);
                break;
            case '2':
                clearScreen();
                alteraClientes(scanner);
                break;
            case '3':
                clearScreen();
                consultarClientes();
                printResultados("", scanner);
                break;
            case '4':
                clearScreen();
                excluiCliente(scanner);
                break;
            case '5':
                isBack = false;
                break;

            default:
                break;
            }
        }

    }

    public static void cadastraCliente(Scanner scanner) {
        String title = "# Cadastro de cliente";
        clearScreen();
        printTitle(title);

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("E por fim, seu e-mail: ");
        String email = scanner.nextLine();

        Usuario novoCliente = new Cliente(nome, cpf, email);

        clientes.add((Cliente) novoCliente);

        Cliente ultimoCliente = clientes.get(clientes.size() - 1);

        novoCliente.setId(ultimoCliente.getId() + 1);
    }

    public static void alteraClientes(Scanner scanner) {
        String title = "# Alteração de clientes";

        boolean foiAlterado = false;

        while (!foiAlterado) {
            clearScreen();
            printTitle(title);
            System.out.println("Digite o identificador do cliente para alterar: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    String infoCliente = cliente.toString();
                    System.out.println(infoCliente);

                    try {
                        System.out.println("Quais informações você deseja excluir?");
                        char resposta = scanner.nextLine().charAt(0);

                        switch (resposta) {
                        case '1':
                            System.out.print("\nDigite o novo valor: ");
                            String nome = scanner.nextLine();

                            cliente.setNome(nome);
                            foiAlterado = true;
                            printResultados("\n\nCliente alterado com sucesso!", scanner);
                            break;
                        case '2':
                            System.out.print("\nDigite o novo valor: ");
                            String email = scanner.nextLine();

                            cliente.setEmail(email);
                            foiAlterado = true;
                            printResultados("\n\nCliente alterado com sucesso!", scanner);
                            break;
                        case '3':
                            System.out.print("\nDigite o novo valor: ");
                            String senha = scanner.nextLine();

                            cliente.setSenha(senha);
                            foiAlterado = true;
                            printResultados("\n\nCliente alterado com sucesso!", scanner);
                            break;
                        case '4':
                            System.out.print("\nDigite o novo valor: ");
                            String cpf = scanner.nextLine();

                            cliente.setCpf(cpf);
                            foiAlterado = true;
                            printResultados("\n\nCliente alterado com sucesso!", scanner);
                            break;
                        case '5':
                            System.out.print("\nDigite o novo valor: ");
                            String endereco = scanner.nextLine();

                            cliente.setEndereco(endereco);
                            foiAlterado = true;
                            printResultados("\n\nCliente alterado com sucesso!", scanner);
                            break;

                        default:
                            break;
                        }
                    } catch (Exception e) {
                    }

                    break;
                }
            }

            if (!foiAlterado) {
                System.out.println("\n\nCliente não encontrado ou existem informações inválidas!");
                System.out.println("Deseja continuar? (S/N)");
                char resposta = scanner.nextLine().toUpperCase().charAt(0);

                if (resposta == 'N') {
                    break;
                }
            }
        }
    }

    public static void consultarClientes() {
        String title = "# Nossos clientes";
        printTitle(title);

        for (Cliente cliente : clientes) {
            cliente.imprimir();
        }
    }

    public static void excluiCliente(Scanner scanner) {
        String title = "# Exclusão de cliente";

        boolean foiExcluido = false;

        while (!foiExcluido) {
            clearScreen();
            printTitle(title);
            System.out.println("Digite o identificador do cliente para excluir: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    clientes.remove(cliente);
                    foiExcluido = true;

                    printResultados("\nCliente excluído com sucesso!", scanner);
                    break;
                }
            }

            if (!foiExcluido) {
                System.out.println("\n\nCliente não encontrado!");
                System.out.println("Deseja continuar? (S/N)");
                char resposta = scanner.nextLine().toUpperCase().charAt(0);

                if (resposta == 'N') {
                    break;
                }
            }
        }
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

}

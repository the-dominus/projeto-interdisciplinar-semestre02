import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {

    static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
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
        int id;

        if (clientes.size() == 0) {
            id = 1;
        } else {
            Cliente ultimoCliente = clientes.get(clientes.size() - 1);
            id = ultimoCliente.getId() + 1;
        }

        Usuario novoCliente = new Cliente(nome, cpf, email);
        novoCliente.setId(id);
        clientes.add((Cliente) novoCliente);
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
                        System.out.println("Quais informações você deseja alterar?");
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
                cadastraVeiculo(scanner);
                printResultados("Cadastro concluído!", scanner);
                break;
            case '2':
                clearScreen();
                alteraVeiculo(scanner);
                break;
            case '3':
                clearScreen();
                consultarVeiculos();
                printResultados("", scanner);
                break;
            case '4':
                clearScreen();
                excluiVeiculo(scanner);
                break;
            case '5':
                isBack = false;
                break;

            default:
                break;
            }
        }

    }

    public static void cadastraVeiculo(Scanner scanner) {

        String title = "# Cadastro de veículos";
        clearScreen();
        printTitle(title);

        System.out.println("Digite a marca do veículo: ");
        String marca = scanner.nextLine();
        System.out.println("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.println("Digite o preço do veículo: ");
        long preco = Long.parseLong(scanner.nextLine());
        System.out.println("Digite a cor do veículo: ");
        String cor = scanner.nextLine();
        System.out.println("Digite o ano do veículo: ");
        int ano = Integer.parseInt(scanner.nextLine()); // conversão

        String placa = "";

        System.out.println("O veículo possui placa? (S/N) ");
        char resposta = scanner.nextLine().toUpperCase().charAt(0);
        int id;

        if (veiculos.size() == 0) {
            id = 1;
        } else {
            Veiculo ultimoVeiculo = veiculos.get(veiculos.size() - 1);
            id = ultimoVeiculo.getId() + 1;
        }

        if (resposta == 'S') {
            System.out.println("Digite o número da placa: ");
            placa = scanner.nextLine();

            Veiculo novoVeiculo = new Veiculo(ano, preco, marca, modelo, cor, placa);
            veiculos.add(novoVeiculo);
            novoVeiculo.setId(id);
        } else {
            Veiculo novoVeiculo = new Veiculo(ano, preco, marca, modelo, cor);
            veiculos.add(novoVeiculo);
            novoVeiculo.setId(id);
        }

    }

    public static void consultarVeiculos() {
        String title = "# Nossos veículos";
        printTitle(title);

        for (Veiculo veiculo : veiculos) {
            veiculo.imprimir();
        }
    }

    public static void excluiVeiculo(Scanner scanner) {
        String title = "# Exclusão de veículo";

        boolean foiExcluido = false;

        while (!foiExcluido) {
            clearScreen();
            printTitle(title);
            System.out.println("Digite o identificador do veículo para excluir: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Veiculo veiculo : veiculos) {
                if (veiculo.getId() == id) {
                    veiculos.remove(veiculo);
                    foiExcluido = true;

                    printResultados("\nVeículo excluído com sucesso!", scanner);
                    break;
                }
            }

            if (!foiExcluido) {
                System.out.println("\n\nVeículo não encontrado!");
                System.out.println("Deseja continuar? (S/N)");
                char resposta = scanner.nextLine().toUpperCase().charAt(0);

                if (resposta == 'N') {
                    break;
                }
            }
        }
    }

    public static void alteraVeiculo(Scanner scanner) {
        String title = "# Alteração de veículos";

        boolean foiAlterado = false;

        while (!foiAlterado) {
            clearScreen();
            printTitle(title);
            System.out.println("Digite o identificador do veículo para alterar: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Veiculo veiculo : veiculos) {
                if (veiculo.getId() == id) {
                    String infoVeiculo = veiculo.toString();
                    System.out.println(infoVeiculo);

                    try {
                        System.out.println("Quais informações você deseja alterar?");
                        char resposta = scanner.nextLine().charAt(0);

                        switch (resposta) {
                        case '1':
                            System.out.print("\nDigite o novo valor: ");
                            int ano = Integer.parseInt(scanner.nextLine());

                            veiculo.setAno(ano);
                            foiAlterado = true;
                            printResultados("\n\nVeículo alterado com sucesso!", scanner);
                            break;
                        case '2':
                            System.out.print("\nDigite o novo valor: ");
                            long preco = Long.parseLong(scanner.nextLine());

                            veiculo.setPreco(preco);
                            foiAlterado = true;
                            printResultados("\n\nVeículo alterado com sucesso!", scanner);
                            break;
                        case '3':
                            System.out.print("\nDigite o novo valor: ");
                            String marca = scanner.nextLine();

                            veiculo.setMarca(marca);
                            foiAlterado = true;
                            printResultados("\n\nVeículo alterado com sucesso!", scanner);
                            break;
                        case '4':
                            System.out.print("\nDigite o novo valor: ");
                            String modelo = scanner.nextLine();

                            veiculo.setModelo(modelo);
                            foiAlterado = true;
                            printResultados("\n\nVeículo alterado com sucesso!", scanner);
                            break;
                        case '5':
                            System.out.print("\nDigite o novo valor: ");
                            String cor = scanner.nextLine();

                            veiculo.setCor(cor);
                            foiAlterado = true;
                            printResultados("\n\nVeículo alterado com sucesso!", scanner);
                            break;

                        case '6':
                            System.out.print("\nDigite o novo valor: ");
                            String placa = scanner.nextLine();

                            veiculo.setPlaca(placa);
                            foiAlterado = true;
                            printResultados("\n\nVeículo alterado com sucesso!", scanner);
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
                cadastraPedido(scanner);
                break;
            case '2':
                clearScreen();
                alteraPedido(scanner);
                break;
            case '3':
                clearScreen();
                consultarPedido();
                printResultados("", scanner);
                break;
            case '4':
                clearScreen();
                excluiPedido(scanner);
                break;
            case '5':
                isBack = false;
                break;

            default:
                break;
            }
        }

    }

    public static void cadastraPedido(Scanner scanner) {
        String title = "# Cadastro de pedido";
        clearScreen();
        printTitle(title);
        Cliente clienteSelecionado = null;
        ArrayList<Veiculo> veiculosSelecionados = new ArrayList<Veiculo>();

        try {
            while (clienteSelecionado == null) {
                System.out.println("Digite o ID do cliente: ");
                int idCliente = Integer.parseInt(scanner.nextLine());

                for (Cliente cliente : clientes) {
                    if (cliente.getId() == idCliente) {
                        clienteSelecionado = cliente;
                        break;
                    }
                }

                if (clienteSelecionado == null) {
                    printResultados("\nCliente selecionado não existe!\n", scanner);
                    clearScreen();
                    printTitle(title);
                }
            }

            while (true) {
                Veiculo veiculoSelecionado = null;

                while (veiculoSelecionado == null) {
                    System.out.println("Insira o ID do veículo: ");
                    int idVeiculo = Integer.parseInt(scanner.nextLine());

                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getId() == idVeiculo) {
                            veiculoSelecionado = veiculo;
                            break;
                        }
                    }
                    if (veiculoSelecionado == null) {
                        printResultados("\nVeículo selecionado não existe!\n", scanner);
                        clearScreen();
                        printTitle(title);
                    }
                }

                veiculosSelecionados.add(veiculoSelecionado);

                System.out.println("\nDeseja cadastrar mais algum veículo? (S/N)");
                char resposta = scanner.nextLine().toUpperCase().charAt(0);
                if (resposta == 'N') {
                    break;
                }
            }

            int id;

            if (pedidos.size() == 0) {
                id = 1;
            } else {
                Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);
                id = ultimoPedido.getId() + 1;
            }

            Pedido novoPedido = new Pedido(clienteSelecionado, veiculosSelecionados);
            novoPedido.setId(id);
            novoPedido.calcularTotalPedido();
            pedidos.add(novoPedido);

            printResultados("\n\nPedido cadastrado com sucesso!", scanner);
        } catch (Exception e) {
            printResultados("\nVocê digitou algo de errado!", scanner);
        }
    }

    public static void consultarPedido() {
        String title = "# Lista de pedidos";
        printTitle(title);

        for (Pedido pedido : pedidos) {
            pedido.imprimir();
        }
    }

    public static void excluiPedido(Scanner scanner) {
        String title = "# Exclusão de pedido";

        boolean foiExcluido = false;

        while (!foiExcluido) {
            clearScreen();
            printTitle(title);
            System.out.println("Digite o identificador do veículo para excluir: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Pedido pedido : pedidos) {
                if (pedido.getId() == id) {
                    pedidos.remove(pedido);
                    foiExcluido = true;

                    printResultados("\nPedido excluído com sucesso!", scanner);
                    break;
                }
            }

            if (!foiExcluido) {
                System.out.println("\n\nPedido não encontrado!");
                System.out.println("Deseja continuar? (S/N)");
                char resposta = scanner.nextLine().toUpperCase().charAt(0);

                if (resposta == 'N') {
                    break;
                }
            }
        }
    }

    public static void alteraPedido(Scanner scanner) {
        String title = "# Alteração de pedidos";

        boolean foiAlterado = false;

        while (!foiAlterado) {
            clearScreen();
            printTitle(title);
            System.out.println("Digite o identificador do pedido para alterar: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Pedido pedido : pedidos) {
                if (pedido.getId() == id) {
                    String infoPedido = pedido.toString();
                    System.out.println(infoPedido);

                    try {
                        System.out.println("Quais informações você deseja alterar?");
                        char resposta = scanner.nextLine().charAt(0);

                        switch (resposta) {
                        case '1':
                            Cliente clienteSelecionado = null;
                            while (clienteSelecionado == null) {
                                System.out.print("\nDigite o ID do novo cliente: ");
                                int idCliente = Integer.parseInt(scanner.nextLine());

                                for (Cliente cliente : clientes) {
                                    if (cliente.getId() == idCliente) {
                                        clienteSelecionado = cliente;
                                        break;
                                    }
                                }

                                if (clienteSelecionado == null) {
                                    printResultados("\nCliente selecionado não existe!\n", scanner);
                                    clearScreen();
                                    printTitle(title);
                                }
                            }

                            pedido.setCliente(clienteSelecionado);
                            foiAlterado = true;
                            printResultados("\n\nPedido alterado com sucesso!", scanner);
                            break;
                        case '2':
                            System.out.println("\nVocê deseja adicionar ou remover um veículo (A/R)?");
                            char opcao = scanner.nextLine().toUpperCase().charAt(0);

                            if (opcao == 'A') {
                                Veiculo veiculoSelecionado = null;
                                while (veiculoSelecionado == null) {
                                    System.out.print("\nDigite o ID do veículo: ");
                                    int idVeiculo = Integer.parseInt(scanner.nextLine());

                                    for (Veiculo veiculo : veiculos) {
                                        if (veiculo.getId() == idVeiculo) {
                                            veiculoSelecionado = veiculo;
                                            break;
                                        }
                                    }
                                    if (veiculoSelecionado == null) {
                                        printResultados("\nVeículo selecionado não existe!\n", scanner);
                                        clearScreen();
                                        printTitle(title);
                                    }
                                }

                                pedido.getVeiculos().add(veiculoSelecionado);
                                foiAlterado = true;
                                printResultados("\n\nPedido alterado com sucesso!", scanner);
                            } else if (opcao == 'R') {
                                clearScreen();
                                printTitle(title);

                                for (Veiculo veiculo : pedido.getVeiculos()) {
                                    System.out.println("[" + veiculo.getId() + "] " + veiculo.getNomeVeiculo());
                                }

                                Veiculo veiculoSelecionado = null;
                                while (veiculoSelecionado == null) {
                                    System.out.print("\nDigite o ID do veículo: ");
                                    int idVeiculo = Integer.parseInt(scanner.nextLine());

                                    for (Veiculo veiculo : pedido.getVeiculos()) {
                                        if (veiculo.getId() == idVeiculo) {
                                            veiculoSelecionado = veiculo;
                                            break;
                                        }
                                    }
                                    if (veiculoSelecionado == null) {
                                        printResultados("\nVeículo selecionado não existe!\n", scanner);
                                        clearScreen();
                                        printTitle(title);
                                    }
                                }

                                pedido.getVeiculos().remove(veiculoSelecionado);
                                foiAlterado = true;
                                printResultados("\n\nPedido alterado com sucesso!", scanner);
                            }

                            break;
                        case '3':
                            System.out.print("\nDigite um texto com a nova forma de pagamento: ");
                            String formaDePagamento = scanner.nextLine();

                            pedido.setFormaDePagamento(formaDePagamento);
                            foiAlterado = true;
                            printResultados("\n\nPedido alterado com sucesso!", scanner);
                            break;
                        case '4':
                            System.out.print("\nDigite o novo valor: ");
                            long totalPedido = Long.parseLong(scanner.nextLine());

                            pedido.setTotalPedido(totalPedido);
                            foiAlterado = true;
                            printResultados("\n\nPedido alterado com sucesso!", scanner);
                            break;
                        case '5':
                            System.out.print("\nFoi pago (S/N)? ");
                            char foiPago = scanner.nextLine().toUpperCase().charAt(0);

                            pedido.setPedidoFinalizado(foiPago == 'S');
                            foiAlterado = true;
                            printResultados("\n\nPedido alterado com sucesso!", scanner);
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
                System.out.println("\n\nPedido não encontrado ou existem informações inválidas!");
                System.out.println("Deseja continuar? (S/N)");
                char resposta = scanner.nextLine().toUpperCase().charAt(0);

                if (resposta == 'N') {
                    break;
                }
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

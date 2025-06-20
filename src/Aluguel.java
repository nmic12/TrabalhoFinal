import java.util.Scanner;

// Tá dando erro quando tu bota um codigo invalido no incluir cliente, ele só mostra o erro depois que tu tenta mostrar os clientes cadastrados

public class Aluguel {

    public static void menu(CadastroCliente cCliente, CadastroEquipamento cEquipamento) {
        Scanner cin = new Scanner(System.in);

        // Equipamento equipamento = new Equipamento(0, null, null, 0, 0);
        int option;

        do {
            System.out.println("1 - Incluir Cliente");
            System.out.println("2 - Mostrar clientes cadastrados");
            System.out.println("3 - Pesquisar cliente por nome");
            System.out.println("4 - Incluir equipamento");
            System.out.println("5 - Mostrar equipamentos");
            System.out.println("6 - Pesquisar equipamento por nome");
            System.out.println("7 - Retirar Equipamento");
            System.out.println("8 - Devolver Equipamento");
            System.out.println("9 - Mostrar quantidade total de equipamentos disponíveis");
            System.out.println("10 - Equipamento com maior demanda");
            System.out.println("11 - Sair");
            System.out.println();
            System.out.print("Digite a opção desejada: ");

            option = cin.nextInt();
            cin.nextLine();

            switch (option) {
                case 1:
                    // Incluir cliente
                    for (int i = 0; i < cCliente.cArr.length; i++) {
                        if (cCliente.cArr[i] == null) {
                            cCliente.cArr[i] = cCliente.addCliente();
                            // System.out.println("Cliente adicionado com sucesso na pos " + i);
                            System.out.println("Cliente: " + cCliente.cArr[i].toString()
                                    + " Adicionado com sucesso na posição " + i);
                            System.out.println();

                            break;
                            // return;
                        } else if (i == cCliente.cArr.length - 1) {
                            System.out.println("Não há mais espaço para adicionar clientes.");
                        }
                    }
                    // System.out.println("Não há mais espaço para adicionar clientes.");
                    break;
                case 2:
                    // Mostrar clientes
                    cCliente.mostrarClientes();
                    break;
                case 3:
                    cCliente.buscarClientePeloNome();
                    // Pesquisar cliente por nome
                    break;
                case 4:
                    // Incluir Equipamento
                    for (int i = 0; i < cEquipamento.eArr.length; i++) {
                        if (cEquipamento.eArr[i] == null) {
                            cEquipamento.eArr[i] = cEquipamento.addEquipamento(i + 1);
                            System.out.println("Equipamento adicionado com sucesso na pos " + i);
                            System.out.println("Equipamento:" + cEquipamento.eArr[i].getNome());
                            System.out.println();

                            break;
                        } else if (i == cEquipamento.eArr.length - 1) {
                            System.out.println("Não há mais espaço para adicionar equipamentos.");
                        }
                    }
                    break;
                case 5:
                    // Mostrar equipamentos
                    cEquipamento.mostrarEquipamentos();
                    break;
                case 6:
                    // Pesquisar equipamento por nome
                    cEquipamento.buscaEquipPeloNome();
                    break;
                case 7:

                    // arrumar
                    System.out.println("Deseja retirar o Equipamento por código ou por nome? (1 - Código, 2 - Nome)");
                    int escolha = cin.nextInt();
                    cin.nextLine(); // Limpa o buffer do teclado

                    if (escolha == 1) {
                        System.out.print("Insira o código do equipamento que deseja retirar: ");
                        int codigoEquipamento = cin.nextInt();
                        // cin.nextLine(); // Limpa o buffer do teclado
                        // Verifica se o código do equipamento existe
                        Equipamento equipamento = cEquipamento.buscaEquipPeloCodigo(codigoEquipamento);
                        if (equipamento != null) {
                            System.out.print("Quantos equipamentos deseja retirar: ");
                            int qntDesejada = cin.nextInt();
                            equipamento.retirar(qntDesejada);
                            System.out.println("Equipamento retirado com sucesso: " + equipamento.toString());
                        } else {
                            System.out.println("Equipamento não encontrado com o código: " + codigoEquipamento);
                        }

                        // Retirar equipamento
                    } else if (escolha == 2) {

                        Equipamento equipamento = cEquipamento.buscaEquipPeloNome();
                        if (equipamento != null) {
                            System.out.print("Quantos equipamentos deseja retirar: ");
                            int qntDesejada = cin.nextInt();
                            equipamento.retirar(qntDesejada);
                            System.out.println("Equipamento retirado com sucesso: " + equipamento.toString());
                        }
                        // Retirar equipamento
                    }
                    break;
                case 8:
                    // Devolver equipamento
                    // equipamento.devolver();
                    System.out.println("Deseja devolver o Equipamento por código ou por nome? (1 - Código, 2 - Nome)");
                    escolha = cin.nextInt();
                    cin.nextLine(); // Limpa o buffer do teclado
                    if (escolha == 1) {
                        System.out.print("Insira o código do equipamento que deseja devolver: ");
                        int codigoEquipamento = cin.nextInt();
                        // cin.nextLine(); // Limpa o buffer do teclado
                        // Verifica se o código do equipamento existe
                        Equipamento equipamento = cEquipamento.buscaEquipPeloCodigo(codigoEquipamento);
                        if (equipamento != null) {
                            equipamento.devolver();
                            System.out.println("Equipamento devolvido com sucesso: " + equipamento.toString());
                        } else {
                            System.out.println("Equipamento não encontrado com o código: " + codigoEquipamento);
                        }

                    } else if (escolha == 2) {

                        Equipamento equipamento = cEquipamento.buscaEquipPeloNome();
                        if (equipamento != null) {
                            equipamento.devolver();
                            System.out.println("Equipamento devolvido com sucesso: " + equipamento.toString());
                        }
                    }
                    
                    break;
                case 9:
                    cEquipamento.totalEquipamentos();
                    // Mostrar quantidade total de equipamentos disponiveis
                    break;
                case 10:
                    // Inovaçao - Ver o equipamento que está sendo mais alugado(mais demanda) dentre os clientes registrados
                    // Pega a array dos clientes, analisa um por um e vê qual codigo aparece mais
                    System.out.println();
                    break;
                case 11:
                    // Sair
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Por favor digite uma opção válida.");
                    break;
            }
        } while (option != 11);

        // cin.close();
    }

    public static void main(String[] args) {
        CadastroCliente cCliente = new CadastroCliente();
        CadastroEquipamento cEquipamento = new CadastroEquipamento();

        menu(cCliente, cEquipamento);

    }
}

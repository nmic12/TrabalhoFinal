import java.util.Random;
import java.util.Scanner;
import org.xml.sax.ErrorHandler;

public class CadastroCliente {
    // Array clientes
    Cliente[] cArr;

    public CadastroCliente() {
        cArr = new Cliente[10];
        // cArr[1] = new Cliente(421421, "Nicolas ", "Academia2", null);
    }

    Scanner teclado = new Scanner(System.in);

    // public Cliente addCliente(int matricula, String nome, String academia,
    // Equipamento dadosEquipamento){
    // System.out.print("Insira o nome do cliente: ");
    // String nomeCliente = teclado.next();
    // System.out.println();
    // System.out.print("Insira a academia do cliente: ");
    // String academiaCliente = teclado.next();
    // System.out.println();

    // return new Cliente(matricula, nomeCliente, academiaCliente,
    // dadosEquipamento);
    // }

    public Cliente addCliente() {
        CadastroEquipamento cEquipamento = new CadastroEquipamento();
        int matriculaCliente = new Random().nextInt(10000); // Corrigido: instanciar Random

        System.out.print("Insira o nome do cliente: ");
        String nomeCliente = teclado.nextLine();
        // System.out.println("{"+ nomeCliente +"}"); // debugging
        System.out.println();
        System.out.print("Insira a academia do cliente: ");
        String academiaCliente = teclado.nextLine();
        System.out.println();
        System.out.print("Insira o Codigo do Equipamento Alugado: ");
        int codigoEquipamento = teclado.nextInt();

        for (int i = 0; i < cEquipamento.eArr.length; i++) {
            if (cEquipamento.buscaEquipPeloCodigo(codigoEquipamento) == null) {
                System.out.println("Equipamento não encontrado. Tente novamente.");
                System.out.print("Insira o Codigo do Equipamento Alugado: ");
                codigoEquipamento = teclado.nextInt();
            } else {
                break; // Se o equipamento foi encontrado, sai do loop
            }
        }

        teclado.nextLine();

        Equipamento equipamento = cEquipamento.buscaEquipPeloCodigo(codigoEquipamento); // Busca o equipamento desejado
                                                                                        // pelo código
        if (equipamento != null) // verifica se o código do equipamento existe
        {
            if (equipamento.getQuantDispLocacao() > 1) // Verifica se ainda há uma quantidade disponível no estoque
            {
                System.out.println(
                        "Quanto deseja retirar do estoque? (Quantidade Disponível para locação do equipamento: "
                                + equipamento.getQuantDispLocacao() + ")");
                int qntDesejada = teclado.nextInt();
                equipamento.retirar(qntDesejada);

                System.out.print("Quantos dias você deseja alugar o equipamento? ");
                int dias = teclado.nextInt();
                teclado.nextLine(); // Limpa o buffer do teclado
                System.out.print("Você deseja adicionar seguro? (true/false): ");
                boolean seguro = teclado.nextBoolean();
                System.out.println("Equipamento alugado com sucesso, o Valor total ficou R$ "
                        + (equipamento.calcValorLocacao(dias, seguro) * qntDesejada));
            } else {
                System.out.println("O equipamento desejado está fora de estoque.");
            }
        }
        // cEquipamento.removeEquipamento(codigoEquipamento); // Remove o equipamento do
        // estoque

        return new Cliente(matriculaCliente, nomeCliente, academiaCliente, equipamento);
    }

    // Busca Cliente pelo nome
    public String buscarClientePeloNome() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Insira o nome do cliente: ");
        String nomeCliente = teclado.nextLine();

        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] != null && cArr[i].getNome().equalsIgnoreCase(nomeCliente)) {
                System.out.println("Cliente encontrado: " + cArr[i].toString());
                // return cArr[i].toString();
            } else if (cArr[i] == null) {
                continue; // Se o cliente não existir, continua para o próximo
            }
        }
        System.out.println("Cliente não encontrado.");
        return null;
    }

    public void mostrarClientes() {
        int countClientes = 0;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] != null) {
                countClientes++;
                System.out.println(i + " - " + cArr[i].toString());
                System.out.println("---------------------------");
            }
        }
        if (countClientes == 0) {
            System.out.println("Não há nenhum cliente cadastrado");
        }
        System.out.println("Total de clientes cadastrados: " + countClientes);
    }
}


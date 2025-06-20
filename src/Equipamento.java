import java.util.Scanner;

public class Equipamento {
    private int codigo;
    private String nome;
    private String tipo; // barra, kettlebell ou corda naval
    private int quantDispLocacao;
    private double valorBaseLocacao;
    private double valorAluguel; // por 1 semana, 15 dias ou 1 mês (com 5% de desconto para 15 dias e 10% para 1
                                 // mês)
    private boolean seguro; // se for contratado, acrescenta 2% ao valor total
    private int countTotal;

    Scanner teclado = new Scanner(System.in);

    public Equipamento(int codigo, String nome, String tipo, int quantDispLocacao, double valorBaseLocacao, int countTotal) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.quantDispLocacao = quantDispLocacao;
        this.valorBaseLocacao = valorBaseLocacao;
        this.countTotal = countTotal;
        // this.valorAluguel = valorAluguel;
    }

    // --- GETS

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantDispLocacao() {
        return quantDispLocacao;
    }

    public double getValorBaseLocacao() {
        return valorBaseLocacao;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public int getCountTotal() {
        return countTotal;
    }

    // -- SETS

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantDispLocacao(int quantDispLocacao) {
        this.quantDispLocacao = quantDispLocacao;
    }

    public void setValorBaseLocacao(double valorBaseLocacao) {
        this.valorBaseLocacao = valorBaseLocacao;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public void setCountTotal(int countTotal) {
        this.countTotal = countTotal;
    }

    public String toString() {
        return "Equipamento { Código: " + codigo + " | Nome: " + nome + " | Tipo: " + tipo
                + " | Quantidade Disponível: " + quantDispLocacao + " | Valor base locação: " + valorBaseLocacao
                + " } ";
    }

    // !!!!!!!
    // Comentei o outro retirar que a gente tinha, basicamente eu mudei o incluir
    // cliente (coloquei pra ele retirar do nosso estoque a quantidade desejada pelo
    // cliente). Só que pra fazer isso eu precisava colocar como
    // parâmentro a quantidade desejada, que no nosso antigo método retirar não
    // tinha, enfim... Olha ai o novo método e vê oq tu acha
    //

    public void retirar(Equipamento equipamento, int qntDesejada) {

        while (equipamento.getQuantDispLocacao() < qntDesejada) {
            System.out.println();
            System.out.println(
                    "A quantidade desejada excede a quantia do estoque. Quantidade Disponível para locação do equipamento: "
                            + quantDispLocacao);
            System.out.print("Digite uma nova quantidade desejada: ");
            qntDesejada = teclado.nextInt(); // Solicita nova quantidade
        }
        equipamento.setQuantDispLocacao(equipamento.getQuantDispLocacao() - qntDesejada);
        System.out.println("Nova quantidade disponivel: " + equipamento.getQuantDispLocacao());
    }


    public void devolver(CadastroEquipamento cEquipamento, CadastroCliente cCliente) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nome do cliente que está devolvendo o equipamento: ");
        String nomeCliente = teclado.nextLine();

        for (int i = 0; i < cCliente.cArr.length; i++) {
            if (cCliente.cArr[i] != null && cCliente.cArr[i].getNome().equalsIgnoreCase(nomeCliente)) {
                Equipamento equipamento = cCliente.cArr[i].getDadosEquipamento();
                int quantidadeAlugada = cCliente.cArr[i].getQuantidadeAlugada();
                if (equipamento != null) {
                    equipamento.setQuantDispLocacao(equipamento.getQuantDispLocacao() + quantidadeAlugada);
                    System.out.println("Equipamento devolvido ao estoque: " + equipamento.getNome());
                    cCliente.cArr[i].setDadosEquipamento(null);
                } else {
                    System.out.println("Este cliente não possui equipamento alugado.");
                }
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    

    public double calcValorLocacao(int dias, boolean seguro) {
        double valor = valorBaseLocacao;

        if (dias >= 15) {
            valor = valor * 0.95;
        } else if (dias >= 30) {
            valor = valor * 0.9;
        }

        if (seguro) {
            valor = valor * 1.02;
        }

        return valor;
    }
}

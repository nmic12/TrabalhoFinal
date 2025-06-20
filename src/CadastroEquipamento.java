import java.util.Scanner;
;
public class CadastroEquipamento {
    Scanner teclado = new Scanner(System.in);
    Equipamento[] eArr;

    public CadastroEquipamento(){
        eArr = new Equipamento[10];

        eArr[0] = new Equipamento(1, "Barra Olimpica", "barra", 5, 100.0, 0);
        eArr[1] = new Equipamento(2, "Kettlebell 16kg", "kettlebell", 10, 500.0, 0);
        eArr[2] = new Equipamento(3, "Corda Naval", "corda naval", 8, 30.0, 0);
        eArr[3] = new Equipamento(4, "Barra de Levantamento", "barra", 4, 120.0, 0);
        eArr[4] = new Equipamento(5, "Kettlebell 24kg", "kettlebell", 6, 70.0, 0);
        eArr[5] = new Equipamento(6, "Corda de Pular", "corda naval", 12, 25.0, 0);
    }

    public Equipamento addEquipamento(int codigoEquipamento) {
        CadastroEquipamento cEquipamento = new CadastroEquipamento();
        //int codigoEquipamento = 0; // Corrigido: instanciar Random
        System.out.print("Insira o nome do equipamento: ");
        String nomeEquipamento = teclado.nextLine();
        System.out.println();
        System.out.print("Insira o Tipo do equipamento: ");
        String tipoEquipamento = teclado.nextLine();
        System.out.println();
        System.out.print("Insira a quantidade disponivel deste equipamento: ");
        int quantDispLocacao = teclado.nextInt();
        System.out.print("Insira o valor base da locação: ");
        double valorBaseLocacao = teclado.nextDouble();
       // System.out.print("Insira a quantidade disponivel deste equipamento: ");
        

        //Equipamento equipamento = cEquipamento.buscaEquipPeloCodigo(codigoEquipamento); // Busca o equipamento desejado pelo código
        //cEquipamento.removeEquipamento(codigoEquipamento); // Remove o equipamento do estoque
        return new Equipamento(codigoEquipamento, nomeEquipamento, tipoEquipamento, quantDispLocacao, valorBaseLocacao, 0);
    }
    

    public void removeEquipamento(int codigo){
        for(int i = 0; i < eArr.length; i++)
        {
            if(eArr[i].getCodigo() == codigo)
            {
                eArr[i] = null;
            }
        }
    }

    public Equipamento buscaEquipPeloNome() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Insira o nome do equipamento: ");
        String nome = teclado.nextLine();
        for (int i = 0; i < eArr.length; i++) {
            if (eArr[i] != null && eArr[i].getNome().equalsIgnoreCase(nome)) {
                System.out.println("Equipamento encontrado: " + eArr[i].toString());
                return eArr[i];
            }
        }
        System.out.println("Este equipamento nao existe.");
        return null;
    }

    public Equipamento buscaEquipPeloCodigo(int codigo) {
        for (int i = 0; i < eArr.length; i++) {
            if (eArr[i] != null && eArr[i].getCodigo() == codigo) {
                // System.out.println("EQUIPAMENTO DE CODIGO "+codigo); // DEBUG ||| o equipamento tá sendo achado, só que quando é um número maior que 1 ele printa que não existe o equipamento
                return eArr[i];
            }
            else {
                
            }
        }
        return null; // se nao encontrar retorna null
    }


    public void totalEquipamentos()
    {
        int count = 0;
        for(int i = 0; i < eArr.length; i++)
        {
            if(eArr[i] != null)
            {
                count++;
            }
        }
        System.out.println("Total de Equipamentos: " + count);
    }

    public void mostrarEquipamentos() {
        for (int i = 0; i < eArr.length; i++) {
            if (eArr[i] != null) {
                System.out.println(i + " - " + eArr[i].toString());
            }
        }
    }

}


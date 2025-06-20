public class Inovacao {

    public void maiorDemanda(CadastroCliente cCliente, CadastroEquipamento cEquipamento) {
        if (cCliente == null || cEquipamento == null) {
            System.out.println("Dados de clientes ou equipamentos não disponíveis.");
            return;
        }

        Equipamento equipamentomais = null;
        int maiorDemanda = -1;

        for (int i = 0; i < cEquipamento.eArr.length; i++) {
            Equipamento eq = cEquipamento.eArr[i];
            if (eq != null) {
                int demanda = 0;
                for (int j = 0; j < cCliente.cArr.length; j++) {
                    if (cCliente.cArr[j] != null && cCliente.cArr[j].getDadosEquipamento() != null
                            && cCliente.cArr[j].getDadosEquipamento().getCodigo() == eq.getCodigo()) {
                        demanda++;
                    }
                }
                if (demanda > maiorDemanda) {
                    maiorDemanda = demanda;
                    equipamentomais = eq;
                }
            }
        }

        if (equipamentomais != null && maiorDemanda > 0) {
            System.out.println("Equipamento mais demandado: " + equipamentomais.getNome() + " com " + maiorDemanda + " solicitações.");
        } else {
            System.out.println("Não há dados suficientes para calcular a maior demanda.");
        }
    }
}
public class Inovacao{  
    CadastroCliente cCliente = new CadastroCliente();
    CadastroEquipamento cEquipamento = new CadastroEquipamento();

        public void maiorDemanda(){
        for(int i = 0; i < cCliente.cArr.length; i++)
        {
            Equipamento equipamentomais = cEquipamento.eArr[0];
            for(int j = 1;j < cEquipamento.eArr.length; j++) {
                if (cEquipamento.eArr[j] != null && cEquipamento.eArr[j].getCountTotal() > equipamentomais.getCountTotal())
                    equipamentomais = cEquipamento.eArr[j];
            }
            
            System.out.println("Equipamento mais demandado: " + equipamentomais.getNome() + " com " + equipamentomais.getCountTotal() + " solicitações.");
        }
    }
}
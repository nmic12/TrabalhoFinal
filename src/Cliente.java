public class Cliente {
    private int matricula;
    private String nome;
    private String academia;
    private Equipamento dadosEquipamento;
    private int quantidadeAlugada;

    public Cliente(int matricula, String nome, String academia, Equipamento dadosEquipamento, int quantidadeAlugada)
    {
        this.matricula = matricula;
        this.nome = nome;
        this.academia = academia;
        this.dadosEquipamento = dadosEquipamento;
        this.quantidadeAlugada = quantidadeAlugada;
    }

    public int getQuantidadeAlugada() {
        return quantidadeAlugada;
    }

    public void setQuantidadeAlugada(int quantidadeAlugada) {
        this.quantidadeAlugada = quantidadeAlugada;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getAcademia() {
        return academia;
    }

    // tem que colocar to string
    public Equipamento getDadosEquipamento() {
        return dadosEquipamento;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public void setDadosEquipamento(Equipamento dadosEquipamento) {
        this.dadosEquipamento = dadosEquipamento;
    }

    public String toString() {
        return "Cliente { Matricula: " + matricula + " | Nome: " + nome + " | Academia: " + academia
                + " | Dados Equipamento: " + dadosEquipamento.toString() + " }";
    }
    
}

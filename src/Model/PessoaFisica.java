package APS.src.Model;

public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica(String nome, String endereco, String cpf, double salario) {
        super(nome, endereco, salario, new double[] {0.02, 0.04, 0.07});
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

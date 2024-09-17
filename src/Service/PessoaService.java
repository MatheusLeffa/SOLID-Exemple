package APS.src.Service;

import APS.src.Model.Pessoa;
import APS.src.Repository.IBancoDados;

/**
 * Esta classe e responsável pela camada de negócio.
 * Ela faz a ligação com a camada de dados.
 */

public class PessoaService implements IPessoaService {
    private final IBancoDados bancoDados;
    private static int contadorID = 1;

    public PessoaService(IBancoDados bancoDados) {
        this.bancoDados = bancoDados;
    }

    @Override
    public void salva(Pessoa pessoa) throws Exception {
        validaPessoa(pessoa);
        pessoa.setId(contadorID++);
        bancoDados.salvar(pessoa);
    }

    @Override
    public void remover(Integer idPessoa) throws Exception {
        bancoDados.remover(idPessoa);
    }

    @Override
    public Pessoa busca(Integer idPessoa) {
        return bancoDados.buscar(idPessoa);
    }

    @Override
    public String mostraSalarioPessoas() {
        String retorno = "";
        for (Pessoa pessoa : bancoDados.buscar()) {
            double salarioPessoa = calculaSalario(pessoa);
            retorno += pessoa.getId() + ". " + pessoa.getNome() + "- Salário total: R$ " + salarioPessoa + "\n";
        }
        return retorno;
    }

    @Override
    public double calculaSalario(Pessoa pessoa) {
        double totalSalario;
        if (pessoa.getSalario() < 1000) {
            totalSalario = ((pessoa.getSalario() * pessoa.getBonusSalario()[0]) + pessoa.getSalario());
        } else if (pessoa.getSalario() < 3000) {
            totalSalario = ((pessoa.getSalario() * pessoa.getBonusSalario()[1]) + pessoa.getSalario());
        } else {
            totalSalario = ((pessoa.getSalario() * pessoa.getBonusSalario()[2]) + pessoa.getSalario());
        }
        return totalSalario;
    }

    private void validaPessoa(Pessoa pessoa) throws Exception {
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa esta null");
        }

        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome da pessoa esta inválida");
        }

        if (pessoa.getEndereco() == null || pessoa.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("Endereço da pessoa esta inválida!");
        }

        if (pessoa.getSalario() <= 0) {
            throw new IllegalArgumentException("O salário está inválido!");
        }
    }

}

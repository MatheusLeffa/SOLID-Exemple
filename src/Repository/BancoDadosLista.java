package APS.src.Repository;

import APS.src.Model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class BancoDadosLista implements IBancoDados {
    private List<Pessoa> listaPessoa;

    public BancoDadosLista() {
        this.listaPessoa = new ArrayList<Pessoa>();
    }

    @Override
    public void salvar(Pessoa pessoa) {
        listaPessoa.add(pessoa);
    }

    @Override
    public void remover(Integer idPessoa) {
        listaPessoa.removeIf(p -> p.getId().equals(idPessoa));
    }

    @Override
    public Pessoa buscar(Integer idPessoa) {
        for (Pessoa pessoaIterator : listaPessoa) {
            if (pessoaIterator.getId().equals(idPessoa)) {
                return pessoaIterator;
            }
        }
        return null;
    }

    @Override
    public List<Pessoa> buscar() {
        return listaPessoa;
    }
}

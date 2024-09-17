package APS.src.Repository;

import APS.src.Model.Pessoa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDadosMapa implements IBancoDados {
	private Map<Integer, Pessoa> dicionarioPessoa;

	public BancoDadosMapa() {
		this.dicionarioPessoa = new HashMap<Integer,Pessoa>();
	}

	@Override
	public void salvar(Pessoa pessoa) {
		dicionarioPessoa.put(pessoa.getId(), pessoa);
	}

	@Override
	public void remover(Integer idPessoa) {
		dicionarioPessoa.remove(idPessoa);
	}

	@Override
	public Pessoa buscar(Integer idPessoa) {
		return dicionarioPessoa.get(idPessoa);
	}

	@Override
	public List<Pessoa> buscar() {
        return dicionarioPessoa.values().stream().toList();
	}
}

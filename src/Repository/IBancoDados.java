package APS.src.Repository;

import APS.src.Model.Pessoa;

import java.util.Collection;
import java.util.List;

public interface IBancoDados {
	void salvar(Pessoa pessoa);
	
	void remover(Integer idPessoa);
	
	Pessoa buscar(Integer idPessoa);

	List<Pessoa> buscar();
}

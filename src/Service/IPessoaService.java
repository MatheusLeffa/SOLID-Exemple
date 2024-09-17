package APS.src.Service;

import APS.src.Model.Pessoa;

// DICA: aqui estamos fazendo muita coisa
public interface IPessoaService {
	void salva(Pessoa pessoa) throws Exception;
	
	void remover(Integer idPessoa) throws Exception;
	
	Pessoa busca(Integer idPessoa);

	String mostraSalarioPessoas();

	double calculaSalario(Pessoa pessoa);
}

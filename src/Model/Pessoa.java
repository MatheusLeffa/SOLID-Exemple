package APS.src.Model;

public class Pessoa {
	private Integer id;
	private String nome;
	private String endereco;
	private double salario;
	private final double[] bonusSalario;

	public Pessoa(String nome, String endereco, double salario, double[] bonusSalario) {
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.bonusSalario = bonusSalario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

    public double[] getBonusSalario() {
        return bonusSalario;
    }
}

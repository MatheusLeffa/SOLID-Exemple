package APS.src.View;

import APS.src.Model.PessoaFisica;
import APS.src.Model.PessoaJuridica;
import APS.src.Repository.BancoDadosLista;
import APS.src.Repository.BancoDadosMapa;
import APS.src.Service.IPessoaService;
import APS.src.Service.PessoaService;

import javax.swing.*;

// INICIO DO PROGRAMA
public class Main {
    static IPessoaService pessoaService;
    static final String MENU_OPTIONS = """
                Selecione uma opção:
                1. Cadastrar pessoa física
                2. Cadastrar pessoa jurídica
                3. Mostrar salário das pessoas
                4. Remover uma Pessoa
                5. Sair
                """;

    public static void main(String[] args) {
        pessoaService = setPessoaService();
        menuPrincipal();
    }

    private static IPessoaService setPessoaService() {
        String dataBaseType = JOptionPane.showInputDialog("Selecione a forma de armazenamento:\n1.Lista\n2.Mapa");
        switch (dataBaseType) {
            case "1" -> {
                return new PessoaService(new BancoDadosLista());
            }
            case "2" -> {
                return new PessoaService(new BancoDadosMapa());
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opção invalida de banco de dados!");
                System.exit(1);
                return null;
            }
        }
    }

    private static void menuPrincipal() {
        while (true) {
            String option = JOptionPane.showInputDialog(MENU_OPTIONS);
            switch (option) {
                case "1" -> {
                    try {
                        cadastroPessoaFisica();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa fisica.");
                    }
                }
                case "2" -> {
                    try {
                        cadastroPessoaJuridica();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao salvar pessoa juridica");
                    }
                }
                case "3" -> mostrarSalario();
                case "4" -> {
                    try {
                        removerPessoa();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao remove pessoa");
                    }
                }
                case "5" -> System.exit(1);
            }
        }
    }

    private static void cadastroPessoaFisica() throws Exception {
        String nome = JOptionPane.showInputDialog("Qual nome da pessoa?");
        String endereco = JOptionPane.showInputDialog("Qual endereço da pessoa física?");
        String cpf = JOptionPane.showInputDialog("Qual cpf da pessoa?");
        float salario = Float.parseFloat(JOptionPane.showInputDialog("Qual salario da pessoa?"));

        PessoaFisica pessoaFisica = new PessoaFisica(nome, endereco, cpf, salario);
        pessoaService.salva(pessoaFisica);
    }

    private static void cadastroPessoaJuridica() throws Exception {
        String nome = JOptionPane.showInputDialog("Qual nome da empresa?");
        String endereco = JOptionPane.showInputDialog("Qual endereço da empresa?");
        String cnpj = JOptionPane.showInputDialog("Qual CNPJ da empresa?");
        float salario = Float.parseFloat(JOptionPane.showInputDialog("Qual salario da pessoa jurídica?"));

        PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, endereco, cnpj, salario);
        pessoaService.salva(pessoaJuridica);
    }

    private static void mostrarSalario() {
        JOptionPane.showMessageDialog(null, pessoaService.mostraSalarioPessoas());
    }

    private static void removerPessoa() throws Exception {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Qual id da pessoa para remover?"));
        pessoaService.remover(id);
    }
}

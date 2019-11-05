/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

/**
 *
 * @author Aluno
 */
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaDAO implements DAO {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private static PessoaDAO pessoaDaoUnica;
    
    private PessoaDAO(){}
    
    public static synchronized PessoaDAO getInstance(){
        if(pessoaDaoUnica == null){
            pessoaDaoUnica = new PessoaDAO();
        }
        return pessoaDaoUnica;
    }
    
    private Pessoa buscar(String cpf){
        for(Pessoa p: pessoas){
            
            if(p.getCpf().equals(cpf)){
                
                return p;
            }
        }       
        System.out.println("Pessoa não encontrada!");
        return null;
    }
    private void adicionarProdutividade(){
        String cpf;
        System.out.println("Insira o cpf do funcionario: ");
        cpf = input.next();
        Pessoa p = buscar(cpf);
        if( p != null){
            if(p instanceof Vendedor){
                System.out.println("Insira o valor das vendas: ");
                ((Vendedor) p).setVendas(input.nextDouble());
            }else if(p instanceof Administrativo){
                System.out.println("Insira a quantidade de horas extras: ");
                ((Administrativo) p).setHoras(input.nextDouble());
            }else if(p instanceof Cliente){
                System.out.println("Não é um funcionário!");
                
            }
        }
    }
    private void gerarFolhaPagamento(){
        for(Pessoa p : pessoas){
            System.out.println(p);
            
        }
    }

    @Override
    public void menu() {
        int opcao;
        do{
            System.out.println("\n\tMENU PESSOA\n1 - Cadastrar pessoas\n2 - Remover pessoa");
            System.out.println("3 - Buscar pessoa\n4 - Adicionar produtividade");
            System.out.println("5 - Gerar Folha de pagamento\n6 - Voltar");
            System.out.println("> ");
            switch(opcao = input.nextInt()){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    adicionarProdutividade();
                    break;
                case 5:
                    gerarFolhaPagamento();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }while(opcao != 6);
    }

    @Override
    public void cadastrar() {
        int opcao = 0;
        String nome = null, cpf = null;
        int matricula = 0;
        double salario = 0;       
        do{
            System.out.println("\tCadastrar");
            System.out.println("\n1 - Cliente\n2 - Administrativo");
            System.out.println("3 - Vendedor\n4 - Voltar");
            opcao = input.nextInt();
            if(opcao == 1){
               // System.out.println("\nInsira o nome, CPF e Código do cliente: ");
                System.out.println("----------Cadastro----------");
                System.out.print("Nome > ");
                nome = input.next();
                System.out.print("CPF > ");
                cpf = input.next();
                System.out.print("Matricula > ");
                matricula = input.nextInt();
                
                if(verificaCpf(cpf)){
                    pessoas.add(new Cliente(nome, cpf, matricula));
                }else{
                    System.out.println("CPF já cadastrado!\n");
                }
                System.out.println("---------------------------");
            }else if((opcao > 1 || opcao < 4) && opcao != 4){
                System.out.println("---------Cadastro---------");
                System.out.print("Nome > ");
                nome = input.next();
                System.out.print("Cpf > ");
                cpf = input.next();
                System.out.println("Matricula > ");
                matricula = input.nextInt();
                System.out.print("Salario > ");
                salario = input.nextInt();     
                System.out.println("--------------------------");
            }
            switch(opcao){
                case 1:                                        
                    break;
                case 2:
                    if(verificaCpf(cpf)){
                        pessoas.add(new Administrativo(nome, cpf,matricula, salario));
                    }else{
                        System.out.println("CPF já cadastrado!\n");
                    }
                    break;
                case 3:
                    if(verificaCpf(cpf)){
                        pessoas.add(new Vendedor(nome, cpf, matricula, salario));
                    }else{
                        System.out.println("CPF já cadastrado!\n");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }            
    }while(opcao != 4);
    
    }

    @Override
    public void remover() {
        String cpf;
        System.out.println("Insira o cpf da pessoa que será removida: ");
        cpf = input.next();
        if(buscar(cpf) != null){
            pessoas.remove(buscar(cpf));
            System.out.println("Removido com Sucesso!");
        }
    }

    @Override
    public void buscar(){
        String cpf;
        System.out.println("Insira o CPF da pessoa: ");
        cpf = input.next();
        Pessoa p = buscar(cpf);
        if(p != null){
            System.out.println(p);            
        }
    }
    public boolean verificaCpf(String cpf){
        for(Pessoa p:pessoas){
            if(p.getCpf().equals(cpf)){
                return false;
            }
        }
        return true;
    }
}

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

public class FornecedorDAO implements DAO {
    private ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    private Scanner input = new Scanner(System.in);    
    private static FornecedorDAO fornecedorDaoUnico;    //Objeto único de FornecedorDAO que será utilizado no código
    
    private FornecedorDAO(){} // construtor vazio e privado para impedir outras instancias da classe
    
    public static synchronized FornecedorDAO getInstance(){
        if(fornecedorDaoUnico == null){
            fornecedorDaoUnico = new FornecedorDAO();
        }
        return fornecedorDaoUnico;
    }
    
    @Override
    public void menu() {
        int op;
        do{
            System.out.println("\n\tMENU FORNECEDOR\n1 - Cadastrar fornecedor\n2 - Remover fornecedor\n3 - Buscar fornecedor\n4 - Voltar");
            switch(op = input.nextInt()){
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
                    break;
                default:
                    System.out.println("Opçao Inválida!");
            }
        }while(op != 4);
    }

    @Override
    public void cadastrar() {
        System.out.println("\n\tCadastrar Fornecedor\n->Informe:Razão social e o cnpj da empresa: ");
        fornecedores.add(new Fornecedor(input.next(), input.next()));
        System.out.println(fornecedores);
        
    }

    @Override
    public void remover() {
        String cnpj;
        System.out.println("\n\tRemover Fornecedor\nInforme o cnpj: ");
        cnpj = input.next();
        Fornecedor p = mandaFornecedor(cnpj);
        if(p != null){
            fornecedores.remove(p);
        }else{
            System.out.println("Este fornecedor não existe!");
        }
        
    }

    @Override
    public void buscar() {
        String cnpj;
        int flag = 0;
        System.out.println("Insira o cnpj para pesquisa: ");
        cnpj = input.next();
        for(Fornecedor p: fornecedores){
            if(p.getCnpj().equalsIgnoreCase(cnpj)){
                System.out.println(p);
                flag = 1;
                break;
            }
        }
        if(flag != 1){
            System.out.println("CNPJ não encontrado!");
        }
        
    }
    private Fornecedor mandaFornecedor(String cnpj){
        for(Fornecedor p: fornecedores){
            if(p.getCnpj().equalsIgnoreCase(cnpj)){
                return p;
            }
        }
        return null;
    }
}

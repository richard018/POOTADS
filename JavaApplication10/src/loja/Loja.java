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
import java.util.Scanner;

public class Loja {
    private DAO dao;    
    private Scanner input = new Scanner(System.in);
       
    public void menu(){
        int opcao;
        do{
            System.out.println("\n\tMenu Principal\n1 - Pessoa\n2 - Fornecedor\n3 - Sair");
            
            System.out.print("> ");
            switch(opcao = input.nextInt()){
                case 1:
                    dao = PessoaDAO.getInstance();
                    break;
                case 2:
                    dao = FornecedorDAO.getInstance();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida!");
            }
            
            dao.menu();
        }while(opcao != 3);
    }
    public static void main(String[] args) {
        Loja l = new Loja();
        l.menu();
    }
    
}
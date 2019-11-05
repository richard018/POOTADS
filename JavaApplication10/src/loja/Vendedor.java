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
public class Vendedor extends Funcionario {
    private double vendas = 0;

    public Vendedor(String nome, String cpf, int matricula, double salario) {
        super(nome, cpf, matricula, salario);
    }

    @Override
    public double calculaPagamento() {
        return (getSalario() + (vendas * 0.10));
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas += vendas;
    }

    @Override
    public String toString() {
        return "\nNome: "+getNome()+"\tCPF: "+ getCpf()+"\nSalário: R$"+getSalario()+"\tTotal em Vendas: R$"+getVendas()+"\nComissão: R$"+(vendas * 0.10)+"\tSalário Total: R$"+calculaPagamento();
    }
      
}

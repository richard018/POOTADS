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
public class Administrativo extends Funcionario {
    
    private double horas = 0;
    
    public Administrativo(String nome, String cpf,int matricula, double salario) {
        super(nome, cpf, matricula, salario);
    }

    @Override
    public double calculaPagamento() {
        return (getSalario() + ((getSalario() * 0.01) * horas));
        
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas += horas;
    }

    @Override
    public String toString() {
        return "\nNome: "+getNome()+"\tCPF: "+ getCpf()+"\nSalário: R$"+getSalario()+"\tHoras: "+getHoras()+"\nComissão: R$"+ (getSalario() * 0.01) * horas+"\tSalário Total: R$"+calculaPagamento();
    }
    
    
}

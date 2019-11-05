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
public abstract class Funcionario extends Pessoa {
    private int matricula;
    private double salario;

    public Funcionario(String nome, String cpf, int matricula, double salario) {
        super(nome, cpf);
        this.matricula = matricula;
        this.salario = salario;
    }

    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "matricula=" + matricula + ", salario=" + salario + '}';
    }
    public abstract double calculaPagamento();
    
}

package com.iniflex.teste.model;

  import java.math.BigDecimal;
  import java.math.RoundingMode;
  import java.time.LocalDate;

  /**
   * Classe Funcionario - requisito 2. Estende Pessoa.
    */
  public class Funcionario extends Pessoa {

  private BigDecimal salario;
  private String funcao;

  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
  super(nome, dataNascimento);
  this.salario = salario;
  this.funcao = funcao;
  }

  public BigDecimal getSalario() {
  return salario;
  }

  public void setSalario(BigDecimal salario) {
  this.salario = salario;
  }

  public String getFuncao() {
  return funcao;
  }

  public void setFuncao(String funcao) {
  this.funcao = funcao;
  }

  /**
  * Requisito 3.4 - aplica um percentual de aumento sobre o salario atual.
  */
  public void aumentarSalario(BigDecimal percentual) {
  BigDecimal fator = BigDecimal.ONE.add(percentual);
  this.salario = this.salario.multiply(fator).setScale(2, RoundingMode.HALF_UP);
  }
  }
  

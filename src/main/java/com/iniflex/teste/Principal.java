package com.iniflex.teste;

import com.iniflex.teste.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* Classe Principal - requisito 3.
* Executa, em sequencia, todas as acoes pedidas no teste pratico.
*/
public class Principal {

private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

private static final DecimalFormat FORMATO_NUMERO;
static {
DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
simbolos.setDecimalSeparator(',');
simbolos.setGroupingSeparator('.');
FORMATO_NUMERO = new DecimalFormat("#,##0.00", simbolos);
}

private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

public static void main(String[] args) {

// 3.1 - Inserir todos os funcionarios, na mesma ordem e informacoes da tabela.
List<Funcionario> funcionarios = new ArrayList<>();
funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

// 3.2 - Remover o funcionario "João" da lista.
funcionarios.removeIf(f -> f.getNome().equals("João"));

// 3.3 - Imprimir todos os funcionarios com todas as informacoes.
System.out.println("3.3 - Lista de funcionários:");
funcionarios.forEach(Principal::imprimirFuncionario);
System.out.println();

// 3.4 - Aplicar 10% de aumento de salario.
funcionarios.forEach(f -> f.aumentarSalario(new BigDecimal("0.10")));
System.out.println("3.4 - Funcionários após aumento de 10%:");
funcionarios.forEach(Principal::imprimirFuncionario);
System.out.println();

// 3.5 - Agrupar os funcionarios por funcao em um Map.
Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
.collect(Collectors.groupingBy(Funcionario::getFuncao));

// 3.6 - Imprimir os funcionarios agrupados por funcao.
System.out.println("3.6 - Funcionários agrupados por função:");
funcionariosPorFuncao.forEach((funcao, lista) -> {
System.out.println("Função: " + funcao);
lista.forEach(Principal::imprimirFuncionario);
System.out.println();
});

// 3.8 - Imprimir os funcionarios que fazem aniversario nos meses 10 e 12.
System.out.println("3.8 - Funcionários que fazem aniversário em outubro ou dezembro:");
funcionarios.stream()
.filter(f -> f.getDataNascimento().getMonthValue() == 10
|| f.getDataNascimento().getMonthValue() == 12)
.forEach(Principal::imprimirFuncionario);
System.out.println();

// 3.9 - Imprimir o funcionario com a maior idade (nome e idade).
Funcionario maisVelho = funcionarios.stream()
.min(Comparator.comparing(Funcionario::getDataNascimento))
.orElseThrow();
int idade = calcularIdade(maisVelho.getDataNascimento());
System.out.println("3.9 - Funcionário com a maior idade:");
System.out.println("Nome: " + maisVelho.getNome() + " - Idade: " + idade);
System.out.println();

// 3.10 - Imprimir a lista de funcionarios em ordem alfabetica.
System.out.println("3.10 - Funcionários em ordem alfabética:");
funcionarios.stream()
.sorted(Comparator.comparing(Funcionario::getNome))
.forEach(Principal::imprimirFuncionario);
System.out.println();

// 3.11 - Imprimir o total dos salarios dos funcionarios.
BigDecimal totalSalarios = funcionarios.stream()
.map(Funcionario::getSalario)
.reduce(BigDecimal.ZERO, BigDecimal::add);
System.out.println("3.11 - Total dos salários: " + FORMATO_NUMERO.format(totalSalarios));
System.out.println();

// 3.12 - Imprimir quantos salarios minimos ganha cada funcionario.
System.out.println("3.12 - Quantidade de salários mínimos por funcionário:");
funcionarios.forEach(f -> {
BigDecimal quantidade = f.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
System.out.println(f.getNome() + " - " + FORMATO_NUMERO.format(quantidade) + " salários mínimos");
});
}

private static void imprimirFuncionario(Funcionario f) {
System.out.println(
"Nome: " + f.getNome()
+ " | Data Nascimento: " + f.getDataNascimento().format(FORMATO_DATA)
+ " | Salário: " + FORMATO_NUMERO.format(f.getSalario())
+ " | Função: " + f.getFuncao());
}

private static int calcularIdade(LocalDate dataNascimento) {
return Period.between(dataNascimento, LocalDate.now()).getYears();
}
}

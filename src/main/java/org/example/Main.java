package org.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n<--------- Crie um dicionario e relacione estados e populações --------> \n");
        Map<String, Estado> estados = new LinkedHashMap<>(){{
            put("PE", new Estado("Pernambuco", 9616621));
            put("AL", new Estado("Alagoas", 3351543));
            put("CE", new Estado("Ceará", 9187103));
            put("RN", new Estado("Rio Grande do Norte", 3534265));
        }};
        System.out.println("<--------- Exiba o dicionário --------> \n");
        System.out.println(estados + "\n ---------------------------------------------------------------------\n");
        System.out.println(" <-------------- Substituir População de RN --------------\n");

        estados.put("RN", new Estado("Rio Grande do Norte", 3534165));
        System.out.println("<--------- Exiba o dicionário --------> \n");
        System.out.println(estados + "\n ---------------------------------------------------------------------\n");
    }
}

class Estado implements Comparable<Estado>{
    String nome;
    Integer pop;

    public Estado() {
        super();
    }

    public Estado(String nome, Integer pop) {
        this.nome = nome;
        this.pop = pop;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return nome.equals(estado.nome) && pop.equals(estado.pop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pop);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", pop=" + pop +
                '}';
    }

    @Override
    public int compareTo(Estado o) {
        return 0;
    }

}
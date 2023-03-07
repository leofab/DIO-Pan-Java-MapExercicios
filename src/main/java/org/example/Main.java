package org.example;

import java.util.*;

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

        System.out.println("<--------- Confira se PB esta no dic, se nao, add --------> \n");

        System.out.println("PB está no dic ? : " + estados.containsKey("PB") + "\n");
        estados.put("PB", new Estado("Paraíba", 4039277));
        System.out.println("<--------- Exiba o dicionário --------> \n");
        System.out.println(estados + "\n ---------------------------------------------------------------------\n");

        System.out.println("<--------- Exiba a pop de PE --------> \n");
        System.out.println("População PE : " + estados.get("PE").getPop());

        System.out.println("\n <--------- Exiba todos estados em ordem de inserção --------> \n");
        for(Map.Entry<String, Estado> est : estados.entrySet()) System.out.println(est);

        System.out.println("\n <--------- Exiba todos estados em ordem alfabética --------> \n");
        Map<String, Estado> estadosNome = new TreeMap<>(estados);
        for(Map.Entry<String, Estado> est : estadosNome.entrySet()) System.out.println(est);

        System.out.println("\n <--------- Exiba o estado c menor pop --------> \n");

        Map<String, EstadosPop> estadosPop = new TreeMap<>(new EstadosPop());

        Estado estadoMin = Collections.min(estadosNome.values());
        System.out.println("<--------- Imprimindo a collections.min estadosMin --------> \n");
        System.out.println("estadosMin -> " + estadoMin + " \n");

        Set<Map.Entry<String, Estado>> entries = estadosNome.entrySet();

        String estadoMinNome = "";
        Integer estadoMinPop = 0;

        for(Map.Entry<String, Estado> entry: entries){
            if(entry.getValue().equals(estadoMin)) {
                estadoMinNome = entry.getValue().getNome();
                estadoMinPop = entry.getValue().getPop();
            }
        }

        System.out.println("Estado com menor pop : " + estadoMinNome + "  - Pop : " + estadoMinPop);

        System.out.println("\n <--------- Exiba o estado c maior pop --------> \n");

        Estado estadoMax = Collections.max(estados.values());
        System.out.println("<--------- Imprimindo a collections.max estadosMax --------> \n");
        System.out.println("estadosMax -> " + estadoMax + " \n");

        Set<Map.Entry<String, Estado>> entries1 = estados.entrySet();

        String estadoMaxNome = "";
        Integer estadoMaxPop = 0;

        for(Map.Entry<String, Estado> entry: entries1){
            if(entry.getValue().equals(estadoMax)) {
                estadoMaxNome = entry.getValue().getNome();
                estadoMaxPop = entry.getValue().getPop();
            }
        }

        System.out.println("Estado com maior pop : " + estadoMaxNome + "  - Pop : " + estadoMaxPop);
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
        int nome = this.getNome().compareTo(o.getNome());
        return nome;
    }

}

class EstadosPop implements Comparator<Estado>{

    @Override
    public int compare(Estado o1, Estado o2) {
        int pop = Integer.compare(o1.getPop(), o2.getPop());
        return pop;
    }
}
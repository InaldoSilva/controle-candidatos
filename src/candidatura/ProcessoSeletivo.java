package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Vinnie Paul","Courtney Love", "Susan Sarandon", "Paulo Muzy", "John Mayer"};
        for (String candidato: candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if (continuaTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso!");

        }while (continuaTentando && tentativasRealizadas < 3);

        if (atendeu)
            System.out.println("Coseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
        else System.out.println("Não conseguimos contato com " + candidato + " número máximo de tentativas: " + tentativasRealizadas + " tentativas realizadas.");
    }

    //metodo atender ligacao
        static boolean atender() {
            return new Random().nextInt(3)==1;
        }

    static void imprimirSelecionados() {
        String [] candidatos = {"Vinnie Paul","Courtney Love", "Susan Sarandon", "Paulo Muzy", "John Mayer"};
        System.out.println("Imprimindo a lista de cadidatos informando o índice do elemento");

        for (int indice = 0; indice < candidatos.length;indice++) {
            System.out.println("O candidato de nº " + (indice+1) + " é " + candidatos[indice]);
        }

        System.out.println("----------------------------------------");
        System.out.println("Forma abreviada de interação. 'FOR EACH'");
        System.out.println("----------------------------------------");
        for (String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"Vinnie Paul","Courtney Love", "Susan Sarandon", "Paulo Muzy", "John Mayer",
                "Eric Johnson", "Jack Buttler", "Sabrina Parlatore", "Scarlet Johanson", "Jack Johnson" };
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O(A) candidato(a) " + candidato + " Solicitou este valor de salário: " + salarioPretendido);
            if (salarioBase > salarioPretendido){
                candidatosSelecionados++;
                System.out.println("O(A) candidato(a) " + candidato + " foi selecionado(a) para a vaga!");
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }

    }
}
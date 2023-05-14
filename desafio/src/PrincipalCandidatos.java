import java.sql.Array;
import java.util.Random;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        Random random = new Random();
        int tamanho = random.nextInt(100) + 1;

        Candidato[] candidatos = new Candidato[tamanho];

        for (int i = 0; i < tamanho; i++) {
            String nome = randomNome();
            String partido = randomPartido();
            int intencoesVotos = random.nextInt(1000) + 1;
            
            candidatos[i] = new Candidato(nome, partido, intencoesVotos);
        }

        // ordenaCandidatosPorNome(candidatos);
        // ordenaCandidatosPorVotos(candidatos);
        // ordenaCandidatosPorPartido(candidatos);
    }

    public static Candidato[] ordenaCandidatosPorNome(Candidato[] candidatos){

        int i, j, indiceDoMenor;
        Candidato temp;
        int n = candidatos.length;

        for (i = 0; i < n - 1; i++) {
            indiceDoMenor = i;
            for (j = i + 1; j < n; j++) {
                int comparacaoNomes = candidatos[j].getNome().compareTo(candidatos[indiceDoMenor].getNome());
                if (comparacaoNomes < 0 || (comparacaoNomes == 0 && candidatos[j].getIntencoesVotos() > candidatos[indiceDoMenor].getIntencoesVotos())) {
                    indiceDoMenor = j;
                }
            }
            if (indiceDoMenor != i) {
                temp = candidatos[i];
                candidatos[i] = candidatos[indiceDoMenor];
                candidatos[indiceDoMenor] = temp;
            }
        }

        return candidatos;

    }
    
    public static Candidato[] ordenaCandidatosPorVotos(Candidato[] candidatos){

        int n = candidatos.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (candidatos[j].getIntencoesVotos() < candidatos[j + 1].getIntencoesVotos()) {
                    Candidato temp = candidatos[j];
                    candidatos[j] = candidatos[j + 1];
                    candidatos[j + 1] = temp;
                }
            }
        }

        return candidatos;
    }

    public static Candidato[] ordenaCandidatosPorPartido(Candidato[] candidatos){
        int n = candidatos.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceDoMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (candidatos[j].getPartido().compareTo(candidatos[indiceDoMenor].getPartido()) < 0) {
                    indiceDoMenor = j;
                }
            }
            if (indiceDoMenor != i) {
                Candidato temp = candidatos[i];
                candidatos[i] = candidatos[indiceDoMenor];
                candidatos[indiceDoMenor] = temp;
            }
        }

        return candidatos;
    }

    // metodo para gerar nome aleatorio
    public static String randomNome(){
        String[] nomes = {
            "João", "Maria", "Pedro", "Ana", "Paula", "Lucas", "Fernanda", "Rafael",
            "Camila", "Carlos", "Renata", "Marcelo", "Mariana", "Bruno", "Juliana",
            "Rodrigo", "Thais", "Gabriel", "Isabela", "Felipe"
        };

        String[] sobrenomes = {
            "Silva", "Santos", "Oliveira", "Souza", "Ferreira", "Costa", "Gomes",
            "Pereira", "Ribeiro", "Almeida", "Carvalho", "Lima", "Araujo", "Rodrigues",
            "Martins", "Correia", "Barros", "Mendonça", "Fernandes", "Nascimento"
        };

        Random random = new Random();
        int nomeRandom = random.nextInt(nomes.length) + 1;
        int sobrenomeRandom = random.nextInt(sobrenomes.length) + 1;

        return nomes[nomeRandom - 1] + " " + sobrenomes[sobrenomeRandom - 1];
    }

    // metodo que seleciona o partido aleatoriamente
    public static String randomPartido(){
        String[] partidos = {"PT", "PSDB", "PSB", "PMDB", "PV"};

        Random random = new Random();
        int partido = random.nextInt(partidos.length) + 1;

        return partidos[partido - 1];
    }
}

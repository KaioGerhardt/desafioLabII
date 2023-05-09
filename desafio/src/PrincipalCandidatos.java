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

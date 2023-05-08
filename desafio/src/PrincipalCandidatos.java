import java.util.Random;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        Random random = new Random();
        int tamanho = random.nextInt(100) + 1;

        String teste = getNome();
        String novo = "teste";

        // Candidato[] candidatos = new Candidato[tamanho];
        
    }

    // metodo para gerar nome aleatorio
    public static String getNome(){
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

        return nomes[nomeRandom] + " " + sobrenomes[sobrenomeRandom];
    }
}

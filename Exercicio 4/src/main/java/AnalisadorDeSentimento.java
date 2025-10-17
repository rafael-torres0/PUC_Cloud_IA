import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.core.credential.AzureKeyCredential;

public class AnalisadorDeSentimento {
    private static final String CHAVE_API = "";

    private static final String PONTO_DE_EXTREMIDADE = "";
    public static void main(String[] args) {
        TextAnalyticsClient cliente = new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential(CHAVE_API))
                .endpoint(PONTO_DE_EXTREMIDADE)
                .buildClient();

        String textoParaAnalisar = "Estou muito feliz com o resultado do projeto, foi um sucesso!";
        
        System.out.println("Enviando frase para análise: \"" + textoParaAnalisar + "\"");
        System.out.println("Aguardando resposta da IA do Azure...");
        System.out.println("----------------------------------------------");

        DocumentSentiment sentimentoDoDocumento = cliente.analyzeSentiment(textoParaAnalisar);

        System.out.println("RESULTADO DA ANÁLISE:");
        System.out.println("Sentimento Geral Detectado: " + sentimentoDoDocumento.getSentiment());
        System.out.println("Nível de Confiança (Scores):");
        System.out.printf("    -> Positivo: %.2f%%%n", sentimentoDoDocumento.getConfidenceScores().getPositive() * 100);
        System.out.printf("    -> Neutro:   %.2f%%%n", sentimentoDoDocumento.getConfidenceScores().getNeutral() * 100);
        System.out.printf("    -> Negativo: %.2f%%%n", sentimentoDoDocumento.getConfidenceScores().getNegative() * 100);
    }
}
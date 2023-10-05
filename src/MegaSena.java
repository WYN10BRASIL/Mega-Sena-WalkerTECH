import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MegaSena {
    private List<Resultado> resultados;

    public MegaSena(String arquivoCSV) {
        resultados = new ArrayList<>();
        carregarResultados(arquivoCSV);
    }

    private void carregarResultados(String arquivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length >= 7) {
                    Resultado resultado = criarResultado(campos);
                    resultados.add(resultado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Resultado criarResultado(String[] campos) {
        int concurso = Integer.parseInt(campos[0]);
        String data = campos[1];
        int[] dezenasSorteadas = Arrays.stream(Arrays.copyOfRange(campos, 2, 8))
                .mapToInt(Integer::parseInt)
                .toArray();
        int ganhadoresQuadra = Integer.parseInt(campos[8]);
        int ganhadoresQuina = Integer.parseInt(campos[9]);
        int ganhadoresSena = Integer.parseInt(campos[10]);
        double valorQuadra = Double.parseDouble(campos[11]);
        double valorQuina = Double.parseDouble(campos[12]);
        double valorSena = Double.parseDouble(campos[13]);
        return new Resultado(concurso, data, dezenasSorteadas,
                ganhadoresQuadra, ganhadoresQuina, ganhadoresSena,
                valorQuadra, valorQuina, valorSena);
    }

    public Resultado verificarDezenasSorteadas(int[] dezenas) {
        for (Resultado resultado : resultados) {
            if (Arrays.equals(resultado.getDezenasSorteadas(), dezenas)) {
                return resultado;
            }
        }
        return null;
    }

    public int[] sortearDezenasAleatorias() {
        Random random = new Random();
        int[] dezenasSorteadas = new int[6];
        for (int i = 0; i < 6; i++) {
            dezenasSorteadas[i] = random.nextInt(60) + 1;
        }
        return dezenasSorteadas;
    }

    public int[] contarFrequenciaDezenas() {
        int[] frequencia = new int[60];
        for (Resultado resultado : resultados) {
            for (int dezena : resultado.getDezenasSorteadas()) {
                frequencia[dezena - 1]++;
            }
        }
        return frequencia;
    }

    public int contarConcursosSemGanhadoresSena() {
        int count = 0;
        for (Resultado resultado : resultados) {
            if (resultado.getGanhadoresSena() == 0) {
                count++;
            }
        }
        return count;
    }

    public double menorPremioQuadra() {
        return menorPremioPorGanhadores(4);
    }

    public double menorPremioQuina() {
        return menorPremioPorGanhadores(5);
    }

    public double menorPremioSena() {
        return menorPremioPorGanhadores(6);
    }

    public double maiorPremioQuadra() {
        return maiorPremioPorGanhadores(4);
    }

    public double maiorPremioQuina() {
        return maiorPremioPorGanhadores(5);
    }

    public double maiorPremioSena() {
        return maiorPremioPorGanhadores(6);
    }

    private double menorPremioPorGanhadores(int ganhadores) {
        double menorPremio = Double.MAX_VALUE;
        for (Resultado resultado : resultados) {
            if (resultado.getGanhadoresQuadra() == ganhadores ||
                resultado.getGanhadoresQuina() == ganhadores ||
                resultado.getGanhadoresSena() == ganhadores) {
                double premio = resultado.getPremioPorGanhadores(ganhadores);
                if (premio < menorPremio) {
                    menorPremio = premio;
                }
            }
        }
        return menorPremio;
    }

    private double maiorPremioPorGanhadores(int ganhadores) {
        double maiorPremio = 0;
        for (Resultado resultado : resultados) {
            if (resultado.getGanhadoresQuadra() == ganhadores ||
                resultado.getGanhadoresQuina() == ganhadores ||
                resultado.getGanhadoresSena() == ganhadores) {
                double premio = resultado.getPremioPorGanhadores(ganhadores);
                if (premio > maiorPremio) {
                    maiorPremio = premio;
                }
            }
        }
        return maiorPremio;
    }

    public int totalGanhadoresQuadra() {
        return totalGanhadoresPorFaixa(4);
    }

    public int totalGanhadoresQuina() {
        return totalGanhadoresPorFaixa(5);
    }

    public int totalGanhadoresSena() {
        return totalGanhadoresPorFaixa(6);
    }

    private int totalGanhadoresPorFaixa(int ganhadores) {
        int total = 0;
        for (Resultado resultado : resultados) {
            if (resultado.getGanhadoresQuadra() == ganhadores ||
                resultado.getGanhadoresQuina() == ganhadores ||
                resultado.getGanhadoresSena() == ganhadores) {
                total++;
            }
        }
        return total;
    }

    public void registrarResultadosCSV(String arquivoCSV) {
        try (FileWriter writer = new FileWriter(arquivoCSV)) {
            for (Resultado resultado : resultados) {
                writer.append(resultado.toCSV())
                        .append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

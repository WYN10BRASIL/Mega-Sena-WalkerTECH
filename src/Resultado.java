public class Resultado {
    private int concurso;
    private String data;
    private int[] dezenasSorteadas;
    private int ganhadoresQuadra;
    private int ganhadoresQuina;
    private int ganhadoresSena;
    private double valorQuadra;
    private double valorQuina;
    private double valorSena;

    public Resultado(int concurso, String data, int[] dezenasSorteadas, int ganhadoresQuadra, int ganhadoresQuina, int ganhadoresSena, double valorQuadra, double valorQuina, double valorSena) {
        this.concurso = concurso;
        this.data = data;
        this.dezenasSorteadas = dezenasSorteadas;
        this.ganhadoresQuadra = ganhadoresQuadra;
        this.ganhadoresQuina = ganhadoresQuina;
        this.ganhadoresSena = ganhadoresSena;
        this.valorQuadra = valorQuadra;
        this.valorQuina = valorQuina;
        this.valorSena = valorSena;
    }

    public int getConcurso() {
        return concurso;
    }

    public String getData() {
        return data;
    }

    public int[] getDezenasSorteadas() {
        return dezenasSorteadas;
    }

    public int getGanhadoresQuadra() {
        return ganhadoresQuadra;
    }

    public int getGanhadoresQuina() {
        return ganhadoresQuina;
    }

    public int getGanhadoresSena() {
        return ganhadoresSena;
    }

    public double getValorQuadra() {
        return valorQuadra;
    }

    public double getValorQuina() {
        return valorQuina;
    }

    public double getValorSena() {
        return valorSena;
    }

    public double getPremioPorGanhadores(int ganhadores) {
        return 0;
    }

    public CharSequence toCSV() {
        return null;
    }
}

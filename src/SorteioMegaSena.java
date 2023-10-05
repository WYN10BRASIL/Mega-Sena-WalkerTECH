    import java.util.Date;

    public class SorteioMegaSena {
        private int concurso;
        private Date data;
        private int[] dezenasSorteadas;
        private int ganhadoresQuadra;
        private int ganhadoresQuina;
        private int ganhadoresSena;
        private double premioQuadra;
        private double premioQuina;
        private double premioSena;

        public SorteioMegaSena(int concurso, Date data, int[] dezenasSorteadas,
                            int ganhadoresQuadra, int ganhadoresQuina, int ganhadoresSena,
                            double premioQuadra, double premioQuina, double premioSena) {
            this.concurso = concurso;
            this.data = data;
            this.dezenasSorteadas = dezenasSorteadas;
            this.ganhadoresQuadra = ganhadoresQuadra;
            this.ganhadoresQuina = ganhadoresQuina;
            this.ganhadoresSena = ganhadoresSena;
            this.premioQuadra = premioQuadra;
            this.premioQuina = premioQuina;
            this.premioSena = premioSena;
        }

        
        public int getConcurso() {
            return concurso;
        }

        public void setConcurso(int concurso) {
            this.concurso = concurso;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }

        public int[] getDezenasSorteadas() {
            return dezenasSorteadas;
        }

        public void setDezenasSorteadas(int[] dezenasSorteadas) {
            this.dezenasSorteadas = dezenasSorteadas;
        }

        public int getGanhadoresQuadra() {
            return ganhadoresQuadra;
        }

        public void setGanhadoresQuadra(int ganhadoresQuadra) {
            this.ganhadoresQuadra = ganhadoresQuadra;
        }

        public int getGanhadoresQuina() {
            return ganhadoresQuina;
        }

        public void setGanhadoresQuina(int ganhadoresQuina) {
            this.ganhadoresQuina = ganhadoresQuina;
        }

        public int getGanhadoresSena() {
            return ganhadoresSena;
        }

        public void setGanhadoresSena(int ganhadoresSena) {
            this.ganhadoresSena = ganhadoresSena;
        }

        public double getPremioQuadra() {
            return premioQuadra;
        }

        public void setPremioQuadra(double premioQuadra) {
            this.premioQuadra = premioQuadra;
        }

        public double getPremioQuina() {
            return premioQuina;
        }

        public void setPremioQuina(double premioQuina) {
            this.premioQuina = premioQuina;
        }

        public double getPremioSena() {
            return premioSena;
        }

        public void setPremioSena(double premioSena) {
            this.premioSena = premioSena;
        }
    }

public abstract class Leidinys {
    private String pavadinimas;
    private int reitingas;
    private String leidykla;

    public Leidinys(String pavadinimas, int reitingas, String leidykla) {
        this.pavadinimas = pavadinimas;
        this.reitingas = reitingas;
        this.leidykla = leidykla;
    }
    abstract String rodytiInformacija();

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getReitingas() {
        return reitingas;
    }

    public void setReitingas(int reitingas) {
        this.reitingas = reitingas;
    }

    public String getLeidykla() {
        return leidykla;
    }

    public void setLeidykla(String leidykla) {
        this.leidykla = leidykla;
    }
}

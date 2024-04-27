public abstract class Leidinys {
    private String pavadinimas;

    public Leidinys(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }
    abstract String rodytiInformacija();

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }
}

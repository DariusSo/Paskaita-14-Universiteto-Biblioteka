public class Knyga extends Leidinys{
    String autorius;
    String kategorija;


    public Knyga(int reitingas, String pavadinimas, String autorius, String kategorija, String leidykla) {
        super(pavadinimas, reitingas, leidykla);
        this.autorius = autorius;
        this.kategorija = kategorija;
    }

    @Override
    String rodytiInformacija() {
        return "Knygos pavadinimas: " + getPavadinimas() + " | Autorius: " + autorius + " | Kategorija: " + kategorija + " | Reitingas: " + getReitingas()
                + " | Leidykla: " + getLeidykla();
    }

}

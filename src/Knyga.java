public class Knyga extends Leidinys{
    String autorius;
    public Knyga(String pavadinimas, String autorius) {
        super(pavadinimas);
        this.autorius = autorius;
    }

    @Override
    String rodytiInformacija() {
        return "Knygos pavadinimas: " + getPavadinimas() + " | Autorius: " + autorius;
    }

}

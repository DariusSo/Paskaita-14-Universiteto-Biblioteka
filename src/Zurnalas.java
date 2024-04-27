import java.time.LocalDate;

public class Zurnalas extends Leidinys{

    LocalDate ilseidimoData;


    public Zurnalas(int reitingas, String pavadinimas, LocalDate ilseidimoData, String leidykla) {
        super(pavadinimas, reitingas, leidykla);
        this.ilseidimoData = ilseidimoData;
    }

    @Override
    String rodytiInformacija() {
        return "Zurnalo pavadinimas: " + getPavadinimas() + " | Isleidimo data: " + String.valueOf(ilseidimoData) + " | Leidykla: " + getLeidykla()
                + " | Reitingas: " + getReitingas();
    }
}

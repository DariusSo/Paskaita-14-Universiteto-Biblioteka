import java.time.LocalDate;

public class Zurnalas extends Leidinys{

    LocalDate ilseidimoData;
    public Zurnalas(String pavadinimas, LocalDate ilseidimoData) {
        super(pavadinimas);
        this.ilseidimoData = ilseidimoData;
    }

    @Override
    String rodytiInformacija() {
        return "Zurnalo pavadinimas: " + getPavadinimas() + " | Isleidimo data: " + String.valueOf(ilseidimoData);
    }
}

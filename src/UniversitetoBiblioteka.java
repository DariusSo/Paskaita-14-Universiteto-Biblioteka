import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UniversitetoBiblioteka implements BibliotekosValdymas{
    Scanner scanner = new Scanner(System.in);
    List<Leidinys> leidiniuList = new ArrayList<>();
    String filePath = "C:\\Users\\Darius\\IdeaProjects\\Paskaita-14-Universiteto-Biblioteka\\src\\KnygosIrZurnalai.csv";
    public void menu() throws LeidinioNerastaException, BlogasPasirinkimasException {
        int pasirinkimas = 0;
        boolean flag2 = true;
        while (flag2 == true){
            try{
                System.out.println("1 - Prideti leidini, 2 - Rodyti leidiniu sarasa, 3 - Ieskoti(Pasalinti) leidini");
                pasirinkimas = scanner.nextInt();
                scanner.nextLine();
                flag2 = false;
            }catch (InputMismatchException e){
                scanner.next();
                System.out.println("Blogas pasirinkimas. Bandykite dar karta.");
            }
        }
        switch (pasirinkimas){
            case 1:
                pridetiLeidini(userPridetiLeidini());
                break;
            case 2:
                rodytiSarasa();
                break;
            case 3:
                ieškotiLeidinio(userPavadinimas());
                break;
            default:
                throw new BlogasPasirinkimasException("Tokios funkcijos meniu neturi.");
        }
    }

    @Override
    public void pridetiLeidini(Leidinys leidinys) {
        leidiniuList.add(leidinys);
    }

    @Override
    public void pašalintiLeidini(String pavadinimas) {
        for (Leidinys l : leidiniuList){
            if(l.getPavadinimas().equals(pavadinimas)){
                leidiniuList.remove(l);
                System.out.print("Pasalintas leidinys: ");
                l.rodytiInformacija();
                break;
            }
        }
    }
    @Override
    public void ieškotiLeidinio(String pavadinimas) throws LeidinioNerastaException {
        Leidinys leidinys = null;
        for (Leidinys l : leidiniuList){
            if(l.getPavadinimas().equals(pavadinimas)){
                System.out.print("Rasta: ");
                l.rodytiInformacija();
                leidinys = l;
                break;
            }
        }
        try{
            if(leidinys == null){
                throw new LeidinioNerastaException("Leidinys nerastas.");
            }
        }catch (Exception e){

        }
        if(leidinys == null){
            throw new LeidinioNerastaException("Leidinys nerastas.");
        }
        boolean flag = true;
        while(flag == true){
            try{
                System.out.println("1 - Istrinti leidini, 2 - Grizti atgal");
                int kaDaryti = scanner.nextInt();
                scanner.nextLine();
                switch (kaDaryti){
                    case 1:
                        pašalintiLeidini(leidinys.getPavadinimas());
                        flag = false;
                        break;
                    case 2:
                        flag = false;
                        break;
                    default:

                }
            }catch (InputMismatchException e){
                scanner.next();
                System.out.println("Blogas pasirinkimas. Bandykite dar karta.");
            }
        }
    }
    public Leidinys userPridetiLeidini(){
        boolean flag1 = true;
        int pasirinko = 0;
        while(flag1 == true){
            try{
                System.out.println("1 - Knyga, 2 - Zurnalas: ");
                pasirinko = scanner.nextInt();
                if (pasirinko < 2){
                    throw new BlogasPasirinkimasException("Bloga ivestis");
                }
                scanner.nextLine();
                flag1 = false;
            }catch (InputMismatchException | BlogasPasirinkimasException e){
                scanner.next();
                System.out.println("Blogas pasirinkimas. Bandykite dar karta.");
            }
        }
        System.out.println("Pavadinimas: ");
        String pavadinimas = scanner.nextLine();
        switch (pasirinko){
            case 1:
                System.out.println("Autorius: ");
                String autorius = scanner.nextLine();
                Leidinys knyga = new Knyga(pavadinimas, autorius);
                return knyga;
            case 2:
                boolean flag3 = true;
                while (flag3 = true){
                    try{
                        System.out.println("Isleidimo data: ");
                        LocalDate isleidimoData1 = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        Leidinys zurnalas = new Zurnalas(pavadinimas, isleidimoData1);
                        flag3 = false;
                        return zurnalas;
                    }catch (DateTimeException e){
                        System.out.println("Blogai ivesta data. Bandykite dar karta.");
                    }
                }

        }
        return null;
    }
    public String userPavadinimas(){
        System.out.println("Pavadinimas: ");
        String pavadinimas = scanner.nextLine();
        return pavadinimas;
    }
    public void pridetiKnygasIsCSV(){
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] l = line.split(",");
                if (l.length > 3){
                    Leidinys knyga = new Knyga(l[0], l[1]);
                    leidiniuList.add(knyga);
                }else{
                    Leidinys zurnalas = new Zurnalas(l[0], LocalDate.parse(l[1]));
                    leidiniuList.add(zurnalas);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void rodytiSarasa(){
        for(Leidinys l : leidiniuList){
            System.out.println(l.rodytiInformacija());
        }
    }
}

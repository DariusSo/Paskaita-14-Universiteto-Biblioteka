public class Main {
    public static void main(String[] args) throws LeidinioNerastaException, BlogasPasirinkimasException {
        UniversitetoBiblioteka biblioteka = new UniversitetoBiblioteka();
        biblioteka.pridetiKnygasIsCSV();
        while(true){
            biblioteka.menu();
        }
    }
}

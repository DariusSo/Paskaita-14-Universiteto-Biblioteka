public class Main {
    public static void main(String[] args) throws LeidinioNerastaException, BlogasPasirinkimasException {
        UniversitetoBiblioteka biblioteka = new UniversitetoBiblioteka();
        biblioteka.pridetiKnygasIsCSV();
        biblioteka.rodytiSarasa();
        while(true){
            biblioteka.menu();
        }
    }
}

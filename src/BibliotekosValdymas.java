public interface BibliotekosValdymas {
    void pridetiLeidini(Leidinys leidinys);
    void pašalintiLeidini(String pavadinimas);
    void ieškotiLeidinio(String pavadinimas) throws LeidinioNerastaException;

}

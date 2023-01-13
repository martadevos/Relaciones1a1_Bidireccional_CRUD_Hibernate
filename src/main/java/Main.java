import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int resp;
        boolean salir = false;
        while (!salir) {
            System.out.println("1.- Create\n" +
                    /*"2.- Read\n" +
                    "3.- Update\n" +
                    "4.- Delete\n" +*/
                    "5.- Salir");
            resp = s.nextInt();
            CRUD.open();
            salir = CRUD.menu(resp);
            CRUD.close();
        }
    }
}

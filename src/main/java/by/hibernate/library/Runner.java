package by.hibernate.library;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

    public static final String MAIN_MENU = "\n1. Create\n" +
            "2. Read\n" +
            "3. Update\n" +
            "4. Delete\n" +
            "0. Exit";

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        System.out.println(MAIN_MENU);
        int option = -1;
        while (option != 0) {
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
            }

            switch (option) {

                case 1:
                    Library.Create();
                    break;

                case 2:
                    Library.Read();
                    break;

                case 3:
                    break;

                case 4:
                    break;


                case 0:
                    sc.close();
                    System.exit(0);

                default:
                    break;


            }
        }
    }


}


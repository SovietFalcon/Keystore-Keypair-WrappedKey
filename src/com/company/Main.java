package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Exercicis:\n1. 1.1.\n2. 1.2.\n3. 1.3.\n4. 2.1.\n5. 2.2.\n6. 2.3\n7. 2.4\n8. 2.5");
        int menu = scanner.nextInt();

        switch(menu) {
            case 1:
                HacerCosas.exercici11();
                break;
            case 2:
                HacerCosas.exercici12();
                break;
            case 3:
                HacerCosas.exercici13();
                break;
            case 4:
                HacerCosas.exercici21();
                break;
            case 5:
                HacerCosas.exercici22();
                break;
            case 6:
                HacerCosas.exercici23();
                break;
            case 7:
                HacerCosas.exercici13();
                break;
        }

    }
}

package com.company;

import javax.security.auth.DestroyFailedException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Exercicis:\n1. 1.5.\n2. 1.6. i 1.8.\n3. 1.7.\n4. 2.1.");
        int menu = scanner.nextInt();

        switch(menu) {
            case 1:
                HacerCosas.exercici5();
                break;
            case 2:
                HacerCosas.exercici6();
                break;
            case 3:
                HacerCosas.exercici7();
                break;
            case 4:
                ExerciciFitxer.exercici1();
        }

    }
}

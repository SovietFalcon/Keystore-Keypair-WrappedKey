package com.company;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HacerCosas {

    //Exercici 5
    public static void exercici5() {

        //La generació de la clau en base al mètode
        SecretKey key = Xifrar.keygenKeyGeneration(256);

        String texto = "la criptografia esta guai"; //text en clar
        System.out.println("Text sense compilar: " + texto);

        //Passem el text en clar a un array de bytes, i ho mostrem
        byte[] textoEnBytes = texto.getBytes();
        //System.out.println(textoEnBytes);

        //;

        //Fem servir el mètode encryptData i la passem a String
        byte[] textoCompiladoenBytes = Xifrar.encryptData(key, textoEnBytes);
        String textoCompilado = new String(textoCompiladoenBytes, StandardCharsets.UTF_8);

        //Veiem que està compilat i no s'entén
        System.out.println("Text compilat: " + textoCompilado);

        //Fem servir el mètode decryptData per desxifrar i ho passem a String també
        byte[] textoDescompiladoenBytes = Xifrar.decryptData(key, textoCompiladoenBytes);
        String textoDescompilado = new String (textoDescompiladoenBytes, StandardCharsets.UTF_8);

        System.out.println("Text descompilat: " + textoDescompilado);

    }

    //Exercicis 6 i 8
    public static void exercici6() {

        Scanner scanner = new Scanner(System.in);

        //Generem la key amb el mètode i fiquem "icampos", el meu nom, com a contrasenya
        SecretKey key = Xifrar.passwordKeyGeneration("icampos", 256);

        String texto = "Exemple de text";

        System.out.println("Text sense compilar: " + texto);

        //Passem el text en clar a un array de bytes, i ho mostrem
        byte[] textoEnBytes = texto.getBytes();
        //System.out.println(textoEnBytes);

        //;

        //Fem servir el mètode encryptData i la passem a String
        byte[] textoCompiladoenBytes = Xifrar.encryptData(key, textoEnBytes);
        String textoCompilado = new String(textoCompiladoenBytes, StandardCharsets.UTF_8);

        //Veiem que està compilat i no s'entén
        System.out.println("Text compilat: " + textoCompilado);


        //Li diem a l'usuari que faci servir una contrasenya. Si és correcta, funcionarà. Si no, no.
        //I sortirà un error.

        System.out.print("Password: ");
        SecretKey clavepalabra = Xifrar.passwordKeyGeneration(scanner.nextLine(), 256);


        try {
            byte[] textoDescompiladoenBytes = Xifrar.decryptData(clavepalabra, textoCompiladoenBytes);
            String textoDescompilado = new String(textoDescompiladoenBytes, StandardCharsets.UTF_8);

            System.out.println("Text descompilat: " + textoDescompilado);
        } catch (Exception e) {
            //System.out.println("Contrasenya incorrecta!");
        }

    }

    //Exercici 7
    public static void exercici7() throws Exception {

        SecretKey key = Xifrar.passwordKeyGeneration("prova exercici 7", 256);

        System.out.println("toString: " + key.toString());
        System.out.println("Aconseguir tipus d'algoritme (.getAlgorithm): " + key.getAlgorithm());
        System.out.println("Aconseguir el tipus de format (.getFormat) : " + key.getFormat());
        System.out.println("La clau ha sigut destruïda? : " + key.isDestroyed());

        //Aquest .equals s'utilitza per veure si dues claus són iguals
        System.out.println("Aquesta key és igual a si mateixa (key.equals(key)) ? : " + key.equals(key));


    }

}

package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExerciciFitxer {

    public static void exercici1() throws Exception {

        //Creem el File, reader i buffered necessari de l'arxiu de claus.
        File f = new File("C:/Users/I/Desktop/exercici/clausA4.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br =  new BufferedReader(fr);

        //Creem el path de l'arxiu binari i llegim tot el contingut, passant-lo a un array de Bytes
        Path path = Paths.get("C:/Users/I/Desktop/exercici/textamagat");
        byte[] textenbytes = Files.readAllBytes(path);

        String line = br.readLine();
        while(line != null ) {
            SecretKey clau = Xifrar.passwordKeyGeneration(line, 128); //Passem la línia a SecretKey

            byte[] textenbytesdesxifrat = Xifrar.decryptData(clau,textenbytes); //Intentem desxifrar el contingut

            if (textenbytesdesxifrat != null) { //Si es desxifra, mostra una serie d'informació.
                System.out.println("CLAU CORRECTA! : " + line);
                System.out.println("Text desxifrat:");
                String textdesxifrat = new String(textenbytesdesxifrat,"UTF8");
                System.out.println(textdesxifrat);
                break; //i es trenca el bucle
            }

            line = br.readLine(); //Si no es desxifra, es llegeix una nova línia.
        }

    }

}

package com.company;

import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Scanner;

public class HacerCosas {

    //Exercici 1.1
    public static void exercici11() throws Exception {

        String text = "Aquest és un missatge d'exemple !";
        System.out.println("Missatge en qüestió: " + text + "\n");
        byte[] textenbytes = text.getBytes();

        //Generem el parell de claus
        KeyPair key = Xifrar.randomGenerate(1024);

        //Xifrem el missatge i el xifrem amb la clau pública
        byte[] textxifratenbytes = Xifrar.encryptData(textenbytes,key.getPublic());
        String textxifrat = new String(textxifratenbytes,"UTF-8");

        System.out.println("Missatge xifrat: ");
        System.out.println(textxifrat);
        System.out.println();

        //Desxifrem el missatge amb la clau privada
        byte[] textdesxifratenbytes = Xifrar.decryptData(key.getPrivate(),textxifratenbytes);

        String textdesxifrat = new String(textdesxifratenbytes,"UTF-8");

        System.out.println("Missatge desxifrat: " + textdesxifrat);

    }

    //Exercici 1.2
    public static void exercici12() throws Exception{

        //Generem el parell de claus
        KeyPair key = Xifrar.randomGenerate(1024);

        Scanner scanner = new Scanner(System.in);

        //Demanem el missatge
        System.out.println("Escriu el missatge que vols xifrar:");
        String missatge = scanner.nextLine();
        byte[] missatgeenbytes = missatge.getBytes();

        //Xifrem el missatge i el xifrem amb la clau pública
        byte[] missatgexifratenbytes = Xifrar.encryptData(missatgeenbytes,key.getPublic());
        String textxifrat = new String(missatgexifratenbytes,"UTF-8");

        System.out.println("Missatge xifrat: ");
        System.out.println(textxifrat);
        System.out.println();

        //Desxifrem el missatge amb la clau privada
        byte[] missatgedesxifratenbytes = Xifrar.decryptData(key.getPrivate(),missatgexifratenbytes);

        String textdesxifrat = new String(missatgedesxifratenbytes,"UTF-8");

        System.out.println("Missatge desxifrat: " + textdesxifrat);


    }

    //Exercici 1.3
    public static void exercici13() throws Exception {

        KeyPair key = Xifrar.randomGenerate(1024);

        System.out.println("---- Clau pública ----");
        System.out.println(key.getPublic());
        System.out.println();
        System.out.println("-- getAlgorithm --");
        System.out.println(key.getPublic().getAlgorithm());
        System.out.println();
        System.out.println("-- getEncoded --");
        System.out.println(key.getPublic().getEncoded());
        System.out.println();
        System.out.println("---- Clau privada ----");
        System.out.println(key.getPrivate());
        System.out.println();
        System.out.println("-- getFormat --");
        System.out.println(key.getPrivate().getFormat());

    }

    //Exercici 2.1
    public static void exercici21() throws Exception {

        KeyStore keystore = Xifrar.loadKeyStore("C:\\Users\\I\\Desktop\\keystore.ks","usuari");

        System.out.println("-- Tipus de Keystore: " + keystore.getType());
        System.out.println("-- Mida del magatzem: " + keystore.size() + " clau/s.");
        System.out.println("-- Àlies de les claus:");
        System.out.println(keystore.aliases().asIterator().next());
        System.out.println();
        System.out.println("-- Certificat d'una de les claus: " + keystore.getCertificate(keystore.aliases().nextElement()));
        System.out.println();
        System.out.println("-- Algorisme de xifrat: " + keystore.getKey("lamevaclaum9","usuari".toCharArray()).getAlgorithm());

    }

    //Exercici 2.2
    public static void exercici22() throws Exception {

        KeyStore keystore = Xifrar.loadKeyStore("C:\\Users\\I\\Desktop\\keystore.ks","usuari");

        SecretKey key = Xifrar.keygenKeyGeneration(256);

        KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection("usuari".toCharArray());
        KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(key);

        keystore.setEntry("clauexercici",skEntry,protParam);
        FileOutputStream fOutput = new FileOutputStream("C:\\Users\\I\\Desktop\\keystore.ks");
        keystore.store(fOutput,"usuari".toCharArray());
        fOutput.close();

    }

    //Exercici 2.3
    public static void exercici23() throws Exception {

        FileInputStream file = new FileInputStream("C:\\Users\\I\\Desktop\\jordi.cer");
        CertificateFactory cf = CertificateFactory.getInstance("X.509");



    }

    //Exercici 2.4
    public static void exercici24() throws Exception {



    }

}

package com.company;

import javax.crypto.SecretKey;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Metodos {
    static String clave, textoOriginal;
    public static void unoCinco() {
        SecretKey secretKey = Xifrar.keygenKeyGeneration(128);
        String text = "hola rata";
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        byte[] encriptado = Xifrar.encryptData(secretKey, bytes);
        byte[] decriptado = Xifrar.decryptData(secretKey, encriptado);

        String msg = new String(decriptado, 0, decriptado.length).toLowerCase();
        System.out.println("1.5");
        System.out.println("Texto original: " + text);
        System.out.println("Texto en bytes: " + bytes);
        System.out.println("Byte encriptado: " + encriptado);
        System.out.println("Byte decriptado: " + decriptado);
        System.out.println("texto final: " + msg);
        System.out.println();
    }

    public static void unoSeis() {
        SecretKey secretKey1 = Xifrar.passwordKeyGeneration("ratita", 128);
        String text1 = "Xiao ratita";
        byte[] bytes1 = text1.getBytes(StandardCharsets.UTF_8);

        byte[] encriptado1 = Xifrar.encryptData(secretKey1, bytes1);
        byte[] decriptado1 = Xifrar.decryptData(secretKey1, encriptado1);

        String msg1 = new String(decriptado1, 0, decriptado1.length).toLowerCase();
        System.out.println("1.6");
        System.out.println("Texto original: " + text1);
        System.out.println("Texto en bytes: " + bytes1);
        System.out.println("Byte encriptado: " + encriptado1);
        System.out.println("Byte decriptado: " + decriptado1);
        System.out.println("Secret Key: " + secretKey1);
        System.out.println("texto final: " + msg1);
        System.out.println();
    }

    public static void unoSiete() {
        SecretKey secretKey = Xifrar.keygenKeyGeneration(128);
        System.out.println("1.7");
        System.out.println(secretKey.getEncoded());
        System.out.println(secretKey.getAlgorithm());
        System.out.println(secretKey.isDestroyed());
        System.out.println(secretKey.getFormat());
        System.out.println();
    }

    public static void unoOcho(){
        System.out.println("1.8");
        SecretKey secretKey = Xifrar.passwordKeyGeneration("ratita", 128);
        SecretKey keyFalsa = Xifrar.passwordKeyGeneration("ratitas", 128);
        String text = "Xiao ratita";
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        byte[] encriptado = Xifrar.encryptData(secretKey, bytes);
        byte[] decriptado = Xifrar.decryptData(keyFalsa, encriptado);
        System.out.println();
    }

    public static void dosUltimo() {
        System.out.println("2");
        Path path = Paths.get("src/Carpeta/textamagat");
        byte[] textbytes;
        try {
            textbytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File f1 = new File("src/Carpeta/clausA4.txt");
        FileReader fr;
        {
            try {
                fr = new FileReader(f1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        {
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        while(line != null){
            for (int i = 0; i < 256; i++) {
                try{
                    SecretKey secretKey = Xifrar.passwordKeyGeneration(line, i);
                    byte[] desencriptado = Xifrar.decryptData(secretKey, textbytes);
                    String msg = new String(desencriptado, 0, desencriptado.length);

                    clave = line;
                    textoOriginal = msg;
                    break;
                }  catch (Exception e){

                }
            }
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(clave + "\n" + textoOriginal);
    }
}

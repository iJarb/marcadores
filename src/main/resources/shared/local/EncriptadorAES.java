package com.bbva.smre.lib.rf10.local;

import lombok.SneakyThrows;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


import com.bbva.smre.lib.rf10.helpers.LogerUtils;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class EncriptadorAES {
	
 private EncriptadorAES() {
   /* This utility class should not be instantiated */
 }


	private static final int GCM_TAG_LENGTH = 128; // En bits
    private static final int IV_LENGTH = 12; // En bytes (recomendado para GCM)
    private static final int ITERACIONES = 65536; // Iteraciones de PBKDF2
    private static final int KEY_LENGTH = 256; // En bits
    private static final int SALT_LENGTH = 16;

    
    @SneakyThrows
    public static byte[] cifrarV1(String textoPlano, String password) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERACIONES, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        byte[] iv = new byte[IV_LENGTH];
        secureRandom.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        byte[] textoCifrado = cipher.doFinal(textoPlano.getBytes(StandardCharsets.UTF_8));

        ByteBuffer byteBuffer = ByteBuffer.allocate(salt.length + iv.length + textoCifrado.length);
        byteBuffer.put(salt);
        byteBuffer.put(iv);
        byteBuffer.put(textoCifrado);
        return byteBuffer.array();
        //return Base64.getEncoder().encodeToString(byteBuffer.array());
    }

    
    @SneakyThrows
    public static String descifrarV1(byte[] datosCompletos, String password) {
        //byte[] datosCompletos = Base64.getDecoder().decode(textoCifradoBase64);
        ByteBuffer byteBuffer = ByteBuffer.wrap(datosCompletos);

        byte[] salt = new byte[SALT_LENGTH];
        byteBuffer.get(salt);

        byte[] iv = new byte[IV_LENGTH];
        byteBuffer.get(iv);

        byte[] textoCifrado = new byte[byteBuffer.remaining()];
        byteBuffer.get(textoCifrado);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERACIONES, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

        byte[] textoPlano = cipher.doFinal(textoCifrado);

        return new String(textoPlano, StandardCharsets.UTF_8);
    }
    public static String cifrar(String textoPlano, String password) {
        byte[] bytesTexto = textoPlano.getBytes(StandardCharsets.UTF_8);
        
        // CORRECCIÓN: Forzamos que la clave se genere de forma determinista usando el Hash de su texto plano
        byte[] bytesClave = generarClaveBinaria(password);
        
        byte[] resultado = transformar(bytesTexto, bytesClave);
        return Base64.getEncoder().encodeToString(resultado);
    }

    public static String descifrar(String textoCifradoBase64, String password) {
        // CORRECCIÓN: Reemplaza espacios por '+' por si Eclipse alteró el portapapeles
        String textoSanitizado = textoCifradoBase64.replace(" ", "+").trim().replaceAll("\\s", "");
        
        byte[] bytesCifrados = Base64.getDecoder().decode(textoSanitizado);
        byte[] bytesClave = generarClaveBinaria(password);
        
        byte[] resultado = transformar(bytesCifrados, bytesClave);
        return new String(resultado, StandardCharsets.UTF_8);
    }

    // Genera un bloque de 32 bytes estable para la clave, sin importar el encoding de la JVM
    private static byte[] generarClaveBinaria(String password) {
        byte[] passBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] claveFija = new byte[32]; // Llave de 256 bits estática
        for (int i = 0; i < passBytes.length; i++) {
            claveFija[i % 32] ^= passBytes[i];
        }
        return claveFija;
    }

    private static byte[] transformar(byte[] entrada, byte[] clave) {
        int[] s = new int[256];
        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + (clave[i % clave.length] & 0xFF)) & 0xFF;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        byte[] salida = new byte[entrada.length];
        int i = 0;
        j = 0;
        for (int k = 0; k < entrada.length; k++) {
            i = (i + 1) & 0xFF;
            j = (j + s[i]) & 0xFF;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            int t = (s[i] + s[j]) & 0xFF;
            salida[k] = (byte) (entrada[k] ^ s[t]);
        }
        return salida;
    }    
    public static void toTest() {
        
            String passwordSecreto = "oficiosIA.By.BBVA.AYESA";
            String mensajeOriginal = "Este es un mensaje ultra secreto.";

            String mensajeCifrado = cifrar(mensajeOriginal, passwordSecreto);
            LogerUtils.textLog("Texto Cifrado: " + mensajeCifrado);

            String mensajeDescifrado = descifrar(mensajeCifrado, passwordSecreto);
            LogerUtils.textLog("Texto Descifrado: " + mensajeDescifrado);

        
    }
    
    @SneakyThrows
	public static byte[] readResourceFile(String resourcePath) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
	    
	    if (is == null) {
	        return new byte[0]; // Sintaxis correcta para un array vacío de longitud cero
	    }
	    
	    byte[] iapClientIdEnc = is.readAllBytes();
	    is.close();
	    
	    return iapClientIdEnc;
	}
}

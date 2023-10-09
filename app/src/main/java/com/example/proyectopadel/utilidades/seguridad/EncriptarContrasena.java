package com.example.proyectopadel.utilidades.seguridad;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncriptarContrasena {
    private String secreto;

    public SecretKeySpec generarKey(String llave){
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec sk = new SecretKeySpec(cadena, "AES");
            return sk;
        } catch (Exception e) {
            return null;
        }
    }

    // Encriptar
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String encriptar(String encriptar) {
        try {
            SecretKeySpec sk = generarKey(secreto);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, sk);
            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptado = cipher.doFinal(cadena);
            String cadena_encriptada = Base64.getEncoder().encodeToString(encriptado);
            return cadena_encriptada;
        } catch (Exception e) {
            return "";
        }
    }
    // Desencriptar
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String desencriptar(String desencriptar){
        try {
            SecretKeySpec sk = generarKey(secreto);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, sk);
            byte[] cadena = Base64.getDecoder().decode(desencriptar);
            byte[] desencriptado = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptado);
            return cadena_desencriptada;
        } catch (Exception e) {
            return "";
        }
    }
}

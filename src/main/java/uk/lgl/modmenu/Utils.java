package uk.lgl.modmenu;

import android.content.Context;
import android.util.Base64;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


class Utils {
	
	protected static String encript(String enc) {
        if (enc.equals("!")) {
            return "a";
        } else if (enc.equals(";")) {
            return "b";
        } else if (enc.equals('"')) {
            return "c";
        } else if (enc.equals("#")) {
            return "d";
        } else if (enc.equals("÷")) {
            return "e";
        } else if (enc.equals("$")) {
            return "f";
        } else if (enc.equals("%")) {
            return "g";
        } else if (enc.equals("^")) {
            return "h";
        } else if (enc.equals("£")) {
            return "i";
        } else if (enc.equals("&")) {
            return "j";
        } else if (enc.equals("*")) {
            return "k";
        } else if (enc.equals("(")) {
            return "l";
        } else if (enc.equals("?")) {
            return "m";
        } else if (enc.equals(",")) {
            return "n";
        } else if (enc.equals("¥")) {
            return "o";
        } else if (enc.equals("₩")) {
            return "p";
        } else if (enc.equals("+")) {
            return "q";
        } else if (enc.equals("=")) {
            return "r";
        } else if (enc.equals("@")) {
            return "s";
        } else if (enc.equals("/")) {
            return "t";
        } else if (enc.equals("€")) {
            return "u";
        } else if (enc.equals(":")) {
            return "v";
        } else if (enc.equals("×")) {
            return "w";
        } else if (enc.equals("'")) {
            return "x";
        } else if (enc.equals("_")) {
            return "y";
        } else if (enc.equals("-")) {
            return "z";
        }
        return "FALHA!!!";
	}

    private static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }



    static String readStream(InputStream in) throws IOException {


        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = "";


            while ((line = reader.readLine()) != null) {
                response.append(line);


            }
        }   {
        }
        return response.toString();
    }




    static String SHA256(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            md.update(data.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(md.digest()).toUpperCase();
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }

    static void clearCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteFilesInDir(dir);
        } catch (Exception ignored) {}
    }

    private static void deleteFilesInDir(File dir) {
        for (File file: dir.listFiles()) {
            if (file.isDirectory()) {
                deleteFilesInDir(file);
            }
            file.delete();
        }
    }

    static byte[] loaderDecrypt(byte[] srcdata){
        try {
            SecretKeySpec skey = new SecretKeySpec("22P9ULFDKPJ70G46".getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            return cipher.doFinal(srcdata);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    static String profileDecrypt(String data, String sign) {
        char[] key = sign.toCharArray();
        char[] out = fromBase64String(data).toCharArray();
        for(int i = 0; i < out.length;i++){
            out[i] = (char)(key[i % key.length] ^ out[i]);
        }
        return new String(out);
    }

    static String toBase64(String s) {
        return Base64.encodeToString(s.getBytes(StandardCharsets.UTF_8), Base64.NO_WRAP);
    }

    static String toBase64(byte[] s) {
        return Base64.encodeToString(s, Base64.NO_WRAP);
    }

    static byte[] fromBase64(String s) {
        return Base64.decode(s, Base64.NO_WRAP);
    }

    static String fromBase64String(String s) {
        return new String(Base64.decode(s, Base64.NO_WRAP), StandardCharsets.UTF_8);
    }
	
	
	}

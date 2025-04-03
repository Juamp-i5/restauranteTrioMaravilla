package pantallas;


import java.util.Base64;

/**
 *
 * @author pablo
 */
public class Encriptador {  
    public static String encriptarBase64(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String desencriptarBase64(String encryptedData) {
        return new String(Base64.getDecoder().decode(encryptedData));
    }
}

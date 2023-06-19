
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Main {

    private static final String ALGORITHM = "DES";

    // 将原始字符串加密为base64编码的字符串
    public static String encrypt(String keyStr, String plainText) throws Exception {
        Key key = generateKey(keyStr);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // 将base64编码的字符串解密为原始字符串
    public static String decrypt(String keyStr, String encryptedText) throws Exception {
        Key key = generateKey(keyStr);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, "UTF-8");
    }

    private static Key generateKey(String keyStr) throws Exception {
        byte[] keyBytes = keyStr.getBytes("UTF-8");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        return keySpec;
    }

    public static void main(String[] args) throws Exception {
        String keyStr = "12345678"; // 指定密钥
        String plainText = "hello world"; // 指定明文

        // 加密
        String encryptedText = encrypt(keyStr, plainText);
        System.out.println("加密后的字符串为：" + encryptedText);

        // 解密
        String decryptedText = decrypt(keyStr, encryptedText);
        System.out.println("解密后的字符串为：" + decryptedText);
    }
}

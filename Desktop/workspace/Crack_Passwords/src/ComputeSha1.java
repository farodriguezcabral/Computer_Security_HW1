import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class ComputeSha1 {

    public static void main(String[] args) throws Exception {
        MessageDigest hash = MessageDigest.getInstance("SHA1");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(" Enter string you want to hash: ");
        String toHash = in.readLine();
        hash.update(toHash.getBytes());
        byte[] digest = hash.digest();
        System.out.println(DatatypeConverter.printHexBinary(digest).toLowerCase());
    }
}
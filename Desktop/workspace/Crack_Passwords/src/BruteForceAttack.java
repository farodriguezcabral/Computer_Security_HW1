import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.*;
public class BruteForceAttack {
	
	public static void main (String [] args)throws IOException{
		
		Scanner input = new Scanner(new File("randPwdFile0Solutions.txt"));
		
		HashMap<String,String> users = new HashMap<String,String>();
		input.nextLine();
		String user = "";
		String hashedPassword = "";
		while(input.hasNextLine()){
			String line = input.nextLine();
			
			StringTokenizer st = new StringTokenizer(line, ", ");
			while(st.hasMoreTokens()){
				user = st.nextToken();
				hashedPassword = st.nextToken();
				
			}
			users.put(user, hashedPassword);
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	private static String computeSha1(String word) throws Exception{
		
		   MessageDigest hash = MessageDigest.getInstance("SHA1");
	       // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      //  System.out.print(" Enter string you want to hash: ");
	        String toHash = word;
	        hash.update(toHash.getBytes());
	        byte[] digest = hash.digest();
	        return DatatypeConverter.printHexBinary(digest).toLowerCase();
	}

}

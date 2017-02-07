
import java.io.*;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import java.util.StringTokenizer;
import java.util.Scanner;

public class DictionaryAttack {
	public static void main (String [] args)throws IOException {
		
		Scanner file = new Scanner(new File("dictPwdFile0Solutions.txt"));
		
		
		String hashedPassword = "";
		String user = "";
		String salt = "";
		//avoid statement describing content of text file
		file.nextLine();
		while(file.hasNextLine()){
			String line = file.nextLine();
			//separate each line by ", " character into different tokens
			StringTokenizer st = new StringTokenizer(line, ", ");
			//store the tokens to their corresponding strings
			user = st.nextToken();
			salt = st.nextToken();
			hashedPassword = st.nextToken();
			Scanner dictionary = new Scanner (new File("wordsEn.txt"));
			while(dictionary.hasNextLine()){
				String word = dictionary.nextLine();
				String hashedWord = "";
				try {
					hashedWord = computeSha1(word+salt);
					//System.out.println(hashedWord);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(hashedWord.equals(hashedPassword)){
					System.out.println("username: "+user+" Password:"+word);
					
					
				}
				
				
			}
			
		}
		System.out.println((String)(new String(new char[] { 65 })+""+new String(new char [] {66})));
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

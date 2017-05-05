package challenges.challenge2;

public class ReverseString {
	
	 static String reverseMe(String s) {
		   StringBuilder sb = new StringBuilder();
		   for(int j = s.length()-1; j >=0; --j)
		     sb.append(s.charAt(j));
		   return sb.toString();
		 }

}

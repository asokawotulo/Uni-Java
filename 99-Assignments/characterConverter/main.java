public class main {
	public static char convertToUpper(int sh){
		int result = sh + x;
		return (char)result;
	}
	public static char convertToLower(int sh){
		int result = sh - x;
		return (char)result;
	}
    public static void main(String[] args) {
    	char ch_input = 'a';
    	// char result = (ch_input >= 'A' & ch_input <= 'Z') | (ch_input >= 'a' & ch_input <= 'z') ? convertToLower(ch_input) : convertToUpper(ch_input);
    	char result = ' ';
    	if((ch_input >= 'A' & ch_input <= 'Z') | (ch_input >= 'a' & ch_input <= 'z')){
	    	if(ch_input >= 'A' & ch_input <= 'Z'){
	    		result = convertToLower(ch_input);
	    	}
	    	else {
	    		result = convertToUpper(ch_input);
	    	}	
	    	System.out.println("Case becomes: " + result);
    	}
    	else {
    		System.out.println("Case not acceptable");
    	}
    }
}
package utils;

public class UtilityMethodes {
	public String hashPassword(String password, int age) {
		char[] pass = password.toCharArray();
		int i, j = password.length() - 1;
		char[] reversedPassword = new char[password.length()];
		for ( i = 0; i < password.length(); i++) {
			reversedPassword[j] = pass[i];
			j--;
		}
		String hassPassword = "**"+age+""+String.valueOf(reversedPassword)+"**";
		return hassPassword;
	}
}

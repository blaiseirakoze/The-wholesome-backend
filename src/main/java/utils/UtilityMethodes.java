package utils;

import com.google.gson.Gson;

/**
 * blaise irakoze
 */
public class UtilityMethodes {
    /**
     * hash password
     *
     * @param password
     * @param age
     * @return
     */
    public String hashPassword(String password, int age) {
//        string to characters
        char[] pass = password.toCharArray();
        int i, j = password.length() - 1;
        char[] reversedPassword = new char[password.length()];
//        reversing password
        for (i = 0; i < password.length(); i++) {
            reversedPassword[j] = pass[i];
            j--;
        }
//        return hashed password
        String hassPassword = "**" + age + "" + String.valueOf(reversedPassword) + "**";
        return hassPassword;
    }

    /**
     * compare password
     *
     * @param password
     * @param hashPassword
     * @param age
     * @return
     */
    public boolean comparePassword(String password, String hashPassword, int age) {
//        remove the asterix and age added to password in first place
        hashPassword = hashPassword.replace("**", "");
        hashPassword = hashPassword.replace(String.valueOf(age), "");
//        string to characters
        char[] pass = hashPassword.toCharArray();
        int i, j = hashPassword.length() - 1;
        char[] reversedPassword = new char[hashPassword.length()];
//        reverse back the password
        for (i = 0; i < hashPassword.length(); i++) {
            reversedPassword[j] = pass[i];
            j--;
        }
//        return true if matches or false if doesn't
        if (String.valueOf(reversedPassword).equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * serialize response to json
     *
     * @param object
     * @return
     */
    public String serializeResponse(Object object) {
        Gson gson = new Gson();
        Object obj = object;
        String msgJSON = gson.toJson(obj);
        return msgJSON;
    }
}

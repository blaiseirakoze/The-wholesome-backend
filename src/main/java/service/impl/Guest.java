package service.impl;

import enumerator.ESEX;
import model.LoginMessage;
import model.Message;
import model.User;
import service.IUser;
import utils.UtilityMethodes;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * blaise irakoze
 */
public class Guest implements IUser {

    private UtilityMethodes utilityMethodes = new UtilityMethodes();

    /**
     * add a new user service
     *
     * @param
     * @return
     * @throws IOException
     */
    @Override
    public String register(User user, LinkedHashMap<String, User> linkedHashMap) {
//       check sex
        if (user.getSex() == ESEX.male || user.getSex() == ESEX.female) {
//        check if password length is 10
            if (user.getPassword().length() == 5) {
                boolean result = user.getPassword().matches("(?:\\d+[a-z]|[a-z]+\\d)[a-z\\d]*");
//          check if password rules match and hash the password
                if (result) {
                    user.setPassword(utilityMethodes.hashPassword(user.getPassword(), user.getAge()));
//              check if the user exists
                    boolean userExist = false;
                    Iterator<User> it = linkedHashMap.values().iterator();
                    while (it.hasNext()) {
                        User currentUser = (User) it.next();
                        if (currentUser.getUsername().toLowerCase().equals(user.getUsername().toLowerCase())) {
                            userExist = true;
                        }
                    }
//                return if exists
                    if (userExist) {
                        return utilityMethodes.serializeResponse(new Message("user already exist"));
                    }
//                create the user and return if doesn't exist
                    linkedHashMap.put(new User().getId(), user);
                    return utilityMethodes.serializeResponse(new Message("user created successful"));
                }
                return utilityMethodes.serializeResponse(new Message("Password rules not met"));
            }
            return utilityMethodes.serializeResponse(new Message("Password rules not met"));
        }
        return utilityMethodes.serializeResponse(new Message("sex should be male or female"));
    }

    /**
     * login service
     *
     * @param
     * @return
     * @throws IOException
     */
    @Override
    public String login(User user, LinkedHashMap<String, User> linkedHashMap) {
        Iterator<User> it = linkedHashMap.values().iterator();
        boolean userFound = false;
        User usr = new User();
//        loop through users to find the user
        while (it.hasNext()) {
            User currentUser = (User) it.next();
            if (currentUser.getUsername().toLowerCase().equals(user.getUsername().toLowerCase())) {
                if (utilityMethodes.comparePassword(user.getPassword(), currentUser.getPassword(),
                        currentUser.getAge())) {
                    userFound = true;
                    usr = currentUser;
                }
            }
        }
//        return success if found
        if (userFound) {
            return utilityMethodes.serializeResponse(new LoginMessage("success", usr.getFirstName() + " " + usr.getLastName(), usr.getRole()));
        }
//        return fail if not found
        return utilityMethodes.serializeResponse(new LoginMessage("fail", usr.getFirstName() + "" + usr.getLastName(), usr.getRole()));
    }
}

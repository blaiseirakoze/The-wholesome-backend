package service;

import java.util.LinkedHashMap;

import model.User;

/**
 * blaise irakoze
 */
public interface IUser {
    /**
     * register a user inteface
     *
     * @param user
     * @param usersList
     * @return
     */
    public String register(User user, LinkedHashMap<String, User> usersList);

    /**
     * login interface
     *
     * @param user
     * @param usersList
     * @return
     */
    public String login(User user, LinkedHashMap<String, User> usersList);
}

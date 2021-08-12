package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import model.Message;
import model.User;
import utils.UtilityMethodes;

public class UserService {
	List<User> users = new ArrayList<User>();
	LinkedHashMap<String, User> linkedHashMap = new LinkedHashMap<String, User>();
	private UtilityMethodes utilityMethodes = new UtilityMethodes();

	public LinkedHashMap<String, User> getUsers() {
		return linkedHashMap;
	}
	
	public String addUser(HttpServletRequest request) throws IOException {
		StringBuilder sb = new StringBuilder();
		String s = null;
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }
        JSONObject jsonObj = new JSONObject(sb.toString());
        Gson gson = new Gson();
        User user = gson.fromJson(jsonObj.toString(), User.class);
        user.setPassword(utilityMethodes.hashPassword(user.getPassword(), user.getAge()));
        linkedHashMap.put(new User().getId(), user);
        Message message = new Message("user created successful");
        Object obj=message; 
		String msgJSON = gson.toJson(obj);
		return msgJSON;
	}

}

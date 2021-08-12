package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.User;
import service.UserService;
import org.json.JSONObject;
/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns = {"/users"} , name = "user controller", description = "user controller")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	List<User> users = new ArrayList<User>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		users = userService.getUsers();
		
		Gson gson = new Gson();
		String userJSON = gson.toJson(users);
		
		PrintWriter printWriter = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		printWriter.write(userJSON);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();
		String s = null;
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }
        JSONObject jsonObj = new JSONObject(sb.toString());
        Gson gson = new Gson();
        User user = gson.fromJson(jsonObj.toString(), User.class);
        List<User> newUsers = users = userService.addUser(user);
	}

}

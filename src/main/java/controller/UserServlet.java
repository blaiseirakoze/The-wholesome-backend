package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import enumerator.EROLE;
import model.Message;
import model.User;
import service.IUser;
import service.impl.Admin;

import org.json.JSONObject;
import service.impl.Guest;

/**
 * Servlet implementation class UserController
 */
public class UserServlet extends HttpServlet {

    IUser admin = new Admin();
    IUser guest = new Guest();
    LinkedHashMap<String, User> usersList = new LinkedHashMap<String, User>();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//          print out the users list
            usersList.values();
            Gson gson = new Gson();
            String userJSON = gson.toJson(usersList.values());
            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
            printWriter.write(userJSON);
            printWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StringBuilder sb = new StringBuilder();
            String s = null;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
            }
            JSONObject jsonObj = new JSONObject(sb.toString());
            Gson gson = new Gson();
            User user = gson.fromJson(jsonObj.toString(), User.class);
            String msgJSON = "";
//            login
            if (user.getType().equals("login")) {
                if (user.getPassword().length() == 10) {
                    msgJSON = admin.login(user, usersList);
                } else if (user.getPassword().length() == 5) {
                    msgJSON = guest.login(user, usersList);
                } else {
                    Message message = new Message("fail");
                    Object obj = message;
                    msgJSON = gson.toJson(obj);
                }
//                register new user
            } else {
                if (user.getRole() == EROLE.admin) {
                    msgJSON = admin.register(user, usersList);
                } else if (user.getRole() == EROLE.guest) {
                    msgJSON = guest.register(user, usersList);
                } else {
                    Message message = new Message("role should be admin or guest");
                    Object obj = message;
                    msgJSON = gson.toJson(obj);
                }
            }
//            print out the reponse
            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
            printWriter.write(msgJSON);
            printWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

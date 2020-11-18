package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("logout")) {
                request.setAttribute("message", "You have successfully logged out.");

                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        } else {
            if (session.getAttribute("username") != null) {
                request.setAttribute("user", session.getAttribute("username"));
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String itemToAdd = request.getParameter("itemAdd");
        String itemToDelete = request.getParameter("itemDel");
        String action = request.getParameter("action");
        ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");

        switch (action) {
            case "register":
                session.setAttribute("username", username);
                break;
            case "add":
                if (itemList == null) {
                    itemList = new ArrayList();
                }
                itemList.add(itemToAdd);
                break;
            case "delete":
                itemList.remove(itemToDelete);
                break;
        }

        session.setAttribute("itemList", itemList);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

    }
}

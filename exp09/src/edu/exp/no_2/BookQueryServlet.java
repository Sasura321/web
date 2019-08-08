package edu.exp.no_2;

import edu.exp.no_1.BookBean;
import edu.exp.no_1.BookDAO;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "BookQueryServlet")
public class BookQueryServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String bookid = request.getParameter("bookid");
        BookDAO bookdao = new BookDAO();
        BookBean book = bookdao.searchBook(bookid);

        if(book!=null){
            request.getSession().setAttribute("book", book);
            RequestDispatcher view = request.getRequestDispatcher("/display.jsp");
            view.forward(request, response);
        }else{
            RequestDispatcher view = request.getRequestDispatcher("/errorPage.jsp");
            view.forward(request, response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}

package edu.exp.no_2;

import edu.exp.no_1.BookBean;
import edu.exp.no_1.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("gb2312");
        String message = null;
        BookBean book = new BookBean(
                request.getParameter("bookid"),request.getParameter("title"),
                request.getParameter("author"),request.getParameter("publisher"),
                Float.parseFloat(request.getParameter("price"))
        );
        BookDAO bookdao = new BookDAO();
        boolean success = bookdao.insertBook(book);
        if(success){
            message = "成功插入一条记录！";
        }else{
            message = "插入记录错误！";
        }
        request.setAttribute("result",message);
        RequestDispatcher view = request.getRequestDispatcher("/bookInsert.jsp");
        view.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

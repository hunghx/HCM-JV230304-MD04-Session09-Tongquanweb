package ra.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "product", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println(" Khởi tạo servlet");
    }
    @Override
    public void destroy() {
        System.err.println("Hủy servlet");
    }
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Vào service");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Vào do get"); // a, gõ trực tiếp trên đường dẫn, form:get
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("vào do post"); // form:post
    }
}

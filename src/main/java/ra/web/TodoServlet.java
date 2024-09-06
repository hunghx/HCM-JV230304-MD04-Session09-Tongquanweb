package ra.web;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServlet", value = "/TodoServlet")
public class TodoServlet extends HttpServlet {
    protected static List<Todo> todoList = new ArrayList<>();
    static {
        todoList.add(new Todo(1,"Đi học", true));
        todoList.add(new Todo(2,"Đi ngủ", true));
        todoList.add(new Todo(3,"Đi chơi", false));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        displayTodoList(response);
        // lấy tham số gửi theo reuest lên
        String action = request.getParameter("action"); // lấy tham số theo thuộc tính năm
        if(action!=null){
            switch (action){
                case "GETALL":
                    displayTodoList(response);
                    break;
            }
        }

    }

    // chức năng hien thị

    protected void displayTodoList(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8"); // k tự đặc biêt

        String htmlBody = "";
        for (Todo todo: todoList){
            htmlBody +=
                    "  <tr>\n" +
                            "    <td>"+todo.getId()+"</td>\n" +
                            "    <td>"+todo.getContent()+"</td>\n" +
                            "    <td>"+(todo.isStatus()?"Xong":"Chưa Xong")+"</td>\n" +
                            "    <td><a href=\"\">Xóa<a></td>\n" +
                            "    <td>Sửa</td>\n" +
                            "  </tr>\n" ;
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<head>\n" +
                "  <title>Danh sach cong viec</title>\n" +
                "</head>" +
                "<body>");
        // phan bang

        out.println("<h1>Danh sach cong viec cua toi</h1>");
        out.println("<table border=\"10\" cellspacing=\"0\" cellpadding=\"15\">\n" +
                "  <thead>\n" +
                "  <tr>\n" +
                "    <th>STT</th>\n" +
                "    <th>Content</th>\n" +
                "    <th>Status</th>\n" +
                "    <th colspan=\"2\">Action</th>\n" +
                "  </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                "  <tr>\n" +htmlBody +
                "  </tbody>\n" +
                "</table>");


        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
package by.academy.it.task11;

import by.academy.it.task11.entity.Horse;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet(urlPatterns = "")
public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        class Category implements Serializable {
            private Integer id;
            private String title;

            public Category(Integer id, String title) {
                this.id = id;
                this.title = title;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }
        }
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        ObjectMapper mapper = new ObjectMapper();
        //String value = mapper.writeValueAsString(Horse.builder().id(1).nickname("Loshadka").build());
        String value = mapper.writeValueAsString(
                new Category[]{
                        new Category(1,"LOPATA"),
                        new Category(2,"Studying and rent horses service (dfljs djslf)")
                }
                );
        resp.getWriter().write(value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

   /* @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        //resp.setHeader("Access-Control-Allow-Methods", "GET");
    }*/
}

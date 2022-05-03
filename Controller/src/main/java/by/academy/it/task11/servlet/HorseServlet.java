package by.academy.it.task11.servlet;

import by.academy.it.task11.HorseService;
import by.academy.it.task11.ServiceException;
import by.academy.it.task11.ServiceProvider;
import by.academy.it.task11.entity.Horse;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/horse")
public class HorseServlet extends HttpServlet {
    private ObjectMapper mapper;
    private HorseService horseService;

    @Override
    public void init() throws ServletException {
        super.init();
        horseService = ServiceProvider.getInstance().getHorseService();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Horse> horses = null;
        try {
            horses = horseService.findAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        resp.getWriter().write(mapper.writeValueAsString(horses));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

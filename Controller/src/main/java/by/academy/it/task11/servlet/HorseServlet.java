package by.academy.it.task11.servlet;

import by.academy.it.task11.HorseService;
import by.academy.it.task11.entity.Horse;
import by.academy.it.task11.impl.HorseServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        horseService = new HorseServiceImpl();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("lopata");
        List<Horse> horses = horseService.findAll();
        resp.getWriter().write(mapper.writeValueAsString(horses));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

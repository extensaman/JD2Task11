package by.academy.it.task11.servlet;

import by.academy.it.task11.CoachService;
import by.academy.it.task11.ServiceException;
import by.academy.it.task11.ServiceProvider;
import by.academy.it.task11.entity.Coach;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/coach")
public class CoachServlet extends HttpServlet {
    private ObjectMapper mapper;
    private CoachService coachService;

    @Override
    public void init() throws ServletException {
        super.init();
        coachService = ServiceProvider.getInstance().getCoachService();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Coach> coaches = null;
        try {
            coaches = coachService.findAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.getWriter().write(mapper.writeValueAsString(coaches));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package by.academy.it.task11;

import by.academy.it.task11.impl.CoachServiceImpl;
import by.academy.it.task11.impl.HorseServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider INSTANCE = new ServiceProvider();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return INSTANCE;
    }

    public HorseService getHorseService() {
        return new HorseServiceImpl();
    }

    public CoachService getCoachService() {
        return new CoachServiceImpl();
    }
}

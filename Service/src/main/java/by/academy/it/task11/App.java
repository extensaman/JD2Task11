package by.academy.it.task11;

import by.academy.it.task11.impl.HorseServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        HorseService horseService = new HorseServiceImpl();
        System.out.println(horseService.findAll());
    }
}

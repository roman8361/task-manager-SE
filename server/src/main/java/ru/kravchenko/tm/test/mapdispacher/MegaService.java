package ru.kravchenko.tm.test.mapdispacher;

/**
 * @author Roman Kravchenko
 */
public class MegaService extends AbstractClass {

    @Override
    public String getName() {
        return "mega";
    }

    @Override
    public void execute() {
        System.out.println("EXECUTE MEGA SERVICE");
    }

}

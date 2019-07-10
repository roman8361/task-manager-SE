package ru.kravchenko.tm.test.mapdispacher;

/**
 * @author Roman Kravchenko
 */

class BestService extends AbstractClass {

    @Override
    public String getName() {
        return "best";
    }

    @Override
    public void execute() {
        System.out.println("EXECUTE BEST SERVICE");
    }

}

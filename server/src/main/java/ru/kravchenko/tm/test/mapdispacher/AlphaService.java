package ru.kravchenko.tm.test.mapdispacher;

/**
 * @author Roman Kravchenko
 */
public class AlphaService extends AbstractClass {

    private Integer count;

    public AlphaService(Integer count) {
        this.count = count;
    }

    @Override
    public String getName() {
        return "alpha";
    }

    @Override
    public void execute() {
        System.out.println("ALPHA is: " + count);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}

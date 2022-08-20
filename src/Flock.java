import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
    private List<Quackable> quackers;

    public Flock() {
        quackers = new ArrayList<>();
    }

    public void add(Quackable duck) {
        quackers.add(duck);
    }

    @Override
    public void quack() {
        Quackable duck = quackers.get(0);
        System.out.println("I'm leader");
        duck.quack();
        duck.quack();
        duck.quack();
        System.out.println("----------");
        for (int i = 1; i < quackers.size(); i++) {
            duck = quackers.get(i);
            duck.quack();
        }

    }
}

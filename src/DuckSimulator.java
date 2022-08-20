public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory ecoDuckFactory = new EcoDuckFactory();
        AbstractDuckFactory duckFactory = new DuckFactory();
        simulator.simulate(duckFactory);
//        simulator.simulate(countingDuckFactory);
//        simulator.simulate(ecoDuckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

//        System.out.println("Duck Simulator: With Abstract Factory");

//        Quackable mallardDuck = new QuackEco(new QuackCounter(new MallardDuck()));
//        Quackable redheadDuck = new QuackEco(new QuackCounter(new RedheadDuck()));
//        Quackable duckCall = new QuackEco(new QuackCounter(new DuckCall()));
//        Quackable rubberDuck = new QuackEco(new QuackCounter(new RubberDuck()));

//        Quackable mallardDuck = new QuackCounter(new QuackEco(new MallardDuck()));
//        Quackable redheadDuck = new QuackCounter(new QuackEco(new RedheadDuck()));
//        Quackable duckCall = new QuackCounter(new QuackEco(new DuckCall()));
//        Quackable rubberDuck = new QuackCounter(new QuackEco(new RubberDuck()));

        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        System.out.println("Duck Simulator: With Composite - Flocks");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        Flock flockOfMullards = new Flock();

        flockOfMullards.add(mallardDuck);
        flockOfMullards.add(mallardOne);
        flockOfMullards.add(mallardTwo);
        flockOfMullards.add(mallardThree);
        flockOfMullards.add(mallardFour);

        flockOfDucks.add(flockOfMullards);

//        System.out.println("Duck Simulator");

//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);
//        simulate(pigeonDuck);

        System.out.println("Duck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("Duck Simulator: Mallard Flock Simulation");
        simulate(flockOfMullards);

        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}

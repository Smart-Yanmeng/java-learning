package store;

import order.*;

public class KFC implements Shop {
    @Override
    public FriedChicken createFriedChicken() {
        return new Original();
    }

    @Override
    public Cola createCola() {
        return new Coca();
    }

    @Override
    public Hamburg createHamburg() {
        return new CheeseBurger();
    }
}

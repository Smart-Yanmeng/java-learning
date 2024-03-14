package store;

import order.*;

public class McD implements Shop {
    @Override
    public FriedChicken createFriedChicken() {
        return new McNuggets();
    }

    @Override
    public Cola createCola() {
        return new Pesi();
    }

    @Override
    public Hamburg createHamburg() {
        return new BigMac();
    }
}

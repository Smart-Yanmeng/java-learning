package store;

import order.Cola;
import order.FriedChicken;
import order.Hamburg;

public interface Shop {

    FriedChicken createFriedChicken();

    Cola createCola();

    Hamburg createHamburg();

    default void render() {
        createFriedChicken().render();
        createCola().render();
        createHamburg().render();
    }
}

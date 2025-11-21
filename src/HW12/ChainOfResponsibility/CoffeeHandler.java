package HW12.ChainOfResponsibility;

import java.util.Map;

abstract class CoffeeHandler {
    protected CoffeeHandler nextHandler;

    public CoffeeHandler setNext(CoffeeHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public Coffee process(Coffee coffee, Map<String, Object> preferences) {
        if (nextHandler != null) {
            return nextHandler.process(coffee, preferences);
        }
        return coffee;
    }
}

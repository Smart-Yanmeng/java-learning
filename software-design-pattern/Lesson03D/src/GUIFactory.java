public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();

    default void render() {
        createButton().render();
        createCheckbox().render();
    }
}

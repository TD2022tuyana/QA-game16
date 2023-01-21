public class NotFoundException extends RuntimeException {
    public NotFoundException(String name) {
        super("Игрок с именем  " + name + " не найден");
    }
}

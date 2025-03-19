public class DefaultText implements Parser {
    @Override
    public String parse(String text) {
        return text.toLowerCase();
    }
}

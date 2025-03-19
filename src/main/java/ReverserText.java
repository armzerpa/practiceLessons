public class ReverserText implements Parser {

    @Override
    public String parse(String text) {
        StringBuilder reversed = new StringBuilder();
        char[] arr = text.toCharArray();
        for (int i = arr.length - 1; i > 0; i--) {
            reversed.append(arr[i]);
        }
        return reversed.toString();
    }
}

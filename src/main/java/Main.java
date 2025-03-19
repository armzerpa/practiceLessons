public class Main {

    public static void main(String[] args ){
        System.out.println("hola");
        ParserText pt = new ParserText("armando", "REVERSE");
        String result = pt.Parse();
        System.out.println(result);
    }
}

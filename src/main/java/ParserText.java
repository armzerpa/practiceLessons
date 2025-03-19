public class ParserText {
    private String text;
    private String type;
    private Parser parser;

    public void setText(String text) { this.text = text; }
    public String getText() { return this.text; }

    public void setType(String type) {
        this.type = type;
        this.initializeParser();
    }    public String getType() { return this.type; }
    protected boolean isTextEmptyOrNull() { return (this.text == null || this.text.isEmpty()); }
    protected boolean isTypeEmptyOrNull() { return (this.type == null || this.type.isEmpty()); }

    public ParserText(String text, String type) {
        this.text = text;
        this.type = type;
        this.initializeParser();
    }
    public String Parse() {
        if (this.isTextEmptyOrNull() )
            return null;

        return parser.parse(this.text);
    }
    private void initializeParser() {
        if(this.isTypeEmptyOrNull()){
            parser = new DefaultText();
            return;
        }
        switch (this.type){
            case "REVERSE":
                parser = new ReverserText();
                break;
            case "CASE1":
                parser = new Case1Text();
                break;
            default:
                parser = new DefaultText();
        }
    }
}

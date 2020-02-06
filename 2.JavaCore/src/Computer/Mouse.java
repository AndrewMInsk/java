package Computer;

public class Mouse extends CompDetail{
    public Mouse(){
        super();
    }

    public Mouse(String name, String manufacturer) {
        super(name, manufacturer);
    }

    public Mouse(String name, String manufacturer, int price) {
        super(name, manufacturer, price);
    }

    public Mouse(String name) {
        super(name);
    }
}

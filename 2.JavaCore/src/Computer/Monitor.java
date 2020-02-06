package Computer;


public class Monitor extends CompDetail{

    public Monitor(){
        super();
    }
    public Monitor(String name) {
        super(name);
    }

    public Monitor(String name, String manufacturer) {
        super(name, manufacturer);
    }

    public Monitor(String name, String manufacturer, int price) {
        super(name, manufacturer, price);
    }
}

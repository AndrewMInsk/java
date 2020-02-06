package Computer;

public abstract class CompDetail {
    private String name;
    private String manufacturer;
    private int price;

    public CompDetail() {
            setName(this.getClass().getSimpleName() + " без названия");
            setManufacturer(this.getClass().getSimpleName() + " без производителя");
            this.price = 0;

    }

    public CompDetail(String name) {
        this.name = name;
        setManufacturer(this.getClass().getSimpleName() + " без производителя");
        this.price = 0;

    }
    public CompDetail(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = 0;

    }

    public CompDetail(String name, String manufacturer,int price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String strPrice = "";
        if(getPrice()!=0){
             strPrice = " Стоимость: " + this.getPrice() + " рублей";
        }
        return "Название: " + this.getName() + " Производитель: " + this.getManufacturer() + strPrice +"\n" ;
    }


}

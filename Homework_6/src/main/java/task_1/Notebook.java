package task_1;

public class Notebook {
    private String brand;
    private String ram;
    private String ssd;
    private String os;
    private String color;

    public Notebook(String brand, String ram, String ssd, String os, String color){
        this.brand = brand;
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
    }

    public String printInfo() {
        System.out.printf("Brand: %s, RAM: %s ГБ, SSD: %s ГБ, OS: %s, color: %s", brand, ram, ssd, os, color);
        return ".";
    }

    public String getRam() {
        return ram;
    }

    public String getBrand() {
        return brand;
    }

    public String getSSD() {
        return ssd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}

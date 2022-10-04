package hello_sign_poc.dto;

public class LineItem {
    public String market;
    public String format;
    public String digitalOrStatic;
    public int qty;
    public float price;

    public LineItem(String market, String format, String digitalOrStatic, int qty, float price) {
        this.market = market;
        this.format = format;
        this.digitalOrStatic = digitalOrStatic;
        this.qty = qty;
        this.price = price;
    }

    public String getMarket() {
        return market;
    }

    public String getFormat() {
        return format;
    }

    public String getDigitalOrStatic() {
        return digitalOrStatic;
    }

    public int getQty() {
        return qty;
    }

    public float getPrice() {
        return price;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setDigitalOrStatic(String digitalOrStatic) {
        this.digitalOrStatic = digitalOrStatic;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

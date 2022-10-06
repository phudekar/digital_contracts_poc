package hello_sign_poc.dto;

import java.util.ArrayList;
import java.util.List;

public class DataModel {
    public List<LineItem> lineItems;

    public DataModel() {
        lineItems = new ArrayList<>();
        lineItems.add(new LineItem("Los Angeles", "Billboard", "Digital", 1, 12.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
        lineItems.add(new LineItem("Los Angeles", "Billboard", "Digital", 1, 12.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
        lineItems.add(new LineItem("Los Angeles", "Billboard", "Digital", 1, 12.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Philadelphia", "Banner", "Static", 1, 72.2f));
        lineItems.add(new LineItem("Chicago", "Airport", "Static", 1, 22.2f));
        lineItems.add(new LineItem("New York", "Roadside", "Digital", 1, 62.2f));
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}

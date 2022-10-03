package hello_sign_poc.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public class Product {

    public String getName() {
        return name;
    }

    private String name;

    public String getUrl() {
        return url;
    }

    private final String url;

    public Product(String name, String url){

        this.name = name;
        this.url = url;
    }
}

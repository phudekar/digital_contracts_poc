package hello_sign_poc.dto;

public class Contact {
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String name;
    private String email;

    public Contact(String name, String email) {

        this.name = name;
        this.email = email;
    }
}

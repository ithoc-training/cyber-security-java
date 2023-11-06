package de.ithoc.training.cybersecurity.ssrf;


@SuppressWarnings("unused")
public class Customer {

    private String id;
    private String email;
    private Integer turnover;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Integer getTurnover() {
        return turnover;
    }

    public void setTurnover(Integer turnover) {
        this.turnover = turnover;
    }

}

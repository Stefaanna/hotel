package main.java.hostel.domain.entity;

public abstract class Person {

    private String cnp;
    private String name;

    public Person() {}

    public Person(String cnp, String name) {
        this.cnp = cnp;
        this.name = name;
    }


    public String getCnp() { return cnp; }

    public void setCnp(String cnp) { this.cnp = cnp; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}

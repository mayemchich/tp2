package org.example;

public class Utilisateur {
    String name;
    String lastname;
    String email;
    public Utilisateur(String name, String last_name, String EMAIL)
    {
        this.name=name;
        this.lastname=last_name;
        this.email=EMAIL;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

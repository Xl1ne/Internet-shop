package simple.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderAdd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName,lastName,email,address,country,state,ccName;
    private int ccNumber, ccExpiration, ccCvv;

    public Long getIdOrder() {
        return id;
    }

    public void setIdOrder(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public int getCcNumber() {
        return ccNumber;
    }
    public void setCcNumber(int ccNumber) {
        this.ccNumber = ccNumber;
    }

    public int getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(int ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public int getCcCvv() {
        return ccCvv;
    }

    public void setCcCvv(int ccCvv) {
        this.ccCvv = ccCvv;
    }

    public OrderAdd() {
    }

    public OrderAdd(String firstName, String lastName, String email, String address, String country, String state, String ccName, int ccNumber, int ccExpiration, int ccCvv) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.country = country;
        this.state = state;
        this.ccName = ccName;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCvv = ccCvv;
    }
}

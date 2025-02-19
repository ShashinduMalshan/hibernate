package Entitiry;

import javax.persistence.*;

@Entity
@Table(name = "customer_table")

public class Customer {
    @Id // primary key
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(name = "Customer_Email")
    private String email;
    private String phone;

    @Transient
    private String visaCardNumber;


    public Customer() {
    }

    public Customer(int id, String name, String email, String phone, String visaCardNumber){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.visaCardNumber = visaCardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

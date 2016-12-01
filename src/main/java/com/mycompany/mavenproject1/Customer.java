package com.mycompany.mavenproject1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manueltovaizquierdo
 */

@Entity
@Table
@XmlRootElement
public class Customer implements Serializable {   
    //===========================================
    //=         Attributes
    //===========================================

    @Id //set primary key value 
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String name;
    private String address;
    private String email;

    //===========================================
    //=         Constructors
    //===========================================

    public Customer() {
    }

    public Customer(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    //===========================================
    //=         Getters & Setters
    //===========================================
    
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

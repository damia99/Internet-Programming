/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.sql.Date;

/**
 *
 * @author Mhdrfq
 */
public class Subscription {
    private int id;
    private String username;
    private String medication;
    private Date time;

    public Subscription(int id, String username, String medication, Date time) {
        this.id = id;
        this.username = username;
        this.medication = medication;
        this.time = time;
    }

    public Subscription() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
}

package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
//hello
@Entity
public class data1 {
    @Id
    private int idd;
    @NotEmpty(message = "Name may not be empty")
    private String nme;
    @NotEmpty(message = "Time may not be empty")
    private String time;
    @NotEmpty(message = "Time may not be empty")
    private String date;
    @NotEmpty(message = "Date may not be empty")
    private String status;
    @NotEmpty(message = "Status may not be empty")
    private String date2;
    @NotEmpty(message = "Date 2 may not be empty")
    private String time2;

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getNme() {
        return nme;
    }

    public void setNme(String nme) {
        this.nme = nme;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return idd+" "+nme+" "+time+" "+date+" "+status;
    }


}

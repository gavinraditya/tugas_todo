package com.pam.demo_rest2;

public class Data {
    public String what, time;
    public int id;

    public Data(int id, String what, String time){
        this.id = id;
        this.time = time;
        this.what = what;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getWhat() {
        return what;
    }
}

package com.example.kurierex.models;

import com.sun.tracing.dtrace.Attributes;

public class DatabaseUserModel {

    public double length;
    public double height;
    public double width;

    public UserModel sender;
    public UserModel receiver;

    public DatabaseUserModel(double length, double height, double width, UserModel sender, UserModel receiver) {
        this.length = length;
        this.height = height;
        this.width = width;
        this.sender = sender;
        this.receiver = receiver;
    }

}

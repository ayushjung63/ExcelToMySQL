package com.ayush.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private Integer rollNo;
    private String name;
    private Double dotNet;
    private Double computerGraphics;
    private Double computerNetwork;
    private Double MIS;
    private Double management;

    public Student(Integer rollNo, String name, Double dotNet, Double computerGraphics, Double computerNetwork, Double MIS, Double management) {
        this.rollNo = rollNo;
        this.name = name;
        this.dotNet = dotNet;
        this.computerGraphics = computerGraphics;
        this.computerNetwork = computerNetwork;
        this.MIS = MIS;
        this.management = management;
    }
    public  Student(){}

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDotNet() {
        return dotNet;
    }

    public void setDotNet(Double dotNet) {
        this.dotNet = dotNet;
    }

    public Double getComputerGraphics() {
        return computerGraphics;
    }

    public void setComputerGraphics(Double computerGraphics) {
        this.computerGraphics = computerGraphics;
    }

    public Double getComputerNetwork() {
        return computerNetwork;
    }

    public void setComputerNetwork(Double computerNetwork) {
        this.computerNetwork = computerNetwork;
    }

    public Double getMIS() {
        return MIS;
    }

    public void setMIS(Double MIS) {
        this.MIS = MIS;
    }

    public Double getManagement() {
        return management;
    }

    public void setManagement(Double management) {
        this.management = management;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", dotNet=" + dotNet +
                ", computerGraphics=" + computerGraphics +
                ", computerNetwork=" + computerNetwork +
                ", MIS=" + MIS +
                ", management=" + management +
                '}';
    }
}

package com.example.demo.Model;

import javax.persistence.*;


@Entity
    @Table(name = "students")
    public class Student {

        private int id;
        private String name;
        private String surname;
        private double mathMark;
        private double engMark;
        private double histMark;
        private double avgCount;

    public Student(){}

    public Student(int id, String name, String surname, double mathMark, double engMark, double histMark, double avgCount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mathMark = mathMark;
        this.engMark = engMark;
        this.histMark = histMark;
        this.avgCount = avgCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "surname", nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Column(name = "math", nullable = false)
    public double getMathMark() {
        return mathMark;
    }

    public void setMathMark(double mathMark) {
        this.mathMark = mathMark;
    }
    @Column(name = "eng", nullable = false)
    public double getEngMark() {
        return engMark;
    }

    public void setEngMark(double engMark) {
        this.engMark = engMark;
    }
    @Column(name = "hist", nullable = false)
    public double getHistMark() {
        return histMark;
    }

    public void setHistMark(double histMark) {
        this.histMark = histMark;
    }
    @Column(name = "avg", nullable = false)
    public double getAvgCount() {
        return avgCount;
    }

    public void setAvgCount(double avgCount) {
        this.avgCount = avgCount;
    }



//
//    @Override
//    public String toString(){
//            return "Student [id="+ id + ", name=" +name + ", surname=" + surname +"]";
//    }
}

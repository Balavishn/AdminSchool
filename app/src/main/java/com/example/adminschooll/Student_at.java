package com.example.adminschooll;

class Student_at implements Comparable<Student_at> {
    public Student_at(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    String name;
    double grade;

    @Override
    public int compareTo(Student_at o) {
        if (o == null) {
            return -1;
        }
        int c = Double.valueOf(grade).compareTo(o.grade);
        if (c != 0) {
            return c;
        }
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s has grade %d", name, grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

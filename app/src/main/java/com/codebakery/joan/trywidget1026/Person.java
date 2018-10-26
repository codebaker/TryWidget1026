package com.codebakery.joan.trywidget1026;

public class Person {
    private String name,age,gender,occupation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "제 이름은" + name +
                "이고 나이는 '" + age +
                "살인 "+ gender + "입니다. " +
                "지금은 " + occupation + " 신분입니다.";
    }
}

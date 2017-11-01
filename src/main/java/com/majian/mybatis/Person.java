package com.majian.mybatis;

/**
 * Created by jianma on 2017/10/31.
 */
public class Person {
    private int id;
    private String name;
    private GenderEnum gender;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=")
          .append(id);
        sb.append(", name='")
          .append(name)
          .append('\'');
        sb.append(", genderEnum=")
          .append(gender);
        sb.append('}');
        return sb.toString();
    }
}

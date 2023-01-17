package com.agacorporation.demo.domain;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "count_room_of_type")
@Immutable
public class CountOfRoomView {

    @Id
    private int count;

    private String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountOfRoomView{" +
                ", count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
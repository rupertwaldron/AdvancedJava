package com.ruppyrup.optionals;

import java.util.Optional;

public class DtoOptionals {
    public static void main(String[] args) {
        MyDto dto = new MyDto();
        System.out.println(getPossible(dto));

        MyDto dtoNull = null;
        System.out.println(getPossible(dtoNull));

        MyDto dtoModelEmpty = new MyDto();
        dtoModelEmpty.setModel(null);
        System.out.println(getPossible(dtoModelEmpty));
    }

    private static String getPossible(MyDto dtoNull) {
        return Optional.ofNullable(dtoNull).map(MyDto::getModel).orElse("Empty");
    }

}


class MyDto {
    private String make = "Tv";
    private int size = 65;
    private String model = "65C9CM";

    public String getMake() {
        return make;
    }

    public int getSize() {
        return size;
    }

    public String getModel() {
        return model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

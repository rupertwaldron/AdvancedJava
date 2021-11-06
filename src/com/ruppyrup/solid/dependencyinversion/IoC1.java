package com.ruppyrup.solid.dependencyinversion;

public class IoC1 {

    public static void main(String[] args) {
        IoC1 container = new IoC1();
        User user = container.new User();
        user.add("hello world");
    }

    public class User {
        MySqlDatabase mySqlDatabase;

        public void add(String data) {
            mySqlDatabase = new MySqlDatabase();
            mySqlDatabase.persist(data);
        }

    }

    public class MySqlDatabase {
        void persist(String data) {
            System.out.println("Writing to a MySqlDatabase :: " + data);
        }
    }
}

package com.ruppyrup.solid.DIP.dependencyinversion;

public class IoC2 {

    public static void main(String[] args) {
        IoC2 container = new IoC2();
        MySqlDatabase sqlDatabase = container.new MySqlDatabase();
        User user = container.new User(sqlDatabase);
        user.add("hello world");
    }

    public class User {
        MySqlDatabase mySqlDatabase;

        public User(MySqlDatabase mySqlDatabase) {
            this.mySqlDatabase = mySqlDatabase;
        }

        public void add(String data) {
//            mySqlDatabase = new MySqlDatabase();
            mySqlDatabase.persist(data);
        }

    }

    public class MySqlDatabase {
        void persist(String data) {
            System.out.println("Writing to a MySqlDatabase :: " + data);
        }
    }
}

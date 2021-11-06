package com.ruppyrup.solid.dependencyinversion;

public class IoC3 {

    public static void main(String[] args) {
        IoC3 container = new IoC3();
        Database sqlDatabase = container.new MySqlDatabase();
        User user = container.new User(sqlDatabase);
        user.add("hello world");
        Database oracleDatabase = container.new OracleDatabase();
        User user2 = container.new User(oracleDatabase);
        user2.add("hello world");
    }

    public class User {
        Database database;

        public User(Database database) {
            this.database = database;
        }

        public void add(String data) {
//            mySqlDatabase = new MySqlDatabase();
            database.persist(data);
        }

    }


    public interface Database {
        void persist(String data);
    }

    public class MySqlDatabase implements Database {
        public void persist(String data) {
            System.out.println("Writing to a MySqlDatabase :: " + data);
        }
    }

    public class OracleDatabase implements Database {
        public void persist(String data) {
            System.out.println("Writing to a OracleDatabase :: " + data);
        }
    }
}

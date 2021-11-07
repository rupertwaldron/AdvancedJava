package com.ruppyrup.solid.DIP.dependencyinversion;

public class IoC4 {

    public static void main(String[] args) {
//        IoC4 container = new IoC4();
//        @Autowired
//        User user1;
//
//        @Autowired
//        User user2;
    }

    public class User {
        Database database;

        public User(Database database, Database database2) { //added another constructor will will inject automatically
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

package com.ruppyrup.vargs;

public class Settters {
  String a, b, c, d;

  void setA(String b) {
    a = b;
  }

  void setB(String b) {
    b = this.a;
  }
  void setD(String a) {
    this.d = d;
  }

  public void setC(String c) {
    this.d = c;
  }

  @Override
  public String toString() {
    return "Settters{" +
        "a='" + a + '\'' +
        ", b='" + b + '\'' +
        ", c='" + c + '\'' +
        ", d='" + d + '\'' +
        '}';
  }

  public static void main(String[] args) {

    Settters setter = new Settters();
    setter.setC("d");

    setter.setD("a");

    System.out.println(setter);

  }

}

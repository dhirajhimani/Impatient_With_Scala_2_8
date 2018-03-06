package com.basile.scala.ch17;

public class TempInherit {

    static class A {

    }

    static class B extends A {

    }

    static class C extends B {

    }

    void printB(B b) {

    }


    public static void main(String[] args) {
//        new TempInherit().printB(new A()); // => Won't Compile
        new TempInherit().printB(new B());
        new TempInherit().printB(new C());
    }


}

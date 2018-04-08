//package com.netcracker.infrastructure.servicesForConsol.states;
//
//import com.netcracker.infrastructure.servicesForConsol.Controller;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class  AdminState  implements State {
//
//    private Controller controller;
//
//    public AdminState(Controller controller) {
//        this.controller = controller;
//    }
//
//    @Override
//    public void analyzeCommand(String command) {
//
//    }
//
//    @Override
//    public boolean work() {
//        System.out.println("1 - Create new multytable element.\n2 - Delete all.\n3 - Main menu.\n4 - Exit.\n");
//        boolean temp = true;
//        try {
//            System.out.println("Please enter:");
//            Scanner in = new Scanner(System.in);
//            String command = in.next();
//            analyzeCommand(command);
//
//        } catch (InputMismatchException r) {
//            System.out.println("Error. Somthing wrong.\n");
//        }
//
//        return temp;
//
//    }
//}

//package com.netcracker.infrastructure.servicesForConsol.states;
//
//import com.netcracker.infrastructure.servicesForConsol.Controller;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class  UnknowState  implements State {
//
//    private Controller controller;
//
//    public UnknowState(Controller controller) {
//        this.controller = controller;
//    }
//
//    @Override
//    public void analyzeCommand(String command) {
//
//        switch (command) {
//            case "admin":
//                System.out.println("Login please:");
//                try {
//                    Scanner in = new Scanner(System.in);
//                    String command2 = in.next();
//                    if(command2.equals("root")){
//                        controller.setCurrentState(new AdminState(controller));
//                        break;
//                    }
//                    else{
//                        System.out.println("Wrong!");
//                        break;
//                    }
//                } catch (InputMismatchException r) {
//                    System.out.println("Error. Somthing wrong.\n");
//                }
//                break;
//            case "user":
//                controller.setCurrentState(new UserState(controller));
//                break;
//            case "exit":
//                System.exit(1);
//                break;
//            default:
//                System.out.println("Error. Repeat command.");
//                break;
//        }
//    }
//
//    @Override
//    public boolean work() {
//        boolean temp = true;
//        System.out.println("Hello! Who are you?\n");
//
//        System.out.println("1 - Admin.\n2 - User.\n3 - Exit.\n");
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
//
//    }
//}

//package com.netcracker.infrastructure.servicesForConsol.states;
//
//import com.netcracker.infrastructure.servicesForConsol.Controller;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class UserState extends AbstractState implements State {
//
//    private Controller controller;
//
//    public UserState(Controller controller) {
//        this.controller = controller;
//    }
//
//    @Override
//    public void analyzeCommand(String command) {
//
//        if (analyzeCommonCommands(command)) {
//            return;
//        }
//
//        switch (command) {
//            case "books":
//                controller.setCurrentState(new BookState(controller));
//                break;
//            case "authors":
//                controller.setCurrentState(new AuthorState(controller));
//                break;
//            case "publishing Houses":
//                controller.setCurrentState(new PubHouseState(controller));
//                break;
//            case "stores":
//                controller.setCurrentState(new StoreState(controller));
//                break;
//            case "exit":
//                System.out.println("Good luck!");
//                System.exit(1);
//            default:
//                System.out.println("Error. Repeat command.");
//                break;
//        }
//
//    }
//
//    @Override
//    public boolean work() {
//        boolean temp = true;
//            System.out.println("What are you interested in?\n");
//
//            System.out.println("1 - Books.\n2 - Authors.\n3 - Publishing Houses.\n4 - Stores.\n" +
//                    "5 - Exit.\n6 - About.\n");
//
//            try {
//                System.out.println("Please enter:");
//                Scanner in = new Scanner(System.in);
//                String command = in.next();
//                analyzeCommand(command);
//
//            } catch (InputMismatchException r) {
//                System.out.println("Error. Somthing wrong.\n");
//            }
//
//            return temp;
//
//    }
//}

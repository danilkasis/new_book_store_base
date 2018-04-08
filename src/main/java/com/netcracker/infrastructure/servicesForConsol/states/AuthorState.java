//package com.netcracker.infrastructure.servicesForConsol.states;
//
//import com.netcracker.entities.Author;
//import com.netcracker.infrastructure.servicesForConsol.Connector;
//import com.netcracker.infrastructure.servicesForConsol.Controller;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.InputMismatchException;
//import java.util.List;
//import java.util.Scanner;
//
//public class AuthorState extends AbstractState implements State {
//
//    private Connector myConnector;
//    private Controller controller;
//
//
//    public AuthorState(Controller controller) {
//        this.controller = controller;
//    }
//
//    @Override
//    public void analyzeCommand(String command) {
//        Scanner in = new Scanner(System.in);
//        if (analyzeCommonCommands(command)) {
//            return;
//        }
//
//        switch (command) {
//            case "1":
//                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//                myConnector = context.getBean(Connector.class);
//                List<Author> tempList = myConnector.getAuthorRepository().loadAll();
//                for(Author aut: tempList){
//                    System.out.println(aut);
//                    System.out.println("~~~~~~~~~~~~~~\n");
//                    }
//                analyzeCommand2();
//                break;
//
//            case "2":
//
//                try {
//
//                    System.out.println("Enter author's last name:\n");
//                    String temp2 = in.next();
//
//                } catch (InputMismatchException r) {
//                    System.out.println("Error. Something wrong.\n");
//                }
//
//
//                break;
//            case "3":
//                controller.setCurrentState(new UserState(controller));
//                break;
//            case "4":
//                System.out.println("Good luck!");
//                System.exit(1);
//                break;
//            default:
//                System.out.println("Error. Repeat command.");
//                break;
//        }
//    }
//
//
//    public void analyzeCommand2(){
//        System.out.println("1.Load this authors with books.\n2.Load one author with books.\n3.Return to author's menu.\n");
//        Scanner in = new Scanner(System.in);
//        try {
//            System.out.println("Please enter number:");
//            String temp1 = in.next();
//
//            switch(temp1){
//                case "1":
//                    List<Author> tempList = myConnector.getAuthorRepository().loadAllWithBook();
//                    for(Author aut: tempList){
//                        System.out.println(aut);
//                        System.out.println("-------Book:");
//                        System.out.println(aut.getBook());
//                        System.out.println("~~~~~~~~~~~~~~\n");
//                    }
//                    analizeCommand3();
//                    break;
//                case "2":
//                    try {
//                        System.out.println("Please enter author last name:");
//                        String temp2 = in.next();
//                        Author loadAuthor = myConnector.getAuthorRepository().loadByLastNameWithBook(temp2);
//                        System.out.println(loadAuthor);
//                        System.out.println("-------Book:");
//                        System.out.println(loadAuthor.getBook());
//                        System.out.println("~~~~~~~~~~~~~~\n");
//                        analizeCommand3();
//                    } catch (InputMismatchException r) {
//                        System.out.println("Error. Something wrong.\n");
//                    }
//                    break;
//                case "3":
//                    break;
//                default:
//                    System.out.println("Error. Repeat command.");
//                    break;
//
//            }
//
//        } catch (InputMismatchException r) {
//            System.out.println("Error. Something wrong.\n");
//        }
//    }
//
//    public void analizeCommand3(){
//        System.out.println("1.Look books.\n2.Return to author menu.\n3.Return to main menu.\n");
//        Scanner in = new Scanner(System.in);
//        try {
//            System.out.println("Please enter number:");
//            String temp1 = in.next();
//            switch(temp1){
//                case "1":
//                    controller.setCurrentState(new BookState(controller));
//                    break;
//                case "2":
//
//                    break;
//                case "3":
//                    controller.setCurrentState(new UserState(controller));
//                    break;
//                default:
//                    System.out.println("Error. Repeat command.");
//                    break;
//            }
//        }
//        catch (InputMismatchException r) {
//        System.out.println("Error. Something wrong.\n");
//        }
//    }
//
//    @Override
//    public boolean work() {
//        boolean temp = true;
//        System.out.println("================AUTHORS===============");
//        System.out.println("What are you interested now?\n");
//
//        System.out.println("1 - Load all authors.\n2 - Load author by last name.\n" +
//                "3 - Return to start page.\n4 - Exit.\n");
//        System.out.println("Please enter number:");
//        try {
//            Scanner in = new Scanner(System.in);
//            String command = in.next();
//            analyzeCommand(command);
//
//        } catch (InputMismatchException r) {
//            System.out.println("Error. Somthing wrong.\n");
//        }
//        return temp;
//    }
//}

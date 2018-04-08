//package com.netcracker.infrastructure.servicesForConsol;
//
//
//import com.netcracker.infrastructure.servicesForConsol.states.State;
//import com.netcracker.infrastructure.servicesForConsol.states.UnknowState;
//import org.hibernate.SessionFactory;
//
//public class Controller {
//
//    private SessionFactory sessionFactory;
//    private State currentState = new UnknowState(this);
//
//
//    public Controller(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public State getCurrentState() {
//        return currentState;
//    }
//
//    public void setCurrentState(State currentState) {
//        this.currentState = currentState;
//    }
//
//    public void start() {
//        boolean b = true;
//        boolean temp = true;
//        while (b) {
//
//        currentState.work();
//
//            b = temp;
//        }
//    }
//
//}

package com.netcracker.servlets;

import com.netcracker.config.SpringConfig;
import com.netcracker.entities.Author;
import com.netcracker.entities.Store;
import com.netcracker.infrastructure.repositories.AuthorRepository;
import com.netcracker.infrastructure.repositories.StoreRepository;
import com.netcracker.services.AuthorService;
import com.netcracker.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {

    SpringConfig springConfig = new SpringConfig();
    StoreRepository storeRepository = new StoreRepository(springConfig.getJdbcTemplate());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameterMap().isEmpty()){
                req.setAttribute("storeList", storeRepository.loadAll());
                req.getRequestDispatcher("storeList.jsp").forward(req, resp);
        }

        else if(!req.getParameterMap().isEmpty() && req.getParameterMap().size() != 1 ){
            System.out.printf("so much parametrs for searching");
        }

        else if(req.getParameter("id") != null){
            String id = req.getParameter("id");
            System.out.printf(id);
            req.setAttribute("store", storeRepository.loadById(id));
            req.getRequestDispatcher("storeById.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String storeName = req.getParameter("storeName");
        String streetName = req.getParameter("streetName");
        String numberOfHouse = req.getParameter("numberOfHouse");
        Store store = new Store(id,storeName,streetName,numberOfHouse);
        storeRepository.insert(store);

        req.setAttribute("storeList", storeRepository.loadAll());
        req.getRequestDispatcher("storeList.jsp").forward(req, resp);
    }
}



package com.touhid.dataCopierUI.controller;

import com.touhid.dataCopierUI.service.RestServiceForCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Touhid Hossain
 */
@Controller
public class CustomerController {

    private final RestServiceForCustomer restServiceForCustomer;

    public CustomerController(RestServiceForCustomer restServiceForCustomer){
        this.restServiceForCustomer = restServiceForCustomer;
    }

    @GetMapping(value = "/")
    public ModelAndView getAllMongoCustomers(){
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customers", restServiceForCustomer.getAllCustomerFromMongo());
        modelAndView.addObject("databaseName", "Mongo");
        return modelAndView;
    }

    @GetMapping(value = "/copy_to_msql")
    public ModelAndView copyAllMongoCustomersToMySql(){
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customers", restServiceForCustomer.copyAllMongoCustomersToMySql());
        modelAndView.addObject("databaseName", "Mysql");
        return modelAndView;
    }

    @GetMapping(value = "/mysql/customers")
    public ModelAndView getAllMySqlCustomers(){
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customers", restServiceForCustomer.getAllCustomerFromMySql());
        modelAndView.addObject("databaseName", "Mysql");
        return modelAndView;
    }
}

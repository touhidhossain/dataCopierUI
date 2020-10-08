package com.touhid.dataCopierUI.service;

import com.touhid.dataCopierUI.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Touhid Hossain
 */
@Service
public class RestServiceForCustomer {

    private static final Logger logger = LoggerFactory.getLogger(RestServiceForCustomer.class);

    private final RestTemplate restTemplate;

    @Value("${rest.server.url}")
    private String REST_URL;

    public RestServiceForCustomer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Customer> getAllCustomerFromMongo() {
        return restTemplate.getForObject(REST_URL + "/mongo/customers", ArrayList.class);
    }

    public List<Customer> getAllCustomerFromMySql() {
        return restTemplate.getForObject(REST_URL + "/mysql/customers", ArrayList.class);
    }

    public List<Customer> copyAllMongoCustomersToMySql() {
        return restTemplate.getForObject(REST_URL + "/mongo_to_mysql/customers", ArrayList.class);
    }
}

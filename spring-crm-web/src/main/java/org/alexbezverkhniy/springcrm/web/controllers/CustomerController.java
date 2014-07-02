package org.alexbezverkhniy.springcrm.web.controllers;

import org.alexbezverkhniy.springcrm.common.repositories.CustomerRepository;

/**
 * Created by bezverkhniy_10534 on 02/07/2014.
 */
// see example spring-data-rest-angularjs @RestResource(rel = "people", path = "people")
public interface CustomerController extends CustomerRepository {
}

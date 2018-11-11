package com.ads.activosfijos.dataAccessLayer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by Fabiani Lozano on 10/11/2018.
 */
public class AbstractService {
    @Autowired
    protected EntityManager em;
}

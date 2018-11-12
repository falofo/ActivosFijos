package com.ads.activosfijos.dataAccessLayer.impl;

import com.ads.activosfijos.dataAccessLayer.IUserService;
import com.ads.activosfijos.entityLayer.User;
import com.ads.activosfijos.entityLayer.dto.UserDTO;
import com.ads.activosfijos.util.PasswordUtils;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
@Service
public class UserService extends AbstractService implements IUserService{

    @Override
    public boolean existUser(final String user, String password) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUser",User.class);
        query.setParameter("user",user);
        List<User> users = query.getResultList();
        if (users.size()>0){
            User us =users.get(0);
            if (PasswordUtils.verifyPassword(password,us.getHash()))
                return true;
        }
        return false;
    }

    @Override
    public User getUser(final String user) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUser",User.class);
        query.setParameter("user",user);
        List<User> users = query.getResultList();
        if (users.size()>0){
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    @Transactional
    public User registerUser(UserDTO user) {
        User us = new User();
        us.setUser(user.getUser());
        us.setHash(PasswordUtils.createHash(user.getPassword()));
        em.persist(us);
        em.flush();
        return us;
    }
}

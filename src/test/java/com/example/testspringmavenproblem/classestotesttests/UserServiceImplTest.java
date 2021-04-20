package com.example.testspringmavenproblem.classestotesttests;

import com.example.testspringmavenproblem.classestotest.SecurityService;
import com.example.testspringmavenproblem.classestotest.User;
import com.example.testspringmavenproblem.classestotest.UserDAO;
import com.example.testspringmavenproblem.classestotest.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    public void happyPathTestUserServiceImpl() {
        UserDAO userDao = Mockito.mock(UserDAO.class);
        SecurityService securityService = Mockito.mock(SecurityService.class);
        User user = new User();

        Mockito.when(securityService.md5(Mockito.any())).thenReturn("as566234141");

        UserServiceImpl userService = new UserServiceImpl(userDao, securityService);
        try {
            userService.assignPassword(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(user.getPassword(), "as566234141");
        Mockito.verify(userDao).updateUser(user);


    }
}
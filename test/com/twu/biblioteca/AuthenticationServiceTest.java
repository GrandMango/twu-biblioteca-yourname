package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class AuthenticationServiceTest {
    private  AuthenticationService authenticationService;
    private String username;
    private String password;
    @Before
    public void init(){
        authenticationService = new AuthenticationService();
        username = "1";
        password = "1";
    }

    @Test
    public void login(){

        assertThat(authenticationService.login(username, password), equalTo(false));
        assertThat(authenticationService.getCurrentUser(), is(nullValue()));

        username = "001-chen";
        password = "wrong_password";
        assertThat(authenticationService.login(username, password), equalTo(false));
        assertThat(authenticationService.getCurrentUser(), is(nullValue()));

        username = "wrong_user";
        password = "123456";
        assertThat(authenticationService.login(username, password), equalTo(false));
        assertThat(authenticationService.getCurrentUser(), is(nullValue()));

        username = "001-chen";
        password = "123456";
        assertThat(authenticationService.login(username, password), equalTo(true));
        assertThat(authenticationService.getCurrentUser().getUsername(), equalTo("001-chen"));
    }
}
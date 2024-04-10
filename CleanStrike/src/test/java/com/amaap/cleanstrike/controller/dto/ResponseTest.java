package com.amaap.cleanstrike.controller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void shouldBeAbleToCheckEqualityOfObject()
    {
        // arrange & act
        Response response1 = new Response(HttpStatus.Ok,"First response");
        Response response2 = new Response(HttpStatus.Ok,"First response");
        Response response3 = new Response(HttpStatus.Ok,"second response");
        Response response4 = new Response(HttpStatus.BAD_REQUEST,"First response");
        Object object = new Object();

        // assert
        assertEquals(response1,response2);
        assertTrue(response1.equals(response1));
        assertNotEquals(response1, response3);
        assertNotEquals(response1, response4);
        assertNotEquals(response1, object);
        assertFalse(response1.equals(null));
    }

}
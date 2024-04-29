package com.snhu.kc.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.snhu.kc.contactservice.*;


public class ContactTest {

    @Test
    public void Given_Contact_When_Data_Is_Valid_Then_CreationSuccess() {
        Contact contact = new Contact("dummy_id", "Kemal", "Cankurt", "9809999999", "2500 N River Rd, NH 03106");
        Assertions.assertNotNull(contact);
    }

    @Test
    public void Given_Contact_When_FirstName_Exceeds_10_Char_Limit_Then_Throw_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "KemalKemal123", "Cankurt", "1234567890", "2500 N River Rd, Manchester, NH 03106");
        });
    }
}


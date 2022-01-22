package com.ani.appointmentmodule.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AppResponseTests {
    @DisplayName("Dto : Checking Object Creation")
    @Test
    void testObjectCreation() {
        var abc = new AppResponse<>();
        Assertions.assertNotNull(abc);
    }

}

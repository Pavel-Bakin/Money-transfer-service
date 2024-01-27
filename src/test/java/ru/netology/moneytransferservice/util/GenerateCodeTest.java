package ru.netology.moneytransferservice.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GenerateCodeTest {

    @Test
    public void testGetCode() {
        GenerateCode generator = new GenerateCode();
        String code = generator.getCode();
        assertNotNull(code);
        assertFalse(code.isEmpty());
    }
}
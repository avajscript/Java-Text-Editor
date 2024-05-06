package org.example.javafxfirst.constants;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class AppPropertiesTest {
    @Test
    public void testAddProperty() {
        AppProperties appProperties = new AppProperties();
        appProperties.updatePropertyArray("apple", "carrot", 3);

        System.out.println(appProperties.getProperty("apple"));
    }

}
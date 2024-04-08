package com.bft.trudvsem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginPageTest.class, CreateNewCvTest.class})
public class TestSuite {
    // Этот класс не нуждается в методах или коде, он просто служит для запуска указанных тестовых классов
}
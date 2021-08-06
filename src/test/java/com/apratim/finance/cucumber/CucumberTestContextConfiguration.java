package com.apratim.finance.cucumber;

import com.apratim.finance.FinancemanagementApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = FinancemanagementApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}

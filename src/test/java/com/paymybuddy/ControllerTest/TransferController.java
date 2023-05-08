package com.paymybuddy.ControllerTest;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootTest (classes = TransferController.class)
@AutoConfigureMockMvc
public class TransferController {
}

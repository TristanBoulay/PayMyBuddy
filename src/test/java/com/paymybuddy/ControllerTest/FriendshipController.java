package com.paymybuddy.ControllerTest;

import com.paymybuddy.Models.User;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootTest (classes = FriendshipController.class)
@AutoConfigureMockMvc
public class FriendshipController {
    private User user ;

}

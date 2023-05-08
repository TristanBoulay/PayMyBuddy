package com.paymybuddy.ControllerTest;

import com.paymybuddy.Models.Account;
import com.paymybuddy.Models.Friendship;
import com.paymybuddy.Models.User;
import com.paymybuddy.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@SpringBootTest(classes = UserController.class)
@AutoConfigureMockMvc
public class UserController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;

    private Account account;
    private List<Friendship> friendshipList;

    @BeforeEach
    public void prepareData() throws Exception{
        this.user = new User();
        user.setId(1L);
        user.setName("toto");
        user.setEmail("toto@email.com");
        user.setPassword("ines");
        user.setAccount(account);
        user.setFriendshipList(friendshipList);

    }


}

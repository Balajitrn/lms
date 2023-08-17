package com.swiz.lms.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.swiz.lms.configuration.SecurityConfig;
import com.swiz.lms.entity.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@SpringJUnitConfig(classes = {SecurityConfig.class}) // Replace with your actual configuration class if needed
public class UserRepositoryTest {

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        AppUser mockUser = new AppUser();
        mockUser.setUsername("balaji");
        // Set other fields as needed

        // Here's the stubbing
        when(userRepository.findByUsername("username")).thenReturn(mockUser);
    }
    @Test
    public void testFindByUsername() {
        // setup
        AppUser user = AppUser.builder()
                .id(1L)
                .username("balaji")
                .email("balaji@hello.com")
                .password("hello_123")
                .build();
        userRepository.save(user);
        AppUser found = userRepository.findByUsername("username");
        assertNotNull(found);
        assertEquals(user.getUsername(), found.getUsername());
    }

    // More tests for other CRUD operations.
}

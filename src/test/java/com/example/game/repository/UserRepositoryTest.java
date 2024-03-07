package com.example.game.repository;

import com.example.game.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest
{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void AddUser()
    {
        User user = User.builder().Username("first").email("ananan@gmail.com").Password("fgfdgfdg").build();

        User savedUser = userRepository.save(user);
        assertThat(user,notNullValue());
        assertThat(user.getId(),greaterThan(0L));

    }
}

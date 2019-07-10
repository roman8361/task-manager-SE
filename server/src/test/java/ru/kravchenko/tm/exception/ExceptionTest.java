package ru.kravchenko.tm.exception;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import ru.kravchenko.tm.exception.api.AccoundRepository;
import ru.kravchenko.tm.exception.api.UserRepository;
import ru.kravchenko.tm.exception.exception.AccountNotFoundException;
import ru.kravchenko.tm.exception.repository.AccountRepositoryBean;
import ru.kravchenko.tm.exception.repository.UserRepositoryBean;

import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class ExceptionTest {

    @Test()
    public void testUser() {
        final UserRepository repository = new UserRepositoryBean();
        repository.find(UUID.randomUUID().toString());
    }

    @Test()
    public void testAccount() throws AccountNotFoundException {
        final AccoundRepository repository = new AccountRepositoryBean();
        repository.find(UUID.randomUUID().toString());
        System.out.println("1111");
    }

}

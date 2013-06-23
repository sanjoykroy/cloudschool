package com.realtech.cloudschool.identityaccess.domain.repository;

import com.realtech.cloudschool.AbstractCloudSchoolRepositoryTest;
import com.realtech.cloudschool.identityaccess.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@ContextConfiguration("classpath:repository-context.xml")
public class UserRepositoryIntegrationTest extends AbstractCloudSchoolRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void shouldSaveUser() {
        User user = repository.save(new User());
        assertThat(user.getId(), is(notNullValue()));
    }

    @Test
    public void shouldFindAllUsers() {
        createSomeUsers();

        Iterable<User> result = repository.findAll();

        assertThat(result, is(notNullValue()));
        assertTrue(result.iterator().hasNext());
    }

    @Test
    public void shouldFindByUsername() {
        createSomeUsers();

        Page<User> users = repository.findByUsername("timpre", new PageRequest(0, 2));

        assertThat(users.getContent().size(), is(1));
        assertFalse(users.hasPreviousPage());
    }

    @Test
    public void shouldFindById() {
        User user = repository.save(createUser("timpre", "Tim", "Prentice"));

        User savedUser = repository.findOne(user.getId());

        assertThat(savedUser.getId(), is(notNullValue()));
        assertThat(savedUser.getFirstname(), is("Tim"));
        assertThat(savedUser.getLastname(), is("Prentice"));
    }

    // Helper Methods

    private void createSomeUsers(){
        createUser("johsmi", "John", "Smith");
        createUser("timpre", "Tim", "Prentice");
    }

    private User createUser(String username, String firstname, String lastname){
        User user = new User();
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        return repository.save(user);
    }
}

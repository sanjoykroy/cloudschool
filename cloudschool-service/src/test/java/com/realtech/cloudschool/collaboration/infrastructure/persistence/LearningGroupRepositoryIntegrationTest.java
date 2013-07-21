package com.realtech.cloudschool.collaboration.infrastructure.persistence;


import com.realtech.cloudschool.AbstractCloudSchoolRepositoryTest;
import com.realtech.cloudschool.collaboration.domain.model.GroupOwner;
import com.realtech.cloudschool.collaboration.domain.model.LearningGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LearningGroupRepositoryIntegrationTest extends AbstractCloudSchoolRepositoryTest {

    @Autowired
    private LearningGroupRepository repository;

    @Test
    public void shouldSaveLearningGroup() throws Exception {
        LearningGroup savedGroup = repository.save(new LearningGroup());
        assertThat(savedGroup.getId(), is(notNullValue()));
    }

    @Test
    public void shouldFindAllUsers() {
        createGroups();

        Iterable<LearningGroup> result = repository.findAll();

        assertThat(result, is(notNullValue()));
        assertTrue(result.iterator().hasNext());
    }

    @Test
    public void shouldFindByName() {
        createGroups();

        Page<LearningGroup> groups = repository.findByName("test group 1", new PageRequest(0, 2));

        assertThat(groups.getContent().size(), is(1));
        assertFalse(groups.hasPreviousPage());
    }

    @Test
    public void shouldFindById() {
        LearningGroup group = repository.save(getGroup("test group 1", 100L));

        LearningGroup savedGroup = repository.findOne(group.getId());

        assertThat(savedGroup.getId(), is(notNullValue()));
        assertThat(savedGroup.getName(), is("test group 1"));
        assertThat(savedGroup.getDescription(), is("test group description"));
    }

    private void createGroups(){
        repository.save(getGroup("test group 1", 100L));
        repository.save(getGroup("test group 2", 200L));
    }

    private LearningGroup getGroup(String name, Long ownerId){
        LearningGroup learningGroup = new LearningGroup();
        learningGroup.setName(name);
        learningGroup.setDescription("test group description");
        GroupOwner owner = new GroupOwner();
        owner.setId(ownerId);
        learningGroup.setOwner(owner);
        return learningGroup;
    }
}

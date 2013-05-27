package com.realtech.cloudschool.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = {"classpath:repository-context.xml"})
public abstract class AbstractCloudSchoolRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    @Qualifier("cloudSchoolDataSource")
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

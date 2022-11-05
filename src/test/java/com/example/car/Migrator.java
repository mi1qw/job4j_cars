package com.example.car;

import com.example.car.service.*;
import jakarta.annotation.PostConstruct;
import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.lockservice.LockServiceFactory;
import liquibase.lockservice.StandardLockService;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@TestConfiguration
@Slf4j
public class Migrator {
    @Autowired
    private CityService cityService;
    @Autowired
    private BodyService bodyService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private EngineService engineService;
    @Autowired
    private GearboxService gearboxService;
    @Autowired
    private MarkService markService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private OptionsService optionsService;
    @Autowired
    private TransmissionService transmissionService;

    private final DataSource ds = new XmlParser().dataSource();

    @PostConstruct
    private void init() {
        action();
    }

    public void action() {
        prepare();
        cityService.init();
        bodyService.init();
        colorService.init();
        engineService.init();
        gearboxService.init();
        markService.init();
        modelService.init();
        optionsService.init();
        transmissionService.init();
    }

    private void prepare() {
        try (Connection connection = ds.getConnection()) {
            Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(
                    new JdbcConnection(connection));
            db.setDefaultSchemaName("public");
            LockServiceFactory.getInstance().register(new StandardLockService());
            ClassLoader classLoader = this.getClass().getClassLoader();
            ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(classLoader);
            Liquibase liquibase = new Liquibase("db/master.xml", resourceAccessor, db);
            liquibase.update(new Contexts());
        } catch (LiquibaseException | SQLException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}

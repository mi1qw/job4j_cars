package com.example.car;

import com.example.car.store.SessionStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.List;

@TestConfiguration
@Slf4j
public class Cleaner implements SessionStore {
   public void clean() {
        txv(session -> {
            session.createNativeQuery("SET REFERENTIAL_INTEGRITY=FALSE;")
                    .executeUpdate();
            List<String> tables = session.createNativeQuery("""
                            SELECT table_name FROM information_schema.tables
                            WHERE table_schema = 'public'""", String.class)
                    .list();
            for (String table : tables) {
                /*log.info("{}", table);*/
                session.createNativeQuery("truncate table " + table + " restart identity")
                        .executeUpdate();
            }
            session.createNativeQuery("SET REFERENTIAL_INTEGRITY=TRUE;")
                    .executeUpdate();
        });
    }
}

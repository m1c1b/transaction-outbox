package com.gruelbox.transactionoutbox.acceptance;

import com.gruelbox.transactionoutbox.Dialect;
import com.gruelbox.transactionoutbox.testing.AbstractAcceptanceTest;
import java.time.Duration;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SuppressWarnings("WeakerAccess")
@Testcontainers
class TestOracle18 extends AbstractAcceptanceTest {

  @Container
  @SuppressWarnings("rawtypes")
  private static final JdbcDatabaseContainer container =
      new OracleContainer("gvenzl/oracle-xe:18-slim-faststart")
          .withStartupTimeout(Duration.ofHours(1))
          .withReuse(true);

  @Override
  protected ConnectionDetails connectionDetails() {
    return ConnectionDetails.builder()
        .dialect(Dialect.ORACLE)
        .driverClassName("oracle.jdbc.OracleDriver")
        .url(container.getJdbcUrl())
        .user(container.getUsername())
        .password(container.getPassword())
        .build();
  }
}

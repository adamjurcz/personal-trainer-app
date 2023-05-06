package com.adamjurcz.personaltrainerapp.presenters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

import java.util.Arrays;
import java.util.List;


@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Bean
    @Override
    protected String getKeyspaceName() {
        return "app_chat";
    }


    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession(){
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints("localhost");
        session.setPort(9042);
        session.setKeyspaceName(getKeyspaceName());
        session.setLocalDatacenter("datacenter1");
        session.setKeyspaceStartupScripts(Arrays.asList(
                "USE app_chat",
                "CREATE TABLE IF NOT EXISTS messages (" +
                        "username text," +
                        "chatRoomId text," +
                        "date timestamp," +
                        "fromUser text," +
                        "toUser text," +
                        "text text," +
                        "PRIMARY KEY ((username, chatRoomId), date)" +
                        ") WITH CLUSTERING ORDER BY (date ASC)"
        ));

        return session;
    }

    @Bean
    public CassandraConverter cassandraConverter() {
        return new MappingCassandraConverter(new CassandraMappingContext());
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
                .createKeyspace(getKeyspaceName())
                .ifNotExists()
                .withSimpleReplication(1);
        return List.of(specification);
    }
}

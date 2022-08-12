package luiz.augusto.userhandlingforanimelistproject.config;

import lombok.RequiredArgsConstructor;
import luiz.augusto.userhandlingforanimelistproject.database.DatabaseInitiation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class DevConfig
{
    private final DatabaseInitiation databaseInitiation;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Bean
    private void createObjectsForDatabase(){
        if(ddlAuto.equalsIgnoreCase("create")) databaseInitiation.DbInit();
    }
}

package com.khartec.waltz.jobs;


import com.khartec.waltz.service.DIBaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DIBaseConfiguration.class)
@ComponentScan(value={"com.khartec.waltz.jobs"})
public class DIJobsConfiguration {
}

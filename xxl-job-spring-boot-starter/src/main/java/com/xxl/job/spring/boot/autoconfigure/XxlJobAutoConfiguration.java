package com.xxl.job.spring.boot.autoconfigure;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

/**
 * @author Whalley
 * @since 2021/4/5
 */
@Slf4j
@AllArgsConstructor
@EnableConfigurationProperties({XxlJobProperties.class})
public class XxlJobAutoConfiguration {

    private final XxlJobProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job init.");

        XxlJobProperties.AdminProperties admin = this.properties.getAdmin();
        XxlJobProperties.ExecutorProperties executor = this.properties.getExecutor();

        Objects.requireNonNull(admin, "xxl job admin properties must not be null.");
        Objects.requireNonNull(executor, "xxl job executor properties must not be null.");

        XxlJobSpringExecutor xxlJobExecutor = new XxlJobSpringExecutor();
        xxlJobExecutor.setIp(executor.getIp());
        xxlJobExecutor.setPort(executor.getPort());
        xxlJobExecutor.setAppname(executor.getAppName());
        xxlJobExecutor.setLogPath(executor.getLogPath());
        xxlJobExecutor.setAddress(executor.getAddress());
        xxlJobExecutor.setLogRetentionDays(executor.getLogRetentionDays());
        xxlJobExecutor.setAdminAddresses(admin.getAddresses());
        xxlJobExecutor.setAccessToken(this.properties.getAccessToken());
        return xxlJobExecutor;
    }

}

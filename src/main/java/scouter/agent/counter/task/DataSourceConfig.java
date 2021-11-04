package scouter.agent.counter.task;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;


@Configuration
@MapperScan(basePackages = "com.test")
@AllArgsConstructor
public class DataSourceConfig {
    private HikariDataSource dataSource;

    @PostConstruct
    public void init() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.test:type=DataSource,name=hikari-pool,context=/");
        DataSourceMonitoring dataSourceMonitoring = new DataSourceMonitoring(dataSource);
        mBeanServer.registerMBean(dataSourceMonitoring, objectName);
    }
}

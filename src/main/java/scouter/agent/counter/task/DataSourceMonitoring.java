package scouter.agent.counter.task;

import com.zaxxer.hikari.HikariDataSource;

public class DataSourceMonitoring implements DataSourceMonitoringMBean {

    private HikariDataSource dataSource;

    public DataSourceMonitoring(HikariDataSource dataSource) { this.dataSource = dataSource; }

    @Override
    public int getnumActive() {
        return dataSource.getHikariPoolMXBean().getActiveConnections();
    }

    @Override
    public int getnumIdle() {
        return dataSource.getHikariPoolMXBean().getIdleConnections();
    }

    @Override
    public int getmaxActive() {
        return dataSource.getHikariConfigMXBean().getMaximumPoolSize();
    }

    @Override
    public int getmaxTotal() {
        return dataSource.getHikariConfigMXBean().getMaximumPoolSize();
    }
}
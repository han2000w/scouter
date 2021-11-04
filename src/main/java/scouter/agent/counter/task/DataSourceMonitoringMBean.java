package scouter.agent.counter.task;

public interface DataSourceMonitoringMBean {
    int getnumActive();
    int getnumIdle();
    int getmaxActive();
    int getmaxTotal();
}

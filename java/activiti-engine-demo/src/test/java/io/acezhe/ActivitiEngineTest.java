package io.acezhe;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class ActivitiEngineTest {
    /**
     * 代码创建引擎
     */
    @Test
    public void activitiEngineInitByJavaTest(){
        // 创建引擎配置对象
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();

        // 设置数据库四要素
        configuration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/oa?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("root");
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");

//        configuration.setDatabaseSchema("MYSQL");
        // 设置建表策略
        // true 没有就创建，有就用
        // false 没有就报错
        // create-drop 创建，程序结束就删除
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    /**
     * 从xml读配置创建引擎
     */
    @Test
    public void activitiEngineInitByXmlTest(){
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

}

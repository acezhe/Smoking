package io.acezhe;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SimpleFlowTest {
    ProcessEngine engine;

    /**
     * 初始化流程引擎
     */
    @Before
    public void initProcessEngine() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        engine = configuration.buildProcessEngine();
    }

    /**
     * 部署工作流
     */
    @Test
    public void deployWorkflow() {
        RepositoryService repositoryService = engine.getRepositoryService();
        repositoryService.createDeployment()
                .addClasspathResource("diagrams/askForLeave.bpmn")
                .deploy();
        // 列出部署动作相关信息
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        for (Deployment deployment : list) {
            System.out.println("ID:" + deployment.getId());
            System.out.println("TIME:" + deployment.getDeploymentTime());
            System.out.println("CATEGORY:" + deployment.getCategory());
            System.out.println("NAME:" + deployment.getName());
            System.out.println("KEY:" + deployment.getKey());
            System.out.println("TENANTID:" + deployment.getTenantId());
            System.out.println("---------------------------------");
        }
        // 列出部署流程定义信息
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition : processDefinitions) {
            System.out.println("ID:"+processDefinition.getId());
            System.out.println("KEY:"+processDefinition.getKey());
            System.out.println("NAME:"+processDefinition.getName());
            System.out.println("CATEGORY:"+processDefinition.getCategory());
            System.out.println("DEPID:"+processDefinition.getDeploymentId());
            System.out.println("DES:"+processDefinition.getDescription());
            System.out.println("DIANAME:"+processDefinition.getDiagramResourceName());
            System.out.println("VER:"+processDefinition.getEngineVersion());
            System.out.println("RESNAME:"+processDefinition.getResourceName());
            System.out.println("--------------------------------");
        }
    }

    /**
     * 发起工作流
     */
    @Test
    public void startWorkflowTest(){
        // 启动
        engine.getRuntimeService().startProcessInstanceByKey("askForLeave");
        // 查看执行信息
        List<Execution> executions = engine.getRuntimeService().createExecutionQuery().list();
        for (Execution execution : executions) {
            System.out.println("ID:"+execution.getId());
            System.out.println("NAME:"+execution.getName());
            System.out.println("DES:"+execution.getDescription());
            System.out.println("ACT_ID:"+execution.getActivityId());
            System.out.println("PRO_INS_ID:"+execution.getProcessInstanceId());
            System.out.println("--------------------------------");
        }
        List<Task> tasks = engine.getTaskService().createTaskQuery().list();

        for (Task task : tasks) {
            System.out.println("ID:"+task.getId());
            System.out.println("NAME:"+task.getName());
            System.out.println("ASSIGNEE:"+task.getAssignee());
            System.out.println("CATEGORY:"+task.getCategory());
            System.out.println("DES:"+task.getDescription());
            System.out.println("EX_ID:"+task.getExecutionId());
            System.out.println("OWNER:"+task.getOwner());
            System.out.println("FORMKEY:"+task.getFormKey());
            System.out.println("--------------------------------");

        }

    }

    /**
     * 执行第一步，发起申请
     */
    @Test
    public void executeStepOneTest(){
        List<Task> tasks = engine.getTaskService().createTaskQuery().taskAssignee("guoxiaoru").list();
        // 遍历出所有任务，并完成该步骤
        for (Task task : tasks) {
            System.out.println("ID:"+task.getId());
            System.out.println("NAME:"+task.getName());
            System.out.println("ASSIGNEE:"+task.getAssignee());
            System.out.println("CATEGORY:"+task.getCategory());
            System.out.println("DES:"+task.getDescription());
            System.out.println("EX_ID:"+task.getExecutionId());
            System.out.println("OWNER:"+task.getOwner());
            System.out.println("FORMKEY:"+task.getFormKey());
            System.out.println("--------------------------------");
            engine.getTaskService().complete(task.getId());
        }
    }
    /**
     * 执行第二步，经理审批
     */
    @Test
    public void executeStepTwoTest(){
        List<Task> tasks = engine.getTaskService().createTaskQuery().taskAssignee("zhangzhe").list();
        // 遍历出所有任务，并完成该步骤
        for (Task task : tasks) {
            System.out.println("ID:"+task.getId());
            System.out.println("NAME:"+task.getName());
            System.out.println("ASSIGNEE:"+task.getAssignee());
            System.out.println("CATEGORY:"+task.getCategory());
            System.out.println("DES:"+task.getDescription());
            System.out.println("EX_ID:"+task.getExecutionId());
            System.out.println("OWNER:"+task.getOwner());
            System.out.println("FORMKEY:"+task.getFormKey());
            System.out.println("--------------------------------");
            engine.getTaskService().complete(task.getId());
        }
        //列出完成了的任务
        List<HistoricTaskInstance> taskInstances = engine.getHistoryService().createHistoricTaskInstanceQuery().finished().list();
        for (HistoricTaskInstance instance : taskInstances) {
            System.out.println("ID:"+instance.getId());
            System.out.println("NAME:"+instance.getName());
            System.out.println("ASSIGNEE:"+instance.getAssignee());
            System.out.println("CATEGORY:"+instance.getCategory());
            System.out.println("DES:"+instance.getDescription());
            System.out.println("EX_ID:"+instance.getExecutionId());
            System.out.println("OWNER:"+instance.getOwner());
            System.out.println("FORMKEY:"+instance.getFormKey());
            System.out.println("--------------------------------");

        }
    }


}

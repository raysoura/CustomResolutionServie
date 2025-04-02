package service;

import models.Issue;

import java.util.List;

public interface AgentService {

    String addAgent(String agentId, List<Integer> expertise);

    List<String> getAgentHistory(String agentId);

    List<String> getAgentList(String issueType);

    List<Issue> getIssues(String agentId);

    void updateAgentIssue(String agentId, Issue issue);
}

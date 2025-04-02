package service.impl;

import models.Issue;
import repository.AgentRepository;
import service.AgentService;

import java.util.List;

public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;

    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public String addAgent(String agentId, List<Integer> expertise) {
        return agentRepository.addAgent(agentId, expertise);
    }

    public List<String> getAgentHistory(String agentId) {
        return agentRepository.getAgentHistory(agentId);
    }

    @Override
    public List<String> getAgentList(String issueType) {
        return agentRepository.getExpertAgent(issueType);
    }

    @Override
    public List<Issue> getIssues(String agentId) {
        return agentRepository.getIssues(agentId);
    }

    public void updateAgentIssue(String agentId, Issue issue) {
        agentRepository.updateAgentIssue(agentId, issue);
    }
}

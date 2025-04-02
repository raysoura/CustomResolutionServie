package service.impl;


import repository.IssueRepository;
import service.AgentService;
import service.IssueService;
import service.strategy.AssignmentFactory;

public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final AssignmentFactory assignmentFactory;
    private final AgentService agentService;

    public IssueServiceImpl(IssueRepository issueRepository, AssignmentFactory assignmentFactory, AgentService agentService) {
        this.issueRepository = issueRepository;
        this.assignmentFactory = assignmentFactory;
        this.agentService = agentService;
    }

    public String createIssue(String issueId, String orderId, String issueType, String description) {
        return issueRepository.createIssue(issueId, orderId, issueType, description);
    }

    public String assignIssue(String issueId, int assignStrategy) {
        String agentId = assignmentFactory.getStrategy(assignStrategy).assign(issueId);
        agentService.updateAgentIssue(agentId, issueRepository.getIssue(issueId));
        return agentId;
    }

    public void resolveIssue(String issueId, String resolution) {
        issueRepository.resolveIssue(issueId, resolution);
    }
}

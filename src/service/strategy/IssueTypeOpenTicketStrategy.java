package service.strategy;

import constants.Status;
import models.Issue;
import service.AgentService;
import service.IssueService;

import java.util.List;

public class IssueTypeOpenTicketStrategy implements AssignmentStrategy{

    private final AgentService agentService;
    private final IssueService issueService;

    public IssueTypeOpenTicketStrategy(AgentService agentService, IssueService issueService) {
        this.agentService = agentService;
        this.issueService = issueService;
    }

    @Override
    public String assign(String issueType) {
        List<String> agentList  = agentService.getAgentList(issueType);
        String finalAgent ="";
        long minOpenIssues = Integer.MAX_VALUE;
        for(String agent: agentList) {
            List<Issue> issueList = agentService.getIssues(agent);
            long count = issueList.stream()
                    .filter(issue -> issue.getIssueType().equals(issueType))
                    .filter(issue -> issue.getStatus().equals(Status.OPEN))
                    .count();
            if (count<minOpenIssues) {
                minOpenIssues = count;
                finalAgent = agent;
            }
        }
        return finalAgent;
    }
}

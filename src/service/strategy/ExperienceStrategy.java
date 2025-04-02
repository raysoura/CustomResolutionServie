package service.strategy;

import constants.Status;
import models.Issue;
import service.AgentService;
import service.IssueService;

import java.util.List;

public class ExperienceStrategy implements AssignmentStrategy {
    private final AgentService agentService;
    private final IssueService issueService;

    public ExperienceStrategy(AgentService agentService, IssueService issueService) {
        this.agentService = agentService;
        this.issueService = issueService;
    }

    @Override
    public String assign(String issueType) {
        List<String> agentList = agentService.getAgentList(issueType);
        String agent = "";
        long maxExperience = 0;

        for(String ag: agentList) {
            List<Issue> issueList = agentService.getIssues(ag);
            long count = issueList.stream().filter(issue -> issue.getStatus().equals(Status.RESOLVED)).count();
            if (count>maxExperience) {
                maxExperience = count;
                agent = ag;
            }
        }
        return agent;
    }
}

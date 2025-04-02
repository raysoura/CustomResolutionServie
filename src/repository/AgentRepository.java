package repository;

import constants.Status;
import models.Issue;

import java.util.*;
import java.util.stream.Collectors;

public class AgentRepository {
    private final Map<Integer, List<String>> expertiseAgentMap;
    private final Map<String, List<Issue>> agentIssueMap;

    public AgentRepository() {
        this.expertiseAgentMap = new HashMap<>();
        this.agentIssueMap = new HashMap<>();
    }


    public String addAgent(String agentId, List<Integer> expertise) {
        if (agentIssueMap.containsKey(agentId)) {
            return "agent already exists";
        }
        expertise.stream().forEach(expert -> {
            List<String> agents = expertiseAgentMap.getOrDefault(expert, new ArrayList<>());
            if(!agents.contains(agents))
                agents.add(agentId);
            expertiseAgentMap.put(expert, agents);
        });
        return "success";
    }

    public List<String> getAgentHistory(String agentId) {
        return agentIssueMap.get(agentId).stream()
                .filter(issue -> Status.RESOLVED.equals(issue.getStatus()))
                .map(issue -> issue.getIssueId())
                .collect(Collectors.toList());
    }

    public void updateAgentIssue(String agentId, Issue issue) {
        List<Issue> issueList = agentIssueMap.getOrDefault(agentId, new ArrayList<>());
        issueList.add(issue);
        agentIssueMap.put(agentId, issueList);
    }

    public List<Issue> getIssues(String agentId) {
        return agentIssueMap.get(agentId);
    }

    public List<String> getExpertAgent(String issueType) {
        return expertiseAgentMap.get(issueType);
    }
}

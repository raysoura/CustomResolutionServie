package repository;

import constants.Status;
import models.Issue;

import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private final Map<String, Issue> issueMap;
    private final Map<String, String> issueAgentMap;

    public IssueRepository() {
        this.issueMap = new HashMap<>();
        this.issueAgentMap = new HashMap<>();
    }


    public String createIssue(String issueId, String orderId, String issueType, String description) {
        issueMap.put(issueId, new Issue(issueId, orderId, issueType, description));
        return "issue created";
    }

    public void resolveIssue(String issueId, String resolution) {
        Issue issue = issueMap.get(issueId);
        issue.setResolution(resolution);
        issue.setStatus(Status.RESOLVED);

    }

    public Issue getIssue(String issueId) {
        return issueMap.get(issueId);
    }
}

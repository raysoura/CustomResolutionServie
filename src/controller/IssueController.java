package controller;

import service.IssueService;

public class IssueController {
    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    public String createIssue(String issueId, String orderId, String issueType, String description) {
        return issueService.createIssue(issueId, orderId, issueType, description);
    }

    public String assignIssue(String issueId, int assignStrategy) {
        return issueService.assignIssue(issueId, assignStrategy);
    }

    public void resolveIssue(String issueId, String resolution) {
        issueService.resolveIssue(issueId, resolution);
    }
}

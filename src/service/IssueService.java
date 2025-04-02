package service;

public interface IssueService {

    String createIssue(String issueId, String orderId, String issueType, String description);

    String assignIssue(String issueId, int assignStrategy);

    void resolveIssue(String issueId, String resolution);
}

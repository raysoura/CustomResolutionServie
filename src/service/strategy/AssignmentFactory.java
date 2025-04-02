package service.strategy;

public class AssignmentFactory {
    private final ExperienceStrategy experienceStrategy;
    private final LowOpenTicketStrategy lowOpenTicketStrategy;
    private final IssueTypeOpenTicketStrategy issueTypeOpenTicketStrategy;

    public AssignmentFactory(ExperienceStrategy experienceStrategy,
                             LowOpenTicketStrategy lowOpenTicketStrategy,
                             IssueTypeOpenTicketStrategy issueTypeOpenTicketStrategy) {
        this.experienceStrategy = experienceStrategy;
        this.lowOpenTicketStrategy = lowOpenTicketStrategy;
        this.issueTypeOpenTicketStrategy = issueTypeOpenTicketStrategy;
    }

    public AssignmentStrategy getStrategy(int assignmentType) {
        if (assignmentType == 0) {
            return lowOpenTicketStrategy;
        }
        else if (assignmentType == 1) {
            return experienceStrategy;
        }
        else if (assignmentType == 2) {
            return issueTypeOpenTicketStrategy;
        }
        //throw correct exception
        return null;
    }
}

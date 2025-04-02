package controller;

import service.AgentService;

import java.util.List;

public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    String addAgent(String agentId, List<Integer> expertise) {
        return agentService.addAgent(agentId, expertise);
    }

    List<String> getAgentHistory(String agentId) {
        return agentService.getAgentHistory(agentId);
    }
}

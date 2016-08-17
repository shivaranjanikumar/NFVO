package org.openbaton.tosca.templates.TopologyTemplate;

import org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP.CPNodeTemplate;

import java.util.Map;

/**
 * Created by rvl on 17.08.16.
 */

public class NodeTemplates {

    private Map<String, CPNodeTemplate> node_templates;

    public Map<String, CPNodeTemplate> getNodes() {
        return node_templates;
    }

    public void setNodes(Map<String, CPNodeTemplate> nodes) {
        this.node_templates = nodes;
    }

    @Override
    public String toString(){

        return "Node Templates: \n" +
                "Node: " + node_templates + "\n";
    }
}

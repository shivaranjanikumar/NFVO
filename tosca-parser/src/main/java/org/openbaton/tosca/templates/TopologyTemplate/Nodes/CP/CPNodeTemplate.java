package org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP;

import org.openbaton.tosca.templates.TopologyTemplate.Nodes.NodeTemplate;

/**
 * Created by rvl on 17.08.16.
 */
public class CPNodeTemplate{

    private String type = null;
    private CPProperties properties = null;
    //TODO: Edit Requirements
    private CPRequirements requirements = null;
    private CPAttributes attributes = null;

    public CPNodeTemplate(){}

    public CPNodeTemplate(NodeTemplate nodeTemplate){
        this.type = nodeTemplate.getType();

        if(nodeTemplate.getProperties() != null ){
            this.properties = new CPProperties(nodeTemplate.getProperties());
        }
        if(nodeTemplate.getAttributes() != null ){
            this.attributes = new CPAttributes(nodeTemplate.getAttributes());
        }
        if(nodeTemplate.getRequirements() != null ){
            this.requirements = new CPRequirements(nodeTemplate.getRequirements());
        }
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(CPProperties properties) {
        this.properties = properties;
    }

    public CPAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(CPAttributes attributes) {
        this.attributes = attributes;
    }

    public CPRequirements getRequirements() {
        return requirements;
    }

    public void setRequirements(CPRequirements requirements) {
        this.requirements = requirements;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "CP Node: \n" +
                "type: " + type + "\n" +
                "Properties: " + properties + "\n" +
                "Requirements: " + requirements + "\n" +
                "Attributes: " + attributes;
    }
}

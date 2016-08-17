package org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP;

/**
 * Created by rvl on 17.08.16.
 */
public class CPNodeTemplate {

    private String type;
    private CPProperties properties;
    //TODO: Edit Requirements
    private CPRequirements requirements;
    private CPAttributes attributes;

    public CPNodeTemplate(){}

    public CPProperties getProperties() {
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

    @Override
    public String toString(){
        return "CP Node: \n" +
                "type: " + type + "\n" +
                "Properties: " + properties + "\n" +
                "Requirements: " + requirements + "\n" +
                "Attributes: " + attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

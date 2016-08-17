package org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP;

/**
 * Created by rvl on 17.08.16.
 */
public class CPRequirements {

    private String virtualLink;
    private String virtualBinding;


    public CPRequirements(){}

    public String getVirtualLink() {
        return virtualLink;
    }

    public void setVirtualLink(String virtualLink) {
        this.virtualLink = virtualLink;
    }

    public String getVirtualBinding() {
        return virtualBinding;
    }

    public void setVirtualBinding(String virtualBinding) {
        this.virtualBinding = virtualBinding;
    }

    @Override
    public String toString(){
        return "CP Requirements: \n" +
                "VirtualBinding: " + virtualBinding + "\n" +
                "VirtualLink: " + virtualLink;
    }
}

package org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP;

/**
 * Created by rvl on 17.08.16.
 */
public class CPAttributes {

    private String address;

    public CPAttributes(){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "CP Attributes: \n" +
                "Address: " + address + "\n";
    }
}

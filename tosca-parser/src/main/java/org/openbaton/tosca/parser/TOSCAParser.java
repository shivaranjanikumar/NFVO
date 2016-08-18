package org.openbaton.tosca.parser;

import org.openbaton.catalogue.mano.descriptor.VNFDConnectionPoint;
import org.openbaton.catalogue.mano.descriptor.VirtualDeploymentUnit;
import org.openbaton.catalogue.mano.descriptor.VirtualNetworkFunctionDescriptor;
import org.openbaton.tosca.templates.NSDTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP.CPNodeTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.VDU.VDUNodeTemplate;
import org.openbaton.tosca.templates.VNFDTemplate;

/**
 * Created by rvl on 17.08.16.
 */
public class TOSCAParser {

    public TOSCAParser(){}

    public VNFDConnectionPoint parseCPTemplate(CPNodeTemplate cpTemplate){

        VNFDConnectionPoint cp = new VNFDConnectionPoint();

        cp.setVirtual_link_reference(cpTemplate.getRequirements().getVirtualLink());
        cp.setFloatingIp(cpTemplate.getRequirements().getFloatingIP());

        return cp;
    }

    //TODO: Parse a VDU Template and return VDU instance
    public VirtualDeploymentUnit parseVDUTemplate(VDUNodeTemplate vduTemplate){

        VirtualDeploymentUnit vdu = new VirtualDeploymentUnit();
        vdu.setName(vduTemplate.getName());



        return vdu;
    }

    //TODO: Parse VNFDTemplate and return VNFD instance
    public VirtualNetworkFunctionDescriptor parseVNFDTemplate(VNFDTemplate vnfdTemplate){

        VirtualNetworkFunctionDescriptor vnfd = new VirtualNetworkFunctionDescriptor();



        return vnfd;
    }

    //TODO: Parse NSDTemplate and return NSD instance
    public void parseNSDTemplate(NSDTemplate nsdTemplate){}
}

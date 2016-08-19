package org.openbaton.tosca.parser;

import org.openbaton.catalogue.mano.descriptor.*;
import org.openbaton.tosca.templates.NSDTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP.CPNodeTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.VDU.VDUNodeTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.VL.VLNodeTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.VNF.VNFNodeTemplate;
import org.openbaton.tosca.templates.VNFDTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rvl on 17.08.16.
 */
public class TOSCAParser {

    public TOSCAParser(){}


    private InternalVirtualLink parseVL(VLNodeTemplate vlNodeTemplate){

        InternalVirtualLink vl = new InternalVirtualLink();

        vl.setName(vlNodeTemplate.getName());

        return vl;
    }

    private VNFDConnectionPoint parseCPTemplate(CPNodeTemplate cpTemplate){

        VNFDConnectionPoint cp = new VNFDConnectionPoint();

        cp.setVirtual_link_reference(cpTemplate.getRequirements().getVirtualLink());
        cp.setFloatingIp(cpTemplate.getRequirements().getFloatingIP());

        return cp;
    }

    //TODO: Parse a VDU Template and return VDU instance
    private VirtualDeploymentUnit parseVDUTemplate(VDUNodeTemplate vduTemplate, List<CPNodeTemplate> cps){

        VirtualDeploymentUnit vdu = new VirtualDeploymentUnit();
        vdu.setName(vduTemplate.getName());

        // ADD Settings
        vdu.setScale_in_out(vduTemplate.getProperties().getScale_in_out());
        vdu.setVimInstanceName(vduTemplate.getProperties().getVim_instance_name());
        vdu.setVm_image(new HashSet<String>(vduTemplate.getProperties().getVm_image()));
        vdu.setVm_image(new HashSet<String>(vduTemplate.getProperties().getVm_image()));

        // ADD VNF Connection Points
        Set<VNFComponent> vnfComponents = new HashSet<>();
        VNFComponent vnfc = new VNFComponent();
        Set<VNFDConnectionPoint> connectionPoints = new HashSet<>();

        for( CPNodeTemplate cp : cps){
            if(cp.getRequirements().getVirtualBinding().equals(vduTemplate.getName())){

                connectionPoints.add(parseCPTemplate(cp));
            }
        }
        vnfc.setConnection_point(connectionPoints);
        vnfComponents.add(vnfc);
        vdu.setVnfc(vnfComponents);

        return vdu;
    }

    private VirtualNetworkFunctionDescriptor parseVNFNode(VNFNodeTemplate vnf){

        VirtualNetworkFunctionDescriptor vnfd = new VirtualNetworkFunctionDescriptor();



        return vnfd;
    }

    //TODO: Parse VNFDTemplate and return VNFD instance
    public VirtualNetworkFunctionDescriptor parseVNFDTemplate(VNFDTemplate vnfdTemplate){

        VirtualNetworkFunctionDescriptor vnfd = new VirtualNetworkFunctionDescriptor();

        // ADD SETTINGS

        vnfd.setId(vnfdTemplate.getMetadata().getID());
        vnfd.setVendor(vnfdTemplate.getMetadata().getVendor());
        vnfd.setVersion(vnfdTemplate.getMetadata().getVersion());

        vnfd.setDeployment_flavour(vnfdTemplate.getDeploymentFlavourConverted());
        vnfd.setVnfPackageLocation(vnfdTemplate.getVnfPackageLocation());

        // ADD VDUs
        Set<VirtualDeploymentUnit> vdus = new HashSet<>();

        //TODO: MB Add nodes based on requirements instead of list ?
        for(VDUNodeTemplate vdu : vnfdTemplate.getTopology_template().getVDUNodes()){

            vdus.add(parseVDUTemplate(vdu, vnfdTemplate.getTopology_template().getCPNodes()));
        }
        vnfd.setVdu(vdus);

        // ADD VLs
        Set<InternalVirtualLink> vls = new HashSet<>();

        for(VLNodeTemplate vl : vnfdTemplate.getTopology_template().getVLNodes()){

            vls.add(parseVL(vl));
        }
        vnfd.setVirtual_link(vls);

        vnfd.setLifecycle_event(vnfdTemplate.getInterfaces().getOpLifecycle());

        return vnfd;
    }

    //TODO: Parse NSDTemplate and return NSD instance
    public NetworkServiceDescriptor parseNSDTemplate(NSDTemplate nsdTemplate){

        NetworkServiceDescriptor nsd = new NetworkServiceDescriptor();

        return nsd;
    }
}

package org.openbaton.tosca.templates;

import org.openbaton.catalogue.mano.common.VNFDeploymentFlavour;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.VNF.VNFInterfaces;
import org.openbaton.tosca.templates.TopologyTemplate.TopologyTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rvl on 17.08.16.
 */
public class VNFDTemplate {

    private String tosca_definitions_version;
    private String description = "";
    private TOSCAMetadata metadata;
    private Object node_types = null;
    private TopologyTemplate topology_template;
    private String vnfPackageLocation = null;
    private ArrayList<String> deploymentFlavour = null;
    private VNFInterfaces interfaces = null;
    private Object configurations = null;


    public String getTosca_definitions_version() {
        return tosca_definitions_version;
    }

    public void setTosca_definitions_version(String tosca_definitions_version) {
        this.tosca_definitions_version = tosca_definitions_version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TOSCAMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(TOSCAMetadata metadata) {
        this.metadata = metadata;
    }

    public Object getNode_types() {
        return node_types;
    }

    public void setNode_types(Object node_types) {
        this.node_types = node_types;
    }

    public void setTopology_template(TopologyTemplate topology_template) {
        this.topology_template = topology_template;
    }

    public TopologyTemplate getTopology_template(){
        return this.topology_template;
    }


    public String getVnfPackageLocation() {
        return vnfPackageLocation;
    }

    public void setVnfPackageLocation(String vnfPackageLocation) {
        this.vnfPackageLocation = vnfPackageLocation;
    }

    public ArrayList<String> getDeploymentFlavour() {
        return deploymentFlavour;
    }

    public void setDeploymentFlavour(ArrayList<String> deploymentFlavour) {
        this.deploymentFlavour = deploymentFlavour;
    }

    public Set<VNFDeploymentFlavour> getDeploymentFlavourConverted(){

        Set<VNFDeploymentFlavour> vnfdf = new HashSet<>();

        if(deploymentFlavour != null){
            for(String df : deploymentFlavour){

                VNFDeploymentFlavour new_df = new VNFDeploymentFlavour();
                new_df.setFlavour_key(df);
                vnfdf.add(new_df);
            }
        }

        return vnfdf;
    }

    public VNFInterfaces getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(VNFInterfaces vnfInterfaces) {
        this.interfaces = vnfInterfaces;
    }

    public Object getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Object configurations) {
        this.configurations = configurations;
    }

    public String toString(){

        return "tosca_definitions_version" + tosca_definitions_version + "\n" +
                "description" + description + "\n" +
                "Metadata: " + metadata + "\n" +
                "node_types: " + node_types + "\n" +
                "topology_template: " + topology_template + "\n" +
                "vnf_interfaces: " + interfaces + "\n" +
                "vnfPackageLoc: " + vnfPackageLocation + "\n";
    }



}

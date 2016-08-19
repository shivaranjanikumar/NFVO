package org.openbaton.tosca.tests;

import org.junit.Test;
import org.openbaton.catalogue.mano.descriptor.VirtualNetworkFunctionDescriptor;
import org.openbaton.tosca.parser.TOSCAParser;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP.CPNodeTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.VDU.VDUNodeTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.Nodes.VL.VLNodeTemplate;
import org.openbaton.tosca.templates.TopologyTemplate.TopologyTemplate;
import org.openbaton.tosca.templates.VNFDTemplate;
import org.openbaton.tosca.templates.exceptions.NotSupportedType;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by rvl on 16.08.16.
 */
public class ToscaTest {

    @Test
    public void testVNFDTemplate() throws FileNotFoundException, NotSupportedType {

        InputStream vnfdFile = new FileInputStream(new File("src/main/resources/Testing/testVNFDTemplate.yaml"));

        Constructor constructor = new Constructor(VNFDTemplate.class);
        TypeDescription typeDescription = new TypeDescription(VNFDTemplate.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        VNFDTemplate vnfdInput = yaml.loadAs(vnfdFile, VNFDTemplate.class);

        System.out.println(vnfdInput.toString());
    }

    @Test
    public void testGetNodesFromVNFDTemplate() throws FileNotFoundException, NotSupportedType {

        InputStream vnfdFile = new FileInputStream(new File("src/main/resources/Testing/testVNFDTemplate.yaml"));

        Constructor constructor = new Constructor(VNFDTemplate.class);
        TypeDescription typeDescription = new TypeDescription(VNFDTemplate.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        VNFDTemplate vnfdInput = yaml.loadAs(vnfdFile, VNFDTemplate.class);

        System.out.println(vnfdInput.getTopology_template().getVDUNodes());
        System.out.println(vnfdInput.getTopology_template().getCPNodes());
    }

    @Test
    public void testGettingVDUNodes() throws FileNotFoundException, NotSupportedType {

        InputStream cpFile = new FileInputStream(new File("src/main/resources/Testing/testTopologyTemplate.yaml"));

        Constructor constructor = new Constructor(TopologyTemplate.class);
        TypeDescription typeDescription = new TypeDescription(TopologyTemplate.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        TopologyTemplate cpInput = yaml.loadAs(cpFile, TopologyTemplate.class);

        List<VDUNodeTemplate> vduNodes = cpInput.getVDUNodes();

        for(VDUNodeTemplate n : vduNodes){
            System.out.println(n.toString());
        }
    }

    @Test
    public void testGettingVLNodes() throws FileNotFoundException, NotSupportedType {

        InputStream cpFile = new FileInputStream(new File("src/main/resources/Testing/testVNFDTemplate.yaml"));

        Constructor constructor = new Constructor(VNFDTemplate.class);
        TypeDescription typeDescription = new TypeDescription(VNFDTemplate.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        VNFDTemplate cpInput = yaml.loadAs(cpFile, VNFDTemplate.class);

        List<VLNodeTemplate> vlNodes = cpInput.getTopology_template().getVLNodes();

        for(VLNodeTemplate n : vlNodes){
            System.out.println(n.toString());
        }
    }

    @Test
    public void testTopologyTemplate() throws NotSupportedType, FileNotFoundException{

        InputStream cpFile = new FileInputStream(new File("src/main/resources/Testing/testTopologyTemplate.yaml"));

        Constructor constructor = new Constructor(TopologyTemplate.class);
        TypeDescription typeDescription = new TypeDescription(TopologyTemplate.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        TopologyTemplate cpInput = yaml.loadAs(cpFile, TopologyTemplate.class);

        System.out.println(cpInput.toString());
    }

    @Test
    public void testGettingCPNodes()throws NotSupportedType, FileNotFoundException{

        InputStream cpFile = new FileInputStream(new File("src/main/resources/Testing/testTopologyTemplate.yaml"));

        Constructor constructor = new Constructor(TopologyTemplate.class);
        TypeDescription typeDescription = new TypeDescription(TopologyTemplate.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        TopologyTemplate cpInput = yaml.loadAs(cpFile, TopologyTemplate.class);

        List<CPNodeTemplate> cpNodes = cpInput.getCPNodes();

        for(CPNodeTemplate n : cpNodes){
            System.out.println(n.toString());
        }
    }

    @Test
    public void testCreatingVNFDInstance() throws FileNotFoundException, NotSupportedType {

        InputStream vnfdFile = new FileInputStream(new File("src/main/resources/Testing/testVNFDTemplate.yaml"));

        Constructor constructor = new Constructor(VNFDTemplate.class);
        TypeDescription typeDescription = new TypeDescription(VNFDTemplate.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        VNFDTemplate vnfdInput = yaml.loadAs(vnfdFile, VNFDTemplate.class);

        TOSCAParser parser = new TOSCAParser();

        VirtualNetworkFunctionDescriptor vnfd = parser.parseVNFDTemplate(vnfdInput);

        System.out.println(vnfd.toString());

    }

    @Test
    public void testVNFDServerIperf() throws FileNotFoundException, NotSupportedType{

        InputStream vnfdFile = new FileInputStream(new File("src/main/resources/Testing/vnfd_server_iperf.yaml"));

        Constructor constructor = new Constructor(VNFDTemplate.class);
        TypeDescription typeDescription = new TypeDescription(VNFDTemplate.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        VNFDTemplate vnfdInput = yaml.loadAs(vnfdFile, VNFDTemplate.class);

        TOSCAParser parser = new TOSCAParser();

        VirtualNetworkFunctionDescriptor vnfd = parser.parseVNFDTemplate(vnfdInput);

        System.out.println(vnfd.toString());
    }
}

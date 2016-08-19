package org.openbaton.tosca.templates.TopologyTemplate.Nodes.VNF;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by rvl on 19.08.16.
 */
public class VNFRequirements {

    private List<String> virtualLinks = new ArrayList<>();
    private List<String> forwarders = new ArrayList<>();

    public VNFRequirements(Object reqs){

        ArrayList<LinkedHashMap<String, String>> resMap = (ArrayList<LinkedHashMap<String, String>>) reqs;
        for(LinkedHashMap<String, String> pair : resMap){

            if(pair.keySet().toArray()[0].equals("virtualLink")){
                virtualLinks.add(pair.get("virtualLink").toString());
            }
        }
    }

    public List<String> getVirtualLinks() {
        return virtualLinks;
    }

    public void setVirtualLinks(List<String> virtualLinks) {
        this.virtualLinks = virtualLinks;
    }

    public List<String> getForwarders() {
        return forwarders;
    }

    public void setForwarders(List<String> forwarders) {
        this.forwarders = forwarders;
    }
}

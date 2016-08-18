package org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP;

import java.util.Map;

/**
 * Created by rvl on 17.08.16.
 */
public class CPProperties {

    private String type = null;
    //TODO: FIX
    private boolean anti_spoof_protection = false;

    public CPProperties(Object properties){
        Map<String, Object> propertiesMap = (Map<String, Object>) properties;

        if(propertiesMap.containsKey("type")){
            this.type = (String) propertiesMap.get("type");
        }

        if(propertiesMap.containsKey("anti_spoof_protection")){
            this.anti_spoof_protection = (Boolean) propertiesMap.get("anti_spoof_protection");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getAnti_spoof_protection() {
        return anti_spoof_protection;
    }

    public void setAnti_spoof_protection(boolean anti_spoof_protection) {
        this.anti_spoof_protection = anti_spoof_protection;
    }

    @Override
    public String toString(){
        return "CP Properties: \n" +
                "Type: " + type + "\n" +
                "AntiSpoof: " + anti_spoof_protection;
    }
}

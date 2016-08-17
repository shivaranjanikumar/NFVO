package org.openbaton.tosca.templates.TopologyTemplate.Nodes.CP;

/**
 * Created by rvl on 17.08.16.
 */
public class CPProperties {

    private String type;
    private Boolean anti_spoof_protection;

    public CPProperties(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAnti_spoof_protection() {
        return anti_spoof_protection;
    }

    public void setAnti_spoof_protection(Boolean anti_spoof_protection) {
        this.anti_spoof_protection = anti_spoof_protection;
    }

    @Override
    public String toString(){
        return "CP Properties: \n" +
                "Type: " + type + "\n" +
                "AntiSpoof: " + anti_spoof_protection.toString();
    }
}

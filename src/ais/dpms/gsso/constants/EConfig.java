package ais.dpms.gsso.constants;

import phoebe.eqx.icarus.configuration.EPattern;

public enum EConfig {
	APPLICATION_NAME("Application-Name", true, false, EPattern.ANYTHING),  //new
    COMMONLOG_DETAIL_LOG_ENABLE("Detail-Log-Enable", true, false, EPattern.TRUE_OR_FALSE),  //new
    COMMONLOG_SUMMARY_LOG_ENABLE("Summary-Log-Enable", true, false, EPattern.TRUE_OR_FALSE),  //new
    DETAIL_LOG_NAME("Detail-Log-Name", true, false, EPattern.ANYTHING),
    SUMMARY_LOG_NAME("Summary-Log-Name", true, false, EPattern.ANYTHING),
    RESOURCE_NAME_SDF("Resource-Name-SDF", true, false, EPattern.ANYTHING),
    SDF_TIMEOUT("SDF-Timeout", true, false, EPattern.NUMBER),
    APPLICATION_NODE_NAME("Application-Node-Name", true, false, EPattern.ANYTHING),
    ;
	
	private final String configName;
    private final boolean isMandatory;
    private final boolean isMultiple;
    private final String regExFormat;

    EConfig(String configName, boolean isMandatory, boolean isMultiple, String regExFormat) {
        this.configName = configName;
        this.isMandatory = isMandatory;
        this.isMultiple = isMultiple;
        this.regExFormat = regExFormat;
    }

    EConfig(String configName, boolean isMandatory, boolean isMultiple, EPattern regExFormat) {
        this.configName = configName;
        this.isMandatory = isMandatory;
        this.isMultiple = isMultiple;
        this.regExFormat = regExFormat.getPattern();
    }

    public String getConfigName() {
        return this.configName;
    }

    public boolean isMandatory() {
        return this.isMandatory;
    }

    public boolean isMultiple() {
        return this.isMultiple;
    }

    public String getRegExFormat() {
        return this.regExFormat;
    }
}
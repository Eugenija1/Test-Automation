package project.model;

public class CalculatorForm {
    private String instances;
    private String operatingSystem;
    private String machineClass;
    private String machineType;
    private String addGPU;
    private String gpuNumber;
    private String gpuType;
    private String localSSD;
    private String location;
    private String committedUsage;

    public CalculatorForm(String instances, String operatingSystem, String machineClass, String machineType, String addGPU, String gpuNumber,
                          String gpuType, String localSSD, String location, String committedUsage) {
        this.instances = instances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.addGPU = addGPU;
        this.gpuNumber = gpuNumber;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.location = location;
        this.committedUsage = committedUsage;
    }

    public String getInstances() {
        return instances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getMachineClass(){
        return machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuNumber() {
        return gpuNumber;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getLocation() {
        return location;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getAddGPU() {
        return addGPU;
    }
}

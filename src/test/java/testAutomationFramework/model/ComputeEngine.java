package testAutomationFramework.model;

import java.util.Objects;

public class ComputeEngine {
    private String instancesNumber;
    private String operatingSystem;
    private String machineClass;
    private String series;
    private String machineType;
    private String gpuType;
    private String numberOfGPUs;
    private String localSsd;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEngine(String instancesNumber,
                         String operatingSystem,
                         String machineClass,
                         String series,
                         String machineType,
                         String gpuType,
                         String numberOfGPUs,
                         String localSsd,
                         String datacenterLocation,
                         String committedUsage) {
        this.instancesNumber = instancesNumber;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.series = series;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSsd = localSsd;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getInstancesNumber() {
        return instancesNumber;
    }

    public void setInstancesNumber(String instancesNumber) {
        this.instancesNumber = instancesNumber;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return Objects.equals(instancesNumber, that.instancesNumber)
                && Objects.equals(operatingSystem, that.operatingSystem)
                && Objects.equals(machineClass, that.machineClass)
                && Objects.equals(series, that.series)
                && Objects.equals(machineType, that.machineType)
                && Objects.equals(gpuType, that.gpuType)
                && Objects.equals(numberOfGPUs, that.numberOfGPUs)
                && Objects.equals(localSsd, that.localSsd)
                && Objects.equals(datacenterLocation, that.datacenterLocation)
                && Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instancesNumber,
                operatingSystem,
                machineClass,
                series,
                machineType,
                gpuType,
                numberOfGPUs,
                localSsd,
                datacenterLocation,
                committedUsage);
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "instancesNumber='" + instancesNumber + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }
}

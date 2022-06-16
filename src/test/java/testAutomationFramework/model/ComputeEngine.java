package testAutomationFramework.model;

import java.util.Objects;

public class ComputeEngine {
    private final String instancesNumber;
    private final String operatingSystem;
    private final String machineClass;
    private final String series;
    private final String machineType;
    private final String gpuType;
    private final String numberOfGPUs;
    private final String localSsd;
    private final String datacenterLocation;
    private final String committedUsage;

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

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
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

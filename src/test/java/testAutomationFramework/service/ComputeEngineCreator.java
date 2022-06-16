package testAutomationFramework.service;

import testAutomationFramework.model.ComputeEngine;

public class ComputeEngineCreator {
    private static final String INSTANCES_NUMBER = "testdata.computeEngine.instancesNumber";
    private static final String OPERATING_SYSTEM = "testdata.computeEngine.operatingSystem";
    private static final String MACHINE_CLASS = "testdata.computeEngine.machineClass";
    private static final String SERIES = "testdata.computeEngine.series";
    private static final String MACHINE_TYPE = "testdata.computeEngine.machineType";
    private static final String GPU_TYPE = "testdata.computeEngine.gpuType";
    private static final String NUMBER_OF_GPUS = "testdata.computeEngine.numberOfGPUs";
    private static final String LOCAL_SSD = "testdata.computeEngine.localSsd";
    private static final String DATACENTER_LOCATION = "testdata.computeEngine.datacenterLocation";
    private static final String COMMITTED_USAGE = "testdata.computeEngine.committedUsage";

    public static ComputeEngine configureItem() {
        return new ComputeEngine(TestDataReader.getTestData(INSTANCES_NUMBER),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }
}

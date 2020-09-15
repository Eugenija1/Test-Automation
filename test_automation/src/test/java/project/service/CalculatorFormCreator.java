package project.service;
import project.model.CalculatorForm;

public class CalculatorFormCreator {
    public static final String INSTANCES = "testdata.form.instances";
    public static final String OPERATING_SYSTEM = "testdata.form.operating_system";
    public static final String MACHINE_CLASS = "testdata.form.machine_class";
    public static final String MACHINE_TYPE = "testdata.form.machine_type";
    public static final String ADD_GPU = "testdata.form.add_gpu";
    public static final String GPU_NUMBER = "testdata.form.gpu_number";
    public static final String GPU_TYPE = "testdata.form.gpu_type";
    public static final String LOCAL_SSD = "testdata.form.local_ssd";
    public static final String LOCATION = "testdata.form.location";
    public static final String COMMITTED_USAGE = "testdata.form.committed_usage";

    public static CalculatorForm withCredentialsFromProperty(){
        return new CalculatorForm(TestDataReader.getTestData(INSTANCES),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(ADD_GPU),
                TestDataReader.getTestData(GPU_NUMBER),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }
}
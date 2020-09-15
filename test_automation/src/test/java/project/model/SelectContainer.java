package project.model;

public enum SelectContainer {
    //OPERATING_SYSTEM("53", ""),
    MACHINE_CLASS("54", "78"),
    MACHINE_TYPE("57", "87"),
    NUMBER_GPU("370", "373"),
    TYPE_GPU("371", "375"),
    SSD("192", "194"),
    LOCATION("58", "89"),
    COMMIT_USAGE("59", "96");

    private String label;
    private String containerId;

    SelectContainer(String label, String containerId) {
        this.label = label;
        this.containerId = containerId;
    }

    public static String valueLabel(SelectContainer name){
        return name.label;
    }

    public static String containerId(SelectContainer name){
        return name.containerId;
    }
}

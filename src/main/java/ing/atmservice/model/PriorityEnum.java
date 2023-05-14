package ing.atmservice.model;

public enum PriorityEnum {
    FAILURE_RESTART(1),
    PRIORITY(2),
    SIGNAL_LOW(3),
    STANDARD(4);

    //1 - THE HIGHEST priority, 4 - THE LOWEST priority
    private int priorityLevel;

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    PriorityEnum(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }


}

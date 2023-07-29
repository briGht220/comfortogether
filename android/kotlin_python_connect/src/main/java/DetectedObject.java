public class DetectedObject {
    private String objectName;
    private int objectSize;
    private int objectCoordinateX;
    private int objectCoordinateY;
    private float detectingAccuracy;

    public DetectedObject(String objectName, int objectSize, int objectCoordinateX, int objectCoordinateY, float detectingAccuracy) {
        this.objectName = objectName;
        this.objectSize = objectSize;
        this.objectCoordinateX = objectCoordinateX;
        this.objectCoordinateY = objectCoordinateY;
        this.detectingAccuracy = detectingAccuracy;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public int getObjectSize() {
        return objectSize;
    }

    public void setObjectSize(int objectSize) {
        this.objectSize = objectSize;
    }

    public int getObjectCoordinateX() {
        return objectCoordinateX;
    }

    public void setObjectCoordinateX(int objectCoordinateX) {
        this.objectCoordinateX = objectCoordinateX;
    }

    public int getObjectCoordinateY() {
        return objectCoordinateY;
    }

    public void setObjectCoordinateY(int objectCoordinateY) {
        this.objectCoordinateY = objectCoordinateY;
    }

    public float getDetectingAccuracy() {
        return detectingAccuracy;
    }

    public void setDetectingAccuracy(int detectingAccuracy) {
        this.detectingAccuracy = detectingAccuracy;
    }
}

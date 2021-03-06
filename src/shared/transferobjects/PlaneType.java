package shared.transferobjects;

import java.io.Serializable;

public class PlaneType implements Serializable {

    private int planeId;
    private String planeType;

    public PlaneType(int planeId, String planeType) {
        this.planeId = planeId;
        this.planeType = planeType;

    }

    public PlaneType(String planeType)
    {
        this.planeType = planeType;
    }

    public PlaneType(int planeId)
    {
        this.planeId = planeId;
    }

    //planetype
    public int getPlaneId() {
        return planeId;
    }
    public String getPlaneType() {
        return planeType;
    }


    @Override
    public String toString() {
        return "PlaneType{" +
                "planeId=" + planeId +
                ", planeType='" + planeType + '\'' +
                '}';
    }
}

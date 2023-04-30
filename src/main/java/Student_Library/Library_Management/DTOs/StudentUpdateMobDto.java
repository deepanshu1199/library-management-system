package Student_Library.Library_Management.DTOs;

public class StudentUpdateMobDto {
    private int id;
    private String MobNo;

    public StudentUpdateMobDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return MobNo;
    }

    public void setMobNo(String mobNo) {
        MobNo = mobNo;
    }
}

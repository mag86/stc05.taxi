package main.model.pojo;

/**
 *
 */
public class Cars {

    private int car_id;
    private String car_phonenumber;
    private String driver_name;
    private String car_type;
    private String car_name;
    private String car_number;
    private String car_color;

    //private Group group;
    private int groupId;

    public Cars(){

    }

    public Cars(int car_id,
                String car_phonenumber,
                String driver_name,
                String car_type,
                String car_name,
                String car_number,
                String car_color,
                Group group,
                int groupId) {
        this.car_id = car_id;
        this.car_phonenumber = car_phonenumber;
        this.driver_name = driver_name;
        this.car_type = car_type;
        this.car_name = car_name;
        this.car_number = car_number;
        this.car_color = car_color;
        //this.group = group;
        this.groupId = groupId;
    }

    public String getCar_phonenumber() {
        return car_phonenumber;
    }

    public void setCar_phonenumber(String car_phonenumber) {
        this.car_phonenumber = car_phonenumber;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }
    public long getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }


//
//    public Group getGroup() {
//        return group;
//    }

//    public void setGroup(Group group) {
//        this.group = group;
//    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getCar_name() {
        return car_name;
    }
}

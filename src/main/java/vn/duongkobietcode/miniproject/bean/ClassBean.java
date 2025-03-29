package vn.duongkobietcode.miniproject.bean;

public class ClassBean {
    private String registerDate;
    private int numberOfStudents;

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public ClassBean(String registerDate, int numberOfStudents) {
        this.registerDate = registerDate;
        this.numberOfStudents = numberOfStudents;
    }

    public ClassBean() {
    }

}

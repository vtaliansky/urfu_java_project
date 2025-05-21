public class School {
    private int    district;
    private String school;
    private String county;
    private String grades;
    private int    students;
    private double teachers;
    private double expenditure;
    private double math;

    // ── getters / setters ──
    public int    getDistrict()   { return district; }
    public void   setDistrict(int district) { this.district = district; }
    public String getSchool()     { return school; }
    public void   setSchool(String school) { this.school = school; }
    public String getCounty()     { return county; }
    public void   setCounty(String county) { this.county = county; }
    public String getGrades()     { return grades; }
    public void   setGrades(String grades) { this.grades = grades; }
    public int    getStudents()   { return students; }
    public void   setStudents(int students) { this.students = students; }
    public double getTeachers()   { return teachers; }
    public void   setTeachers(double teachers) { this.teachers = teachers; }
    public double getExpenditure(){ return expenditure; }
    public void   setExpenditure(double expenditure){ this.expenditure = expenditure; }
    public double getMath()       { return math; }
    public void   setMath(double math) { this.math = math; }
}
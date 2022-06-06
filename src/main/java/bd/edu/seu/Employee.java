package bd.edu.seu;

public class Employee {
    private String firstName;
    private String lastName;
    private String qualification;
    private String address;
    private String email;
    private String contact;
    private String password;
    private String gender;
    private String bloodgroup;
    private String room;
    private String job_type;
    private String specialization;
    private String id;

    public Employee(String firstName, String lastName, String qualification, String address, String email, String contact, String password, String gender, String bloodgroup, String room, String job_type, String specialization, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.room = room;
        this.job_type = job_type;
        this.specialization = specialization;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", qualification='" + qualification + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", room='" + room + '\'' +
                ", job_type='" + job_type + '\'' +
                ", specialization='" + specialization + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

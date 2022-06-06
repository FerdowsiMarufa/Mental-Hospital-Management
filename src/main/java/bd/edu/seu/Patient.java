package bd.edu.seu;

public class Patient {
    private String firstName;
    private String lastName;
    private String address;
    private String illness;
    private String docID;
    private String contact;
    private String gender;
    private String room;
    private String bloodgroup;
    private  String id;
    private String  patient_type;

    public Patient(String firstName, String lastName, String address, String illness, String docID, String contact, String gender, String room, String bloodgroup, String id, String patient_type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.illness = illness;
        this.docID = docID;
        this.contact = contact;
        this.gender = gender;
        this.room = room;
        this.bloodgroup = bloodgroup;
        this.id = id;
        this.patient_type = patient_type;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_type() {
        return patient_type;
    }

    public void setPatient_type(String patient_type) {
        this.patient_type = patient_type;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", illness='" + illness + '\'' +
                ", docID='" + docID + '\'' +
                ", contact='" + contact + '\'' +
                ", gender='" + gender + '\'' +
                ", room='" + room + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", id='" + id + '\'' +
                ", patient_type='" + patient_type + '\'' +
                '}';
    }
}

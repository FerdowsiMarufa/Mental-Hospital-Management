package bd.edu.seu;

import javafx.scene.control.Alert;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBActions {
    public DBActions() {
    }
    public Connection getConnection(){
        Connection connection= null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","groot");
            System.out.println("Ok done!!!");
        } catch (SQLException e) {
            System.out.println("Not ok");
        }
        return connection;
    }
    public void insertToEmployees(Employee employee){
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = String.format( "insert into employee (first_name,last_name,qualification,address,email,contact_number,password,gender,blood_group,room,job_type,specialization) values (\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getQualification(),
                    employee.getAddress(),
                    employee.getEmail(),
                    employee.getContact(),
                    employee.getPassword(),
                    employee.getGender(),
                    employee.getBloodgroup(),
                    employee.getRoom(),
                    employee.getJob_type(),
                    employee.getSpecialization());
            statement.execute(query);
            System.out.println(query);
            System.out.println("EMP added!!");
        } catch (SQLException e) {
            System.out.println("HAHa Parena!!");
            e.printStackTrace();
        }
    }
    public boolean CheckDoc( String id){
        boolean emp = false;
        Connection connection = getConnection();
        String query = String.format("select job_type from employee where id = \"%s\";",id);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                 if (resultSet.getString("job_type").equals("Doctor")){
                emp = true;
                     System.out.println("doc");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
            System.out.println("rec");
    }

        return emp;

}
    public void insertToPatients(Patient patient) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into patient (first_name,last_name,illness,address,doctor_id,contact_number,gender,blood_group,room,patient_type ) values (\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getIllness(),
                    patient.getAddress(),
                    patient.getDocID(),
                    patient.getContact(),
                    patient.getGender(),
                    patient.getBloodgroup(),
                    patient.getRoom(),
                    "Admitted");
            statement.execute(query);
            System.out.println(query);
            System.out.println("PAT added!!");
        } catch (SQLException e) {
            System.out.println("HAHa Parena!!");
            e.printStackTrace();
        }
    }
    public boolean LoginAdmin( String id,String pass){
        boolean admin = false;
        Connection connection = getConnection();
        String query = String.format("select password from admin where id = \"%s\";",id);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                if (resultSet.getString("password").equals(pass)){
                    admin = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;

    }
    public boolean RECLogin( String id,String pass){
        boolean emp = false;
        Connection connection = getConnection();
        String query = String.format("select password from employee where (job_type = \"Receptionist\" and id = \"%s\");",id);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                if (resultSet.getString("password").equals(pass)){
                    emp = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;

    }
    public boolean DocLogin( String id,String pass){
        boolean emp = false;
        Connection connection = getConnection();
        String query = String.format("select password from employee where (job_type = \"Doctor\" and id = \"%s\");",id);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                if (resultSet.getString("password").equals(pass)){
                    emp = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;

    }
    public void releasePat(int id, LocalDate releaseddate){
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = String.format("update patient set patient_type = \"%s\",released_date =\"%s\" where id = %d;",
                    "Released", releaseddate,id);
            statement.execute(query);
            System.out.println(query);
            System.out.println("PAT released!!");
        } catch (SQLException e) {
            System.out.println("HAHa Parena!!");
            e.printStackTrace();
        }

    }
    public ArrayList<Patient>DocPatinfo( String id){
        Connection connection = getConnection();
                ArrayList<Patient> patList = new ArrayList<>();
        try  {
            Statement statement = connection.createStatement();
            //String query = String.format("select first_name,illness,gender,blood_group,room from patient where doctor_id = \"%s\";",id);
            String query = String.format("select * from patient where doctor_id = \"%s\";",id);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("first_name");
                System.out.println(name);
                String illness = resultSet.getString("illness");
                String gender  = resultSet.getString("gender");
                String blood_group = resultSet.getString("blood_group");
                String room = resultSet.getString("room");
                Patient patient = new Patient(name,"","" ,illness,"", "",gender,room,blood_group,"","");
                patList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patList;


    }
    public ArrayList<Patient>RecPatinfo(){
        Connection connection = getConnection();
        ArrayList<Patient> patList = new ArrayList<>();
        try  {
            Statement statement = connection.createStatement();
            //String query = String.format("select first_name,illness,gender,blood_group,room from patient where doctor_id = \"%s\";",id);
            String query = String.format("select * from patient where patient_type = \"Admitted\";");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("first_name");
                String nameLast = resultSet.getString("last_name");
                //System.out.println(name);
                String docID = resultSet.getString("doctor_id");
                String room = resultSet.getString("room");
                String address = resultSet.getString("address");
                String illness = resultSet.getString("illness");
                String contact= resultSet.getString("contact_number");
                String gender= resultSet.getString("gender");
                String blood= resultSet.getString("blood_group");
                //String pattype =resultSet.getString("patient_type");

                Patient patient = new Patient(name,nameLast,address ,illness,docID, contact,gender,room,blood,id,"");
                patList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patList;


    }
    public ArrayList<Employee> EMPinfo(){
        Connection connection = getConnection();
        ArrayList<Employee> EMPList = new ArrayList<>();
        try  {
            Statement statement = connection.createStatement();
            //String query = String.format("select first_name,illness,gender,blood_group,room from patient where doctor_id = \"%s\";",id);
            String query = String.format("select * from employee;");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("first_name");
                String Lastname = resultSet.getString("last_name");
                String qualification = resultSet.getString("qualification");
                String address  = resultSet.getString("address");
                String email  = resultSet.getString("email");
                String contact = resultSet.getString("contact_number");
                String gender = resultSet.getString("gender");
                String  blood = resultSet.getString("blood_group");
                String  specialization= resultSet.getString("specialization");
                String  room= resultSet.getString("room");
                //System.out.println(name);
                String jobType = resultSet.getString("job_type");


                Employee employee = new Employee(name,Lastname,qualification,address,email,contact,"",gender,blood,room,jobType,specialization,id);
                EMPList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return EMPList;


    }


}

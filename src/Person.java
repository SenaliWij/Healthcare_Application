public class Person {
    private String name;
    private String dateOfBirth;
    private String contactNum;

    public Person(String name, String dateOfBirth, String contactNum) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactNum = contactNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }
}

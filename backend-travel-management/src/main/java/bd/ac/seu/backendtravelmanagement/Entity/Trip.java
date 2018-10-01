package bd.ac.seu.backendtravelmanagement.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String tripName;
    private String fromWhere;
    private String toWhere;
    private String date;
    private String personName;
    private String contactNo;

    public Trip() {
    }

    public Trip(String tripName, String fromWhere, String toWhere, String date, String personName, String contactNo) {
        this.tripName = tripName;
        this.fromWhere = fromWhere;
        this.toWhere = toWhere;
        this.date = date;
        this.personName = personName;
        this.contactNo = contactNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getToWhere() {
        return toWhere;
    }

    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", tripName='" + tripName + '\'' +
                ", fromWhere='" + fromWhere + '\'' +
                ", toWhere='" + toWhere + '\'' +
                ", date='" + date + '\'' +
                ", personName='" + personName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}

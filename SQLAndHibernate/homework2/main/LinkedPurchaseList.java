package homework2.main;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListId id;

    public void setId(int studentId, int courseId){
        this.id = new LinkedPurchaseListId(studentId, courseId);
    }
    public LinkedPurchaseList() {
    }

    @Data
    @Embeddable
    public static class LinkedPurchaseListId implements Serializable {

        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;

        public LinkedPurchaseListId(int studentId, int courseId) {
            setStudentId(studentId);
            setCourseId(courseId);
        }
        public LinkedPurchaseListId() {
        }
    }
}
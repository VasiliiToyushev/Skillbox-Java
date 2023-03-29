package homework2.main;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey id;

    private int price;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;
    @Data
    @Embeddable
    public static class PurchaseListKey implements Serializable {
        @Column(columnDefinition = "varchar(100)", name = "student_name")
        private String studentName;

        @Column(columnDefinition = "varchar(100)", name = "course_name")
        private String courseName;

    }
}
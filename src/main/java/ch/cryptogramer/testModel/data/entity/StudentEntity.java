package ch.cryptogramer.testModel.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "Student")
public class StudentEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "birth_date")
    private Instant birthDate;
}

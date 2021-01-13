package pl.kanarek.vouchershop.crm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column
    private String firstname;
    @NotNull

    @Column
    private String lastname;

    @NotNull
    @Embedded
    private Address address;
}
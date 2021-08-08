package org.bmn.knowledgemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Table(name = "user_directory")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDirectory {

    @Id
    @GeneratedValue(generator = "id-generator")
    @GenericGenerator(
            name = "id-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "id_sequence"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message=
            "{validation.firstname.NotEmpty.message}")
    @Size(min=1, max=60, message="{validation.firstname.Size.message}")
    @Column(name = "name")
    public String name;
}
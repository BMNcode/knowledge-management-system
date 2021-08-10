package org.bmn.knowledgemanagementsystem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "DIRECTORY")
@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Directory {

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
    @Column(name = "ID", nullable = false)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @NotEmpty(
            message= "{validation.message.directory.name.notEmpty}")
    @Size(
            min=1,
            max=100,
            message="{validation.message.directory.name.size}")
    @Column(name = "NAME", unique = true)
    private String name;

    @ElementCollection
    @CollectionTable(name = "DEPENDENT_DIRECTORY")
    @OrderColumn
    @Column(name = "SUBDIRECTORIES")
    private List<Directory> directories = new ArrayList<>();

    @OneToMany
    @JoinColumn(
            name = "CONTENT_ID",
            nullable = false
    )
    private Collection<Content> contents;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return true;
        if (!(o instanceof Directory)) return false;
        Directory that = (Directory) o;
        return this.getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
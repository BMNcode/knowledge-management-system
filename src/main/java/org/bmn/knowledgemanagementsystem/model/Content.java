package org.bmn.knowledgemanagementsystem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Table(name = "CONTENT")
@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Content{

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
            message= "{validation.message.content.name.notEmpty}")
    @Size(
            min=1,
            max=255,
            message="{validation.message.content.name.size}")
    @Column(name = "NAME", unique = true)
    private String name;

    @NotEmpty(
            message= "{validation.message.content.link.noeEmpty}")
    @Column(name = "LINK", unique = true)
    private String link;

    @Size(max=2040, message="{validation.message.content.comment.size}")
    @Column(name = "COMMENT")
    private String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return true;
        if (!(o instanceof Content)) return false;
        Content that = (Content) o;
        return this.getName().equals(that.getName()) & this.getLink().equals(that.getLink());
    }

    @Override
    public int hashCode() {
        return getName().hashCode() + getLink().hashCode();
    }
}
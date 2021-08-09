package org.bmn.knowledgemanagementsystem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Table(name = "content")
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
    @Column(name = "id", nullable = false)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @NotEmpty(message= "{validation.contentName.NotEmpty.message}")
    @Size(min=1, max=500, message="{validation.contentName.Size.message}")
    @Column(name = "name")
    private String name;

    @NotEmpty(message= "{validation.contentLink.NotEmpty.message}")
    @Column(name = "link")
    private String link;

    @Size(max=2000, message="{validation.commentName.Size.message}")
    @Column(name = "name")
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
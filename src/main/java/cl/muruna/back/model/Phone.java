package cl.muruna.back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "\"phone\"")
@ApiModel(value = "Phone table", description = "Phone table")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Phone {

    @Id
    @ApiModelProperty(value = "Phone Id", hidden = true)
    @Getter
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "number")
    @Column(name = "number", nullable = false)
    @Getter
    @Setter
    private String number;

    @ApiModelProperty(value = "cityCode")
    @Column(name = "cityCode")
    @Getter
    @Setter
    private String cityCode;

    @ApiModelProperty(value = "CountryCode")
    @Column(name = "countryCode")
    @Getter
    @Setter
    private String countryCode;

    @ApiModelProperty(value = "Referencia a user relacionado a phone", hidden = true)
    @ManyToOne
    @Getter
    @Setter
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
}

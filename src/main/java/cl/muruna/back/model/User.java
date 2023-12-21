package cl.muruna.back.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "\"user\"")
@ApiModel(value = "User table", description = "User table")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @ApiModelProperty(value = "User Id", hidden = true)
    @Getter
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ApiModelProperty(value = "Name")
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @ApiModelProperty(value = "Mail")
    @Column(name = "mail")
    @Getter
    @Setter
    private String mail;

    @ApiModelProperty(value = "Password")
    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @ApiModelProperty(value = "Is Active")
    @Column(name = "isActive")
    @Getter
    @Setter
    private Boolean isActive;

    @ApiModelProperty(value = "Date of creation")
    @Column(name = "createdAt", nullable = false)
    @Getter
    @Setter
    @JsonFormat(
            timezone = "America/Santiago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @UpdateTimestamp
    @Column(name = "updateAt", nullable = false)
    @Getter
    @Setter
    @JsonFormat(
            timezone = "America/Santiago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Getter
    @JsonProperty("phones")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Phone> phones = new HashSet<>();

    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }

}

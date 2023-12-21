package cl.muruna.back.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ApiModel(value = "User DTO", description = "User Data Transfer Object")
public class UserDTO {

    @ApiModelProperty(value = "User Id", hidden = true)
    private UUID id;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "password")
    private String password;

    @ApiModelProperty(value = "mail")
    private String mail;

    @ApiModelProperty(value = "isActive")
    private Boolean isActive;

    @ApiModelProperty(value = "date of creation")
    private Date createdAt;

    @ApiModelProperty(value = "phones")
    private List<PhoneDTO> phones;


}
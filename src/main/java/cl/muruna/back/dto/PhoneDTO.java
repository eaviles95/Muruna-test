package cl.muruna.back.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ApiModel(value = "User DTO", description = "User Data Transfer Object")
public class PhoneDTO {

    @ApiModelProperty(value = "phone Id", hidden = true)
    private Integer id;

    @ApiModelProperty(value = "phone")
    private String cityCode;

    @ApiModelProperty(value = "number")
    private String number;

    @ApiModelProperty(value = "CountryCode")
    private String CountryCode;

}
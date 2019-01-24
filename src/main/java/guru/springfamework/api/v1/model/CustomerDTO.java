package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomerDTO {
    private Long id;
    @ApiModelProperty(value = "Customer's last name", required = true)
    private String lastname;
    @ApiModelProperty(value = "Customer's first name", required = true)
    private String firstname;
    @ApiModelProperty(value = "Customer's inro url", required = false)
    @JsonProperty("customer_url")
    private String customerUrl;
}

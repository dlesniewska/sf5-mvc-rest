package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomerDTO {
    private Long id;
    private String lastname;
    private String firstname;
    @JsonProperty("customer_url")
    private String customerUrl;
}

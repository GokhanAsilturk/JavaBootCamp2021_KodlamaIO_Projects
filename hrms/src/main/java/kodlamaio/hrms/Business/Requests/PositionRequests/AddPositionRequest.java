package kodlamaio.hrms.Business.Requests.PositionRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPositionRequest {

    @Size(min = 1,max = 30)
    @NotBlank(message="Position name cannot be left blank!")
    private String name;
}

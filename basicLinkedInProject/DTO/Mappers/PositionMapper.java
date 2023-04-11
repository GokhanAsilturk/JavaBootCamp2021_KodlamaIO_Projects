package kodlamaio.basicLinkedInProject.DTO.Mappers;

import kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests.AddPositionRequest;
import kodlamaio.basicLinkedInProject.DTO.Responses.EmployerResponses.GetAllPositionsResponse;
import kodlamaio.basicLinkedInProject.Entities.DataBaseEntities.Position;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PositionMapperImpl", componentModel = "spring")
public interface PositionMapper {


    Position addPositionRequestToPosition(AddPositionRequest addPositionRequest);

    GetAllPositionsResponse positionGetAllPositionsResponse(Position position);
}

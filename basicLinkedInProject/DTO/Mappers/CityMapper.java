package kodlamaio.basicLinkedInProject.DTO.Mappers;

import kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests.AddCityRequest;
import kodlamaio.basicLinkedInProject.DTO.Responses.EmployerResponses.GetAllCitiesResponse;
import kodlamaio.basicLinkedInProject.Entities.DataBaseEntities.City;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CityMapperImpl", componentModel = "spring")
public interface CityMapper {

    City addCityRequestToCity(AddCityRequest addCityRequest);

    GetAllCitiesResponse cityToAllCitiesResponse(City city);
}

package controller;

import java.util.List;

import com.sun.xml.xsom.impl.Ref.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import model.Status;

public class PetStoreController {
	private static final String BASE_URL = "http://petstore.swagger.io";
	public static String PET_ENDPOINT = BASE_URL + "/pet";
	private RequestSpecification requestSpecification;

	public PetStoreController() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri(BASE_URL);
		requestSpecBuilder.setContentType("JSON");
		requestSpecBuilder.log(LogDetail.ALL);
		requestSpecification = requestSpecBuilder.build();
	}

	public List<Pet> getPetsByStatus(Status status) {
		return given(requestSpecification).queryParam("status", Status.available.toString())
				.get(PET_ENDPOINT + "/findByStatus").then().log().all().extract().body().jsonPath()
				.getList("", Pet.class);

	}

	public Pet addNewPet(Pet pet) {
		return given(requestSpecification).body(pet).post(PET_ENDPOINT).as(Pet.class);
	}
	
	public void deletePet(Pet pet) {
        given(requestSpecification)
                .pathParam("petId", pet.getId())
                .delete(PET_ENDPOINT + "/{petId}");
    }

    public void verifyPetDeleted(Pet pet) {
         given(requestSpecification)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}")
                .then()
                .body(containsString("Pet not found"));
    }

    public Pet findPet(Pet pet) {
        return given(requestSpecification)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}").as(Pet.class);
    }

    public Pet updatePet(Pet pet) {
        return given(requestSpecification)
                .body(pet)
                .put(PET_ENDPOINT).as(Pet.class);
    }
}

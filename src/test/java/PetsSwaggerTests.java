import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import controller.PetStoreController;
import model.Category;
import model.Pet;
import model.Status;

public class PetsSwaggerTests {

	Pet existingPet1,existingPet2;
	PetStoreController store;
	Pet pet = new Pet("3",new Category(3, "dogs"), "Tom", null, null, Status.available);
	
	@BeforeClass
	public void beforeClass() {
		store= new PetStoreController();
		existingPet1 = new Pet("1",new Category(1, "cats"), "Kitty", null, null, Status.available);
		existingPet2 = new Pet("2",new Category(2, "parrot"), "parrot", null, null, Status.available);
		addNewPet(existingPet1);
		addNewPet(existingPet2);
	}

	@Test(priority = 0)
	public void getAllAvailablePets() {
		List<Pet> resp = store.getPetsByStatus(Status.available);
		Assert.assertTrue(resp.get(0).getStatus().equals(Status.available));
		Assert.assertTrue(resp.get(1).getStatus().equals(Status.available));
	}
	
	@Test(priority = 1)
	public void addAndverifyNewPet() {
		addNewPet(pet);
		Pet resp = store.findPet(pet);
		Assert.assertTrue(resp.equals(pet));
	}

	@Test(priority = 2)
	public void updateAndverifyUpdatedPet() {
		updatePet();
		Pet resp = store.findPet(pet);
		Assert.assertTrue(resp.equals(pet));
	}
	
	@Test(priority = 3)
	public void deleteAndVerifyPet() {
		store.deletePet(pet);
		store.verifyPetDeleted(pet);
	}
	
	
	public void updatePet() {
		pet.setStatus(Status.sold);
		Pet resp = store.updatePet(pet);
		Assert.assertTrue(resp.equals(pet));
	}

	
	public void addNewPet(Pet petToAdd) {
		Pet resp = store.addNewPet(petToAdd);
	}
}

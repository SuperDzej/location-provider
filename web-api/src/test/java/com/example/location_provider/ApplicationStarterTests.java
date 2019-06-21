package com.example.location_provider;

import com.example.location_provider.dal.interfaces.ILocationRepository;
import com.example.location_provider.dal.models.Location;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationStarterTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void givenFindAllMethodMocked_WhenFindAllInvoked_ThenMockedValueReturnedAndValueCountCorrect() {
		ILocationRepository localMockRepository = Mockito.mock(ILocationRepository.class);
		List<Location> mockedLocations = new ArrayList<>(){};
		mockedLocations.add(new Location(null, null, null, null));
		mockedLocations.add(new Location(null, null, null, null));
		Mockito.when(localMockRepository.findAll()).thenReturn(mockedLocations);

		List<Location>  locations = localMockRepository.findAll();

		Assert.assertEquals(2, locations.size());
		Mockito.verify(localMockRepository).findAll();
	}

	@Test
	public void givenFindByIdMethodMocked_WhenFindByInvoked_ThenMockedValueIsSameAsReturnedValue() {
		ILocationRepository localMockRepository = Mockito.mock(ILocationRepository.class);
		Location mockedLocation = new Location(null, 43.2, 1.2, "New World");
		Mockito.when(localMockRepository.findById("")).thenReturn(java.util.Optional.of(mockedLocation));

		Optional<Location> location = localMockRepository.findById("");

		Assert.assertTrue(location.isPresent());
		Assert.assertEquals(location.get().getLatitude(), mockedLocation.getLatitude());
		Mockito.verify(localMockRepository).findById("");
	}
}

package com.freefeather.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ApplicationTests {

	@Test
	void createApplicationModuleModel() {
		ApplicationModules modules = ApplicationModules.of(Application.class);
		modules.forEach(System.out::println);
	}

	@Test
	void verifyApplicationModuleModel() {
		ApplicationModules modules = ApplicationModules.of(Application.class);
		modules.verify();
	}

	@Test
	void createModuleDocumentation() {
		ApplicationModules modules = ApplicationModules.of(Application.class);
		new Documenter(modules)
				.writeDocumentation()
				.writeIndividualModulesAsPlantUml();
	}

}

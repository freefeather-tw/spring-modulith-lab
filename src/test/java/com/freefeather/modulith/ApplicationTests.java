package com.freefeather.modulith;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ApplicationTests {

	@Test
	@Order(1)
	void verifyApplicationModuleModel() {
		ApplicationModules modules = ApplicationModules.of(Application.class);
		modules.verify();
	}

	@Test
	@Order(2)
	void createModuleDocumentation() {
		ApplicationModules modules = ApplicationModules.of(Application.class);
		new Documenter(modules)
				.writeDocumentation()
				.writeIndividualModulesAsPlantUml();
	}

}

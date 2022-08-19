package com.example.demo;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import com.example.demo.dto.SkillDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Provider("PactDemoProvider")
// local solution without pact broker
@PactFolder("src/test/resources/pacts")
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
		properties = {
				"server.port=1235"
				// enable if test fails, to get more information in log
//				, "logging.level.au.com.dius.pact=DEBUG"
		}
)
public class UserControllerProviderPactTest {

	@Autowired
	UserService userService;

	@BeforeEach
	void setupTestTarget(PactVerificationContext context) {
		context.setTarget(new HttpTestTarget("localhost", 1235));
	}

	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	void pactVerificationTestTemplate(PactVerificationContext context) {
		// this compares the output of the controller with the expected output defined in pact file
		context.verifyInteraction();
	}

	private static final String USER_ID_PARAM_NAME = "userId";

	@State("User with ${" + USER_ID_PARAM_NAME + "} exists")
	void prepareStateForInteractionsWithExistingUsers(Map<String, BigInteger> stateParameters) {
		int userId = stateParameters.get(USER_ID_PARAM_NAME).intValue();
		UserDto userDto = new UserDto(userId, "The values do not matter...", null);

		SkillDto skillDto = new SkillDto(987, "...because the contract is based on the datatype, " +
				"not exact values");
		userDto.setSkillDtos(Collections.singletonList(skillDto));
		userService.saveUser(userDto);
	}

}
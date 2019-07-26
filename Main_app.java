import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Main_app {

	private static final Logger LOG = Logger.getLogger(Main_app.class.getName());

	public Main_app() {
		LOG.info("producing audi");

		Map<String, Object> carProps = new HashMap<>();
		carProps.put(HasModel.PROPERTY, "A2");
		carProps.put(HasPrice.PROPERTY, 100L);

		Map<String, Object> wheelProperties = new HashMap<>();
		wheelProperties.put(HasType.PROPERTY, "wheel");
		wheelProperties.put(HasModel.PROPERTY, "15C");
		wheelProperties.put(HasPrice.PROPERTY, 100L);

		Map<String, Object> doorProperties = new HashMap<>();
		doorProperties.put(HasType.PROPERTY, "door");
		doorProperties.put(HasModel.PROPERTY, "Lambo");
		doorProperties.put(HasPrice.PROPERTY, 300L);

		carProps.put(HasParts.PROPERTY, Arrays.asList(wheelProperties, doorProperties));

		Audi car = new Audi(carProps);

		LOG.info("Here is our car:");
		LOG.info("-> model:" + car.getModel().get());
		LOG.info("-> price:" + car.getPrice().get());
		LOG.info("-> parts: ");
		car.getParts()
				.forEach(p -> LOG.info(" " + p.getType().get() + " " + p.getModel().get() + " " + p.getPrice().get()));
	}

	public static void main(String[] args) {
		new Main_app();

	}

}

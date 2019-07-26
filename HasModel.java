import java.util.Optional;

public interface HasModel extends Document {

	String PROPERTY = "model";

	default Optional<String> getModel() {
		return Optional.ofNullable((String) get(PROPERTY));

	}

}

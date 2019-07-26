import java.util.Optional;

public interface HasPrice extends Document{

	String PROPERTY = "price";

	default Optional<Number> getPrice() {
		return Optional.ofNullable((Number) get(PROPERTY));
	}

}

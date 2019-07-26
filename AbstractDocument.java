import java.awt.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class AbstractDocument implements Document {

	private final Map<String, Object> properties;

	protected AbstractDocument(Map<String, Object> properties) {
		Objects.requireNonNull(properties, "props map is requered");
		this.properties = properties;
	}

	@Override
	public Void put(String key, Object val) {
		properties.putIfAbsent(key, val);
		return null;
	}

	@Override
	public Object get(String key) {
		properties.get(key);
		return null;
	}

	@Override
	public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
		Optional<List<Map<String, Object>>> any = Stream.of(get(key)).filter(el -> el != null)
				.map(el -> (List<Map<String, Object>>) el).findAny();
		return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName()).append("[");
		properties.entrySet()
				.forEach(e -> builder.append("[").append(e.getKey()).append(" : ").append(e.getValue()).append("]"));
		builder.append("]");
		return builder.toString();
	}

}

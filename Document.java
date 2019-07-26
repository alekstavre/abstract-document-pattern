import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {
	/**
	 * sets key and value
	 * 
	 * @param key
	 * @param val
	 * @return Void
	 */
	Void put(String key, Object val);

	/**
	 * gets key value
	 * 
	 * @param key
	 * @return value or null
	 */
	Object get(String key);

	/**
	 * get the stream of child documents
	 * @param key
	 * @param constructor
	 * @return child documents
	 */

	<T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);

}

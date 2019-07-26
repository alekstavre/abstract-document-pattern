import java.util.Map;

public class Audi extends AbstractDocument implements HasModel,HasPrice,HasParts{
	public Audi(Map<String,Object> properties) {
		super(properties);
	}
}

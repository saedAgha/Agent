package agent.configuration;
 
public interface IConfigurable {
	  String Get(String key);
	  void Set(String key, String value);
}

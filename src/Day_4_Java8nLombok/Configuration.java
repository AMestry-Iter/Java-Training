package Day_4_Java8nLombok;

import lombok.Value;

@Value
public class Configuration {
    String appName;
    String environment;
    int maxConnection;
}

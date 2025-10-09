// File: AppConfigurator.java
class AppConfig {
    private String appName = "My Awesome App";
    private static String appVersion = "1.0";

    public static class NetworkConfig {
        private String host;
        private int port;
        
        public NetworkConfig(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public void displayConfig() {
            System.out.println("App Version: " + AppConfig.appVersion);
            System.out.println("Host: " + this.host + ", Port: " + this.port);
        }
    }
}

public class AppConfigurator {
    public static void main(String[] args) {
        AppConfig.NetworkConfig netConfig = new AppConfig.NetworkConfig("api.server.com", 8080);
        netConfig.displayConfig();
    }
}
package restSharing.ClientRestful;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
@EnableFeignClients //Da non dimenticare!!!
public class ClientRestfulApplication {

	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) {
		context= SpringApplication.run(ClientRestfulApplication.class, args);
	}

	public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(ClientRestfulApplication.class, args.getSourceArgs());
        });

        thread.setDaemon(false);
        thread.start();
    }
}

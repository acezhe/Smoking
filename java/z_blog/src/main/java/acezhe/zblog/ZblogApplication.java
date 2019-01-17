package acezhe.zblog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
/**
 * 应用入口，Springboot 启动
 */
@SpringBootApplication
public class ZblogApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(ZblogApplication.class).run(args);
	}

}


package ctx

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean

@Configuration
class Config {

  @Bean
  public App getApplicationContextProvider() {
    return new App();
  }
}

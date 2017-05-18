package ctx

import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware


/**
 * Gets access to Spring beans and configuration.
 */
class App implements ApplicationContextAware {

    static ApplicationContext context

    @Override
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext

        App.metaClass.static.propertyMissing = { name ->
            App.context.getBean(name)
        }
    }

    static String prop(String key) {
        context.getEnvironment().getProperty(key)
    }

    static String json(Object obj) {
        context.getBean(Class.forName("com.fasterxml.jackson.databind.ObjectMapper")).writeValueAsString(obj)
    }
}

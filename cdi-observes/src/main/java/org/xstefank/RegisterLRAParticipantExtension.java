package org.xstefank;

import org.jboss.logging.Logger;
import org.jboss.resteasy.client.exception.ResteasyRedirectException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanAttributes;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.enterprise.inject.spi.InjectionTargetFactory;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.inject.spi.WithAnnotations;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class RegisterLRAParticipantExtension implements Extension {

    public static final List<Class<?>> names = new ArrayList<>();

    public void register(@Observes @WithAnnotations(RegisterLRAParticipant.class) ProcessAnnotatedType<?> type) {
        Class<?> javaClass = type.getAnnotatedType().getJavaClass();
        String name = javaClass.getName();
        Logger log = Logger.getLogger("SADFSAFDSADF");
        log.error("XXXXXXXXXXXXXXXXXXXX " + name);

        for (Method method : javaClass.getDeclaredMethods()) {
            log.error("XXXXXXXXXXx " + method.getName());    
            log.error("XXXXXXXXXXx " + Arrays.toString(method.getAnnotations()));    
        }

        names.add(javaClass);

    }

    public void observeAfter(@Observes AfterBeanDiscovery afterBeanDiscovery, BeanManager beanManager) {
        Logger.getLogger("ASDFASDFASDFASDFASDF").error("asdfasdfasdfasdf");
        afterBeanDiscovery.addBean()
            .read(beanManager.createAnnotatedType(TestRegistry.class))
            .beanClass(TestRegistry.class)
            .scope(ApplicationScoped.class)
            .name("testRegistry")
            .createWith(creationalContext -> new TestRegistry("my value"));

        BeanAttributes<TestRegistry> beanAttributes = beanManager.createBeanAttributes(beanManager.createAnnotatedType(TestRegistry.class));
        beanManager.createBean(beanAttributes, TestRegistry.class, new InjectionTargetFactory<TestRegistry>() {
            @Override
            public InjectionTarget<TestRegistry> createInjectionTarget(Bean<TestRegistry> bean) {
                return new InjectionTarget<TestRegistry>() {
                    @Override
                    public void inject(TestRegistry testRegistry, CreationalContext<TestRegistry> creationalContext) {
                        
                    }

                    @Override
                    public void postConstruct(TestRegistry testRegistry) {

                    }

                    @Override
                    public void preDestroy(TestRegistry testRegistry) {

                    }

                    @Override
                    public TestRegistry produce(CreationalContext<TestRegistry> creationalContext) {
                        return new TestRegistry("custom value");
                    }

                    @Override
                    public void dispose(TestRegistry testRegistry) {

                    }

                    @Override
                    public Set<InjectionPoint> getInjectionPoints() {
                        return new HashSet<>();
                    }
                };
            }
        });
    }
    
}

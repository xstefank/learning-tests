package org.learn.lt;

public class ServiceLocator {

    private static Cache cache = new Cache();

    public static Service getService(String jndiName) {
        Service service = cache.getService(jndiName);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        service = (Service) context.lookup(jndiName);
        cache.addService(service);
        return service;
    }

}

package io.xstefank;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class JaxRsLikeAnnotationResolver {

    public static <T extends Annotation> T resolveAnnotation(Class<T> annotationClass, Method method) {
        // current method
        T annotation = method.getAnnotation(annotationClass);
        if (annotation != null) {
            return annotation;
        }

        // search the superclass hierarchy
        annotation = resolveAnnotationInSuperClassHierarchy(annotationClass, method, method.getDeclaringClass().getSuperclass());
        if (annotation != null) {
            return annotation;
        }

        // search the implemented interfaces in the hierarchy
        annotation = resolveAnnotationInInterfaces(annotationClass, method, method.getDeclaringClass());
        if (annotation != null) {
            return annotation;
        }

        return null;
    }

    private static <T extends Annotation> T resolveAnnotationInSuperClassHierarchy(Class<T> annotationClass, Method method, Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        try {
            Method superclassMethod = clazz.getMethod(method.getName(), method.getParameterTypes());
            T annotation = superclassMethod.getAnnotation(annotationClass);
            return annotation != null ? annotation : resolveAnnotationInSuperClassHierarchy(annotationClass, method, clazz.getSuperclass());
        } catch (NoSuchMethodException e) {
            return resolveAnnotationInSuperClassHierarchy(annotationClass, method, clazz.getSuperclass());
        }
    }

    private static <T extends Annotation> T resolveAnnotationInInterfaces(Class<T> annotationClass, Method method, Class<?> clazz) {
        if (clazz == null) {
            return null;
        }

        T annotation;
        Method interfaceMethod;

        for (Class<?> anInterface : clazz.getInterfaces()) {
            try {
                interfaceMethod = anInterface.getMethod(method.getName(), method.getParameterTypes());
                annotation = interfaceMethod.getAnnotation(annotationClass);

                if (annotation != null) {
                    return annotation;
                }

            } catch (NoSuchMethodException e) {
                continue;
            }
        }

        return resolveAnnotationInInterfaces(annotationClass, method, clazz.getSuperclass());
    }
}

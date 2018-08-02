package org.xstefank.model;

@FunctionalInterface
public interface PreviewCallback<T> {

    PreviewContent<T> onPreview(T item);
    
}

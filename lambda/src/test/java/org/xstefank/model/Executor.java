package org.xstefank.model;

public class Executor {
    
    private PreviewCallback previewCallback;
    
    public <T> void setPreviewCallback(PreviewCallback<T> previewCallback) {
        this.previewCallback = previewCallback;
        previewCallback.onPreview((T) "string");

    }
}

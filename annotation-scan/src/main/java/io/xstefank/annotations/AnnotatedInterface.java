package io.xstefank.annotations;

@Dummy
public interface AnnotatedInterface {
    
    @Dummy
    void interfaceMethodWithDummy();
    
    void interfaceMethodWithoutDummy();
}

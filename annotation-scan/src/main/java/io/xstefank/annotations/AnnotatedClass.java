package io.xstefank.annotations;

//@Dummy
public class AnnotatedClass implements AnnotatedInterface {
    
    @Dummy
    public void methodWithDummy() {
        
    }
    
    public void methodWithoutDummy() {
        
    }

    @Override
    public void interfaceMethodWithDummy() {
        
    }

    @Override
    public void interfaceMethodWithoutDummy() {

    }
}

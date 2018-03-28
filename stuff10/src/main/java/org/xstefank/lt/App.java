package org.xstefank.lt;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        var s = "World";
        System.out.println( "Hello " + s);

        var list = List.of("new", "java", "10");
        System.out.println(list.getClass());
        System.out.println(list);
    }
}

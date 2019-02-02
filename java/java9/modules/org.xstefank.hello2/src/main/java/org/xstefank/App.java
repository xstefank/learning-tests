package org.xstefank;

import org.xstefank.hi.HiModules;

import static javax.xml.XMLConstants.XML_NS_PREFIX;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello from module");
        System.out.println("The XML namespace prefix is: " + XML_NS_PREFIX);
        
        HiModules hiModules = new HiModules();
        System.out.println(hiModules.getHI());
    }
    
}

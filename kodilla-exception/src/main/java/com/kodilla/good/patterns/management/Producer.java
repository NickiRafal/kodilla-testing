package com.kodilla.good.patterns.management;
import java.util.HashMap;

public interface Producer {
    void process (String supplierInfo, HashMap <String , Integer> productInfo);
}

package edu.uchicago.cs.ucare.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Klogger {
    
    public static final Logger scale = ScaleLogger.logger;
    public static final Logger dual = DualLogger.logger;
    
    private static class ScaleLogger {
        public static final Logger logger = LoggerFactory.getLogger(ScaleLogger.class);
    }
    
    private static class DualLogger {
        public static final Logger logger = LoggerFactory.getLogger(DualLogger.class);
    }

}

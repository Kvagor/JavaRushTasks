package com.javarush.task.task38.task3804;

public class Factory {
    public static Throwable exception(Enum enums) {
        if (enums==null){
            return new IllegalArgumentException();
        }
        if (enums.getClass().getSimpleName().equals("ApplicationExceptionMessage")) {
            String message = "";
            String string = enums.name().replaceAll("_", " ");
            message += string.charAt(0);
            message += string.substring(1).toLowerCase();
            return new Exception(message);
        } else if (enums.getClass().getSimpleName().equals("DatabaseExceptionMessage")) {
            String message = "";
            String string = enums.name().replaceAll("_", " ");
            message += string.charAt(0);
            message += string.substring(1).toLowerCase();
            return new RuntimeException(message);
        } else if (enums.getClass().getSimpleName().equals("UserExceptionMessage")) {
            String message = "";
            String string = enums.name().replaceAll("_", " ");
            message += string.charAt(0);
            message += string.substring(1).toLowerCase();
            return new Error(message);
        }else {
            return new IllegalArgumentException();
        }
    }
}

package com.example.owncdi.annotations;

import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD,ElementType.FIELD,ElementType.TYPE,ElementType.CONSTRUCTOR})
public @interface MySqlConn {
}

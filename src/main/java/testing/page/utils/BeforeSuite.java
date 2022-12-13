package testing.sqa.utils;


import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;



/**
 * Se crea una anotación personalizada porque necesitamos copiar
 * todos los datos del archivo de Excel al archivo .feature antes de comenzar a ejecutar
 *
 */

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)

public @interface BeforeSuite {



}
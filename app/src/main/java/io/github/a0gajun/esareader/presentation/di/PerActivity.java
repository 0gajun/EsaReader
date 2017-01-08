package io.github.a0gajun.esareader.presentation.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Junya on 1/8/17.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}

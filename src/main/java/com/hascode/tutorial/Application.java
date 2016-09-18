package com.hascode.tutorial;

import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import io.bootique.BQCoreModule;
import io.bootique.Bootique;
import io.bootique.jersey.JerseyModule;

public class Application {
    public static void main(String[] args) {
        Module module = binder -> {
            JerseyModule.contributeResources(binder).addBinding().to(DateWebService.class);
            BQCoreModule.contributeCommands(binder).addBinding().to(DateOutputCommand.class);
        };
        Bootique.app(args).module(module).autoLoadModules().run();
    }

    @Provides
    @Singleton
    @Inject
    public DateService provideDateService(@Named("dateFormat") String dateFormat) {
        return new DateService();
    }
}
package com.coutemeier.maven.plugins.asciidoctor.lifecycle;

import static io.takari.maven.testing.TestResources.assertFilesNotPresent;
import static io.takari.maven.testing.TestResources.assertFilesPresent;

import io.takari.maven.testing.executor.MavenRuntime.MavenRuntimeBuilder;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class ThemeMojoIT
extends AbstractMojoIT {
    public ThemeMojoIT( final MavenRuntimeBuilder builder )
    throws Exception {
        super( builder );
    }

    @Test
    public void noThemesConfigured()
    throws Exception {
        forProject( "no-themes-configured" )
            .execute( "theme" )
            .assertErrorFreeLog();
        Assert.assertTrue( validator.themeNotExists() );
    }
}

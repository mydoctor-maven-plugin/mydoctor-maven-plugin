package com.coutemeier.maven.plugins.asciidoctor.lifecycle;

import java.io.File;

public final class FilesValidator {
    private final File basedir;
    private final File mavenBuildDirectory;
    private final File buildDirectory;
    private final File themesDirectory;
    private final File htmlBuildDirectory;
    private final File readmeFile;
    private final File dependencyFile;
    private final File indexFile;
    private final File themeDirectory;
    private final File publishedDirectory;
    private final File publishedIndexFile;

    public FilesValidator( final File basedir ) {
        super();
        this.basedir = basedir;
        this.mavenBuildDirectory = new File( this.basedir, "target" );
        this.buildDirectory = new File( this.mavenBuildDirectory, Constants.BUILDDIRECTORY );
        this.themesDirectory = new File( this.buildDirectory, "themes" );
        this.htmlBuildDirectory = new File( this.buildDirectory, "html5" );
        this.themeDirectory = new File( this.themesDirectory, "theme-example" );
        this.readmeFile = new File( this.themeDirectory, "asciidoc/_templates/readme.adoc" );
        this.dependencyFile = new File( this.mavenBuildDirectory, "dependency/junit-4.11.jar" );
        this.indexFile = new File( this.htmlBuildDirectory, "index.html" );

        this.publishedDirectory = new File( this.mavenBuildDirectory, "publish-repository/publish-to-folder/0.0.1-SNAPSHOT" );
        this.publishedIndexFile = new File( this.publishedDirectory, "index.html" );
    }

    public FilesValidator( final File basedir, String moduleName ) {
        this ( new File( basedir, moduleName ) );
    }

    public boolean indexExists() {
        return this.indexFile.exists();
    }

    public boolean indexNotExists() {
        return !this.indexExists();
    }

    public boolean dependencyExists() {
        return this.dependencyFile.exists();
    }

    public boolean dependencyNotExists() {
        return !this.dependencyExists();
    }

    public boolean readmeExists() {
        return this.readmeFile.exists();
    }

    public boolean readmeNotExists() {
        return !this.readmeExists();
    }

    public boolean themeExists() {
        return this.themeDirectory.exists();
    }

    public boolean themeNotExists() {
        return !this.themeExists();
    }

    public boolean themeFilesExists() {
        return this.themeExists() && this.readmeExists();
    }

    public boolean themeFilesNotExists() {
        return !this.themeFilesExists();
    }

    public boolean generatedFilesExists() {
        return this.indexExists();
    }

    public boolean generatedFilesNotExists() {
        return ! this.generatedFilesExists();
    }

    public boolean publishedFilesExists() {
        return this.publishedDirectory.exists() && this.publishedIndexFile.exists();
    }

    public boolean publishedFilesNotExists() {
        return ! this.publishedFilesExists();
    }
}

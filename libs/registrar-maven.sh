#!/bin/sh
echo "tfs.sdk"
mvn install:install-file -Dfile=com.microsoft.tfs.sdk-11.0.0.jar -DgroupId=com.microsoft -DartifactId=tfs.sdk -Dversion=11.0.0 -Dpackaging=jar
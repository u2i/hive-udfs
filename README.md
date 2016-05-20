# Hive User Defined Functions

This repository is an util repository for user defined functions which could be added as a Jar on Hive.

## Building package

`mvn package`

## Including it on hive

Enter beeline then using this command: `add jar <<path to hive utils jar>>`

## Possible erros

If you need hive in version 0.11.0 you might have problems with packaging it using maven as there is a bug in hive-exec.
To fix this download [JDO](http://www.datanucleus.org/downloads/maven2/javax/jdo/jdo2-api/2.3-ec/jdo2-api-2.3-ec.jar).
Then install it to your local maven repository using command:
`mvn install:install-file -DgroupId=javax.jdo -DartifactId=jdo2-api -Dversion=2.3-ec -Dpackaging=jar -Dfile=jdo2-api-2.3-ec.jar`.
For more information look at https://issues.apache.org/jira/browse/HIVE-4114

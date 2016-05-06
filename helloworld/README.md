#Steps to prepare your environment

This project aims to validate if your dev environment is ready! Not necessary to look at the code, we will dive into it during the nightClazz.
To prepare your laptop, you need to install three things : 
 
 * java 8
 * SBT
 * Setup your favorite IDE to work with Lagom framework

##Install Java 8
if you come to this nigthClazz, I am sure that it is trivial for you to install (or update) your JDK ;)

##Install SBT

To install SBT follow the guide [here](http://www.scala-sbt.org/release/docs/Setup.html)

Run project to download all dependencies at least once (to be autonomous from internet connection the D-day) run the following command from **lagom-java's** directory.

    sbt runAll

When the project is started, from a browser (or curl) run the following query : 

    http://localhost:8000/services
  
Server should answer this : 

    [{"name":"hellostream","url":"http://0.0.0.0:26230"},{"name":"cas_native","url":"tcp://127.0.0.1:4000/cas_native"},{"name":"helloservice","url":"http://0.0.0.0:24266"}]

*remarks : ports can be different*

Now your environment is OK.

## Setup your favorite IDE
Although the Lagom framework is agnostic with to the IDE, due to the library [Immutable](http://immutables.github.io/) used by the framework, Lagom is using  annotation processor to generate code. 
Follow the guide [here](http://www.lagomframework.com/documentation/1.0.x/ImmutablesInIDEs.html)


Once steps above done, you are ready for the hands on!

If you need help, feel free to ask me on this email : fabrice[dot]sznajderman[@]zenika[dot]com

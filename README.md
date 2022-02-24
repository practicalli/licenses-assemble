# practicalli/licenses-assemble

When distributing software it is a legal requirement to also distribute the licenses for that software.  Licenses Assemble checks the licenses of project dependencies (via clojure.tools....) and

## Installation

Download from https://github.com/practicalli/licenses-assemble

## Usage

Run the greet function via `:exec-fn`:

    $ clojure -X:greet
    Hello, Clojure!

Run the greet function with arguments, overriding the name to be greeted:

    $ clojure -X:greet :name '"Someone"'
    Hello, Someone!

Run the `-main` function of the project via `:main-opts` (`-m practicalli.licenses-assemble`):

    $ clojure -M:main
    Hello, World!

Run the `-main` function of the project with arguments, overriding the name to be greeted:

    $ clojure -M:main Via-Main
    Hello, Via-Main!

Run the project's tests (they'll fail until you edit them):

    $ clojure -T:build test

> this fails, probably because I renamed the aliases

Run the project's CI pipeline and build an uberjar (this will fail until you edit the tests to pass):

    $ clojure -T:build ci

This will produce an updated `pom.xml` file with synchronized dependencies inside the `META-INF`
directory inside `target/classes` and the uberjar in `target`. You can update the version (and SCM tag)
information in generated `pom.xml` by updating `build.clj`.

If you don't want the `pom.xml` file in your project, you can remove it. The `ci` task will
still generate a minimal `pom.xml` as part of the `uber` task, unless you remove `version`
from `build.clj`.

Run that uberjar:

    $ java -jar target/licenses-assemble-0.1.0-SNAPSHOT.jar

If you remove `version` from `build.clj`, the uberjar will become `target/licenses-assemble-standalone.jar`.

## License

Copyright © 2022 Practicalli

Distributed under the Creative Commons Attribution Share-Alike 4.0 International

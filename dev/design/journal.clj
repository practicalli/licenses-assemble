;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Design journal for Licenses Assemble
;;
;; Experiments that elicited the design and tests for the project
;; Include :env/design alias from practicalli/clojure-deps-edn when starting the REPL
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(ns design.journal
  "design experiments for the development of the project")

#_{:clj-kondo/ignore [:redefined-var]}
(comment
  ;; Add-lib library for hot-loading
  (require '[clojure.tools.deps.alpha.repl :refer [add-libs]])
  (add-libs '{domain/library-name {:mvn/version "1.0.0"}}))
   ;; End of rich comment block

#_{:clj-kondo/ignore [:redefined-var]}
(comment

  ;; licenses.edn file created with Clojure CLI
  ;; `clojure -X:deps list :format :edn` from an en existing project

  ;; output of this command could be to a licences.edn file using the :format :edn option
  ;; or include the namespace and call the functions from within this project (simpler for the user)

  ;; Read in the licenses.edn file
  ;; clojure.edn or slurp or clojure.java.io ?

  ;; From: https://github.com/clojure-cookbook/clojure-cookbook/blob/master/04_local-io/4-14_read-write-clojure-data-structures.asciidoc

  ;; Use read to efficiently read large data structures from a stream:
  ;; binding *read-eval* to false prevents clojure.core/read from evaluating the edn being read
  ;; - useful if the edn is not from a full trusted source
  (with-open [edn-resource (java.io.PushbackReader. (clojure.java.io/reader "licenses.edn"))]
    (binding [*read-eval* false]
      (read edn-resource)))

;; clojure.edn
  (clojure.edn/read-string (slurp "licenses.edn"))

  ;; Is pushbackreader required with clojure.edn?
  ;; Yes, its required for clojure.edn/read
  (with-open [edn-resource (java.io.PushbackReader. (clojure.java.io/reader "licenses.edn"))]
    (clojure.edn/read edn-resource))

  ;; Fail:
  (with-open [edn-resource (clojure.java.io/reader "licenses.edn")]
    (binding [*read-eval* false]
      (clojure.edn/read edn-resource)))

;; Why use java.io.PushbackReader - to help parse the content as forms ?
  ;; From: http://tutorials.jenkov.com/java-io/pushbackreader.html
  ;; The Java PushbackReader class, java.io.PushbackReader, is intended to be used when you parse data from a Reader. Sometimes you need to read ahead a few characters to see what is coming, before you can determine how to interpret the current character. The Java PushbackReader allows you to do that. Well, actually it allows you to push back the read characters into the Reader. These characters will then be read again the next time you call read().

;; Get all the licenses to download

  ;; Download a licence to /docs/licenses
  ;; - making them an option to serve via GitHub pages /docs directory
  ;; http-client to get the files?
  ;; try-catch required ?

  #_()) ;; End of rich comment

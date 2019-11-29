#!/usr/bin/env bash
#-- Antlr4 path:
CLASSPATH=/usr/local/Cellar/antlr/4.7.2/antlr-4.7.2-complete.jar

#-- + Grammar path:
export CLASSPATH="${CLASSPATH}:/Users/mauget/IdeaProjects/calculator/parser/target/classes"

echo CLASSPATH: ${CLASSPATH}

#-- Call TestRig with command line parameters
java org.antlr.v4.gui.TestRig "$@"
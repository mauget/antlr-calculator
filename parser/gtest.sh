#!/usr/bin/env bash
#-- Antlr4 path (here, to Mac Homebrew tree)
CP=/usr/local/Cellar/antlr/4.7.2/antlr-4.7.2-complete.jar

#-- Append Grammar path (here, to generated classes in Maven target)
CP="${CP}:/Users/mauget/IdeaProjects/calculator/parser/target/classes"

#-- Call TestRig with command line parameters
#-- E.g. ./gtest.sh com.rogersalumni.calculator.g4.Calculator start -gui <expression.txt
java -cp ${CP} org.antlr.v4.gui.TestRig "$@"
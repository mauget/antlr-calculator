#!/usr/bin/env bash
# Run this script from parser project root
#
#-- Antlr4 path (here, installed by Mac Homebrew)
CP=/usr/local/Cellar/antlr/4.7.2/antlr-4.7.2-complete.jar
#
#-- Append Grammar path relative to project's Maven target classes
CP="${CP}:./target/classes"
#
#-- Call TestRig with command line parameters
#-- E.g. ./gtest.sh com.rogersalumni.calculator.g4.Calculator start -gui <expression.txt
java -cp ${CP} org.antlr.v4.gui.TestRig "$@"
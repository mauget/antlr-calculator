echo off
rem -- Antlr4 path (here, to local "mauget" user's java directory)
set CP=c:\users\mauget\java\antlr-4.7.2-complete.jar

rem -- Append Grammar path (here, to generated classes in Maven target)
set CP=%CP%;c:\users\mauget\IdeaProjects\calculator\parser\target\classes

rem -- Call TestRig with command line parameters
rem -- E.g. gtest.cmd com.rogersalumni.calculator.g4.Calculator start -gui <expression.txt
java -cp %CP% org.antlr.v4.gui.TestRig %1 %2 %3 %4 %5
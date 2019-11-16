package com.rogersalumni.calculator.desktop

import com.rogersalumni.calculator.CalculatorApp
import com.rogersalumni.calculator.CalculatorAppImpl
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class DesktopView : View() {
    private val controller: DesktopController by inject()
    private val input = SimpleStringProperty()

//    override val root = form {
//        fieldset {
//            field("Arithmetic expression") {
//                textfield(input)
//            }
//
//            button("Evaluate") {
//                action {
//                    controller.evalEpression(input.value)
//                    input.value =""
//                }
//            }
//        }
//    }

    override val root = vbox {
        hbox {
            textfield() {
                textProperty().addListener { _, old, new ->
                    println("=")
                }
            }
        }
        hbox {
            button("C") {
            }
            button("\u00B1") {
            }
            button("%") {
            }
            button("\u00F7") {
            }
        }
        hbox {
            button("7") {
            }
            button("8") {
            }
            button("9") {
            }
            button("\u2A09") {
            }
        }
        hbox {
            button("4") {
            }
            button("5") {
            }
            button("6") {
            }
            button("\u2212") {// -
            }
        }
        hbox {
            button("1") {
            }
            button("2") {
            }
            button("3") {
            }
            button("\uFF0B") {// +
            }
        }
        hbox {
            button("0") {
                style {
                    minWidth = 4.em
                }
            }
            button(".") {
            }
            button("=") {
            }
        }

//        button("LOGIN") {
//            useMaxWidth = true
//            action {
//                println("qqqqqq")
//            }
//        }
    }
}

class DesktopController : Controller() {
    private val calcEngine: CalculatorApp = CalculatorAppImpl()

    fun evalEpression(inputValue: String) {
        val result: Double = calcEngine.calculate(inputValue)
        println("$inputValue = $result")
    }
}

class DesktopApp : App(DesktopView::class, Styles::class) {

    companion object {
        fun create(): DesktopApp = DesktopApp()
    }

    init {
        reloadStylesheetsOnFocus()
    }
}

fun main(args: Array<String>) {
    launch<DesktopApp>()
}

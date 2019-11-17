package com.rogersalumni.calculator.desktop

import com.rogersalumni.calculator.CalculatorApp
import com.rogersalumni.calculator.CalculatorAppImpl
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class DesktopView : View() {
    private val controller: DesktopController by inject()
    private val input = SimpleStringProperty()

    override val root = vbox {
        addClass(Styles.wrapper)

        hbox {
            textfield() {
                textProperty().addListener { cur, old, new ->
                    println("=" + cur + old + new)
                }
            }
        }
        hbox {
            button("C") {
                style {
                    backgroundColor += Styles.operationBgDarkColor
                }
            }
            button("\u00B1") {
                style {
                    backgroundColor += Styles.operationBgDarkColor
                }
            }
            button("mod") {
                style {
                    fontSize = 28.px
                    backgroundColor += Styles.operationBgDarkColor
                }
            }
            button("\u00F7") {
                style {
                    backgroundColor += Styles.operationBgColor
                }
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
                style {
                    backgroundColor += Styles.operationBgColor
                }
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
                style {
                    backgroundColor += Styles.operationBgColor
                }
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
                style {
                    backgroundColor += Styles.operationBgColor
                }
            }
        }
        hbox {
            button("0") {
                style {
                    minWidth = 168.px
                }
            }
            button(".") {
            }
            button("=") {
                style {
                    backgroundColor += Styles.operationBgColor
                }
            }
        }

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

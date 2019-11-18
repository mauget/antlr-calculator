package com.rogersalumni.calculator.desktop

import com.rogersalumni.calculator.CalculatorApp
import com.rogersalumni.calculator.CalculatorAppImpl
import javafx.scene.control.TextField
import tornadofx.*

class DesktopView : View() {
    private var calcTextField: TextField by singleAssign()
    private var expression: String = ""

    private val controller = DesktopController()
    private val opCodes = setOf("+", "-", "*", "/", "(", ")", "%", "uminus")

    override val root = vbox {
        addClass(Styles.wrapper)

        hbox {
            calcTextField = textfield("0") {
                requestFocus()
                textProperty().addListener { evt, _, _ ->
                    println(evt.value)
                }
                style {
                    backgroundColor += Styles.operationBgDarkColor
                    textFill = Styles.fontColor
                }
            }
        }
        hbox {
            button("C") {
                style {
                    backgroundColor += Styles.operationBgDarkColor
                }
                action {
                    resetCalculator()
                }
            }
            button("\u00B1") {
                style {
                    backgroundColor += Styles.operationBgDarkColor
                }
                action {
                    accept("uminus")
                }
            }
            button("mod") {
                style {
                    fontSize = 28.px
                    backgroundColor += Styles.operationBgDarkColor
                }
                action {
                    accept("%")
                }
            }
            button("\u00F7") {
                style {
                    backgroundColor += Styles.operationBgColor
                }
                action {
                    accept("/")
                }
            }
        }
        hbox {
            button("7") {
                action {
                    accept("7")
                }
            }
            button("8") {

                action {
                    accept("8")
                }
            }
            button("9") {
                action {
                    accept("9")
                }
            }
            button("\u2A09") {
                style {
                    backgroundColor += Styles.operationBgColor
                }
                action {
                    accept("+")
                }
            }
        }
        hbox {
            button("4") {
                action {
                    accept("4")
                }
            }
            button("5") {
                action {
                    accept("5")
                }
            }
            button("6") {
                action {
                    accept("6")
                }
            }
            button("\u2212") {
                // -
                style {
                    backgroundColor += Styles.operationBgColor
                }
                action {
                    accept("-")
                }
            }
        }
        hbox {
            button("1") {
                action {
                    accept("1")
                }
            }
            button("2") {
                action {
                    accept("2")
                }
            }
            button("3") {
                action {
                    accept("3")
                }
            }
            button("\uFF0B") {
                // +
                style {
                    backgroundColor += Styles.operationBgColor
                }
                action {
                    accept("+")
                }
            }
        }
        hbox {
            button("0") {
                style {
                    minWidth = 168.px
                }
                action {
                    accept("0")
                }
            }
            button(".") {
                action {
                    accept(".")
                }
            }
            button("=") {
                style {
                    backgroundColor += Styles.operationBgColor
                }
                action {
                    calcTextField.text = controller.evalEpression(expression).toString()
                    expression = calcTextField.text
                }
            }
        }

    }

    init {
        this.title = "Calculator"
        this.resetCalculator()
    }

    private fun resetCalculator() {
        expression = ""
        calcTextField.text = "0"
    }

    private fun accept(arg: String) {
        expression += arg

        if (calcTextField.text == "0") {
            calcTextField.text = ""
        }
        if (!opCodes.contains(arg)) {
            calcTextField.text += arg
        } else {
            calcTextField.text = ""
        }
    }
}

class DesktopController : Controller() {
    private val calcEngine: CalculatorApp = CalculatorAppImpl()

    fun evalEpression(inputValue: String): Double {
        return calcEngine.calculate(inputValue)
    }
}

class DesktopApp : App(DesktopView::class, Styles::class) {

    companion object {
//        fun create(): DesktopApp = DesktopApp()
    }

    init {
        reloadStylesheetsOnFocus()
    }
}

fun main() {
    launch<DesktopApp>()
}

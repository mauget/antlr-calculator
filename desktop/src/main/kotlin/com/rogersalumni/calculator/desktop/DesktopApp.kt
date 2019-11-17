package com.rogersalumni.calculator.desktop

import com.rogersalumni.calculator.CalculatorApp
import com.rogersalumni.calculator.CalculatorAppImpl
import javafx.scene.control.TextField
import tornadofx.*

class DesktopView : View() {
    private val controller = DesktopController()
    private var calcTextField: TextField by singleAssign()

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
                    calcTextField.text = "0"
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
                action {
                    println("7 pressed")
                }
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
            button("\u2212") {
                // -
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
            button("\uFF0B") {
                // +
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
                action {
                    val mockInput = "-1+2*20+1"
                    println(mockInput + " = " + controller.evalEpression(mockInput))
                }
            }
        }

    }
}

class DesktopController : Controller() {
    private val calcEngine: CalculatorApp = CalculatorAppImpl()

    fun evalEpression(inputValue: String) : Double {
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

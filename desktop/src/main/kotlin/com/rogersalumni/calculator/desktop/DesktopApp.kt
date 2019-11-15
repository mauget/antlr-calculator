package com.rogersalumni.calculator.desktop

import com.rogersalumni.calculator.CalculatorApp
import com.rogersalumni.calculator.CalculatorAppImpl
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class DesktopView : View() {
    private val controller: DesktopController by inject()
    private val input = SimpleStringProperty()

    override val root = form {
        fieldset {
            field("Arithmetic expression") {
                textfield(input)
            }

            button("Evaluate") {
                action {
                    controller.evalEpression(input.value)
                    input.value = ""
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

class DesktopApp : App() {
    override val primaryView = DesktopView::class

    companion object {
        fun create(): DesktopApp = DesktopApp()
    }
}

fun main(args: Array<String>) {
    launch<DesktopApp>()
}

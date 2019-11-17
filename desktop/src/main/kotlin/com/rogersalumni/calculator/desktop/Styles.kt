package com.rogersalumni.calculator.desktop

import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        // Globql styles
        val wrapper by cssclass()
        var defaultBorderWidth = box(2.px)

        // Colors
        var defaultBgColor = c("#999999")
        val numberBgColor = c("#606060")
        val operationBgColor = c("#D2691E")
        val operationBgDarkColor = c("#444444")
        val fontColor = c("#dddddd")
        var defaultBorderColor = box(c("#999999"))
    }

    init {
        wrapper {
            backgroundColor += defaultBgColor
            borderWidth += defaultBorderWidth
            borderColor += defaultBorderColor
        }

        button {
            fontSize = 40.px
            padding = box(5.px, 10.px)
            minWidth = 84.px
            maxWidth = 80.px
            minHeight = 70.px
            backgroundColor += numberBgColor
            textFill = fontColor
            borderWidth += defaultBorderWidth
            borderColor += defaultBorderColor

        }

        textField {
            fontSize = 30.px
            padding = box(6.px)
            minWidth = 336.px
            maxWidth = 336.px
            borderWidth += defaultBorderWidth
            borderColor += defaultBorderColor
        }


    }
}
package com.rogersalumni.calculator.desktop

import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        // Define styles
        val wrapper by cssclass()

        // Define colors
//        val dangerColor = c("#a94442")
//        val hoverColor = c("#d49942")
    }

    init {
        wrapper {
            padding = box(6.px)
        }

        button {
            fontSize = 40.px
            padding = box(5.px, 10.px)
            minWidth = 2.em

        }

        textField {
            fontSize = 20.px
            padding = box(6.px)
            spacing = 10.px
            minWidth = 16.em
            maxWidth = 16.em
        }
    }
}
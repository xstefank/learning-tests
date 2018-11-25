package org.xstefank.groovy

def name = params.name ?: "World"

html.html {
    head {
        title "Hello from Groovlet!"
    }
    body {
        h1 "Hello, ${name}!"
    }
}

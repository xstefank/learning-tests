package org.acme.rest

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
class NativeGreetingResourceIT : GreetingResourceTest()
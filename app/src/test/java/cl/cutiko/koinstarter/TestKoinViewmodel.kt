package cl.cutiko.koinstarter

import org.junit.Assert.assertNotNull
import org.junit.Test


class TestKoinViewmodel : KoinBaseTest() {

    @Test
    fun `can say hello`() {
        val text = helloViewmodel.sayHello()
        assertNotNull(text)
    }

    @Test
    fun `can repo hello`() {
        val text = helloRepository.getHello()
        assertNotNull(text)
    }
}

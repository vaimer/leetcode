package strings.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class SimplifyPathTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("/home/", "/home"),
            of("/../", "/"),
            of("/home//foo/", "/home/foo"),
            of("/a/./b/../../c/", "/c"),
            of("/a/../../b/../c//.//", "/c"),
            of("/a//b////c/d//././/..", "/a/b/c"),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the simplified path`(path: String, expected: String) {
        assertEquals(expected, SimplifyPath.simplifyPath(path))
    }
}
